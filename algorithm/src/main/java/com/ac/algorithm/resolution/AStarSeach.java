package com.ac.algorithm.resolution;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * AStarSeach
 * 根据估值确定搜索路径，启发式搜索
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class AStarSeach {

    private static final int[][] MAZE = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
    };

    public static Grid aStarSearch(Grid start, Grid end) {
        List<Grid> openList = new ArrayList<>();
        List<Grid> closeList = new ArrayList<>();
        /**
         * 1.起点放入openList
         */
        openList.add(start);

        while (openList.size() > 0) {
            /**
             * 从openList找到f值最小的节点
             */
            Grid currentGrid = findMinFGrid(openList);
            openList.remove(currentGrid);
            closeList.add(currentGrid);
            /**
             * 找到临近的节点
             */
            List<Grid> neighbors = findNeighbors(currentGrid, openList, closeList);
            for (Grid neighbor : neighbors) {
                if (!openList.contains(neighbor)) {
                    neighbor.init(currentGrid, end);
                    openList.add(neighbor);
                }
            }
            /**
             * 判断是否已经到终点，即openList包含了end；
             */
            for (Grid grid : openList) {
                if (end.x == grid.x && end.y == grid.y) {
                    return grid;
                }
            }

        }
        return null;
    }

    /**
     * 找到临近节点
     *
     * @param minFGrid
     * @param openList
     * @param closeList
     * @return
     */
    private static List<Grid> findNeighbors(Grid minFGrid, List<Grid> openList, List<Grid> closeList) {

        List<Grid> grids = new ArrayList<>();
        /**
         * 分别搜索上下左右的相邻节点
         */
        if (isValidGrid(minFGrid.x, minFGrid.y - 1, openList, closeList)) {
            grids.add(new Grid(minFGrid.x, minFGrid.y - 1));
        }
        if (isValidGrid(minFGrid.x, minFGrid.y + 1, openList, closeList)) {
            grids.add(new Grid(minFGrid.x, minFGrid.y + 1));
        }
        if (isValidGrid(minFGrid.x - 1, minFGrid.y, openList, closeList)) {
            grids.add(new Grid(minFGrid.x - 1, minFGrid.y));
        }
        if (isValidGrid(minFGrid.x + 1, minFGrid.y, openList, closeList)) {
            grids.add(new Grid(minFGrid.x + 1, minFGrid.y));
        }
        return grids;
    }

    private static boolean isValidGrid(int x, int y, List<Grid> openList, List<Grid> closeList) {
        /**
         * 判断是否超过界限
         */
        if (x < 0 || x >= MAZE.length || y < 0 || y >= MAZE[0].length) {
            return false;
        }
        /**
         * 是否有障碍物
         */
        if (MAZE[x][y] == 1) {
            return false;
        }

        /**
         * 是否包含在openList
         */
        if (containGrid(x, y, openList)) {
            return false;
        }
        /**
         * 是否包含在closeList
         */
        if (containGrid(x, y, closeList)) {
            return false;
        }

        return true;
    }

    private static boolean containGrid(int x, int y, List<Grid> openList) {

        for (Grid grid : openList) {
            if (grid.x == x && grid.y == y) {
                return true;
            }
        }
        return false;

    }

    /**
     * 从openList找到f值最小的节点
     *
     * @param openList
     * @return
     */
    private static Grid findMinFGrid(List<Grid> openList) {
        /**
         * 将第一个的f设置为默认最小f。
         */
        Grid minFGrid = openList.get(0);
        for (Grid grid : openList) {
            if (grid.f < minFGrid.f) {
                minFGrid = grid;
            }
        }

        return minFGrid;
    }

    public static void main(String[] args) {
        Grid start = new Grid(2, 1);
        Grid end = new Grid(2, 5);
        Grid destGrid = aStarSearch(start, end);
        /**
         * 回溯搜索路径
         */
        List<Grid> path = new ArrayList<>();
        while (null != destGrid) {
            path.add(new Grid(destGrid.x, destGrid.y));
            destGrid = destGrid.parent;
        }

        for (int i = 0; i < MAZE.length; i++) {
            for (int j = 0; j < MAZE[i].length; j++) {
                if (containGrid(i, j, path)) {
                    System.out.print("*,");
                } else {
                    System.out.print(MAZE[i][j] + ",");
                }
            }
            System.out.println();

        }
    }
}
