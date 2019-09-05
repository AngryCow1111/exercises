package com.ac.algorithm.xiaohui;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/4
 */
public class LevelTraveralForRecursion {
    static int leftcount = 0;
    static int rightcount = 0;
    static Queue<TreeNode> queue = new LinkedList<>();

    public static TreeNode createTree(LinkedList<Integer> linkedList) {

        if (CollectionUtils.isEmpty(linkedList)) {
            return null;
        }
        Integer data = linkedList.removeFirst();
        TreeNode node = null;
        if (null != data) {
            node = new TreeNode(data);

            node.left = createTree(linkedList);
            node.right = createTree(linkedList);
        }

        return node;
    }


    public static void levelTraveral(TreeNode root) {

        TreeNode treeNode = root;
        queue.offer(treeNode);
        while (true) {
            if (leftcount == 0) {
                if (null != treeNode.left) {

                    levelTraveral(treeNode.left);
                    leftcount++;
                }
            } else {
                leftcount = 0;
            }

            if (rightcount == 0) {
                if (null != treeNode.right) {
                    levelTraveral(treeNode.right);
                    rightcount++;
                }

            } else {
                rightcount = 0;
            }
            continue;
        }


    }

    public static void main(String[] args) {
        TreeNode tree = createTree(new LinkedList<>(Arrays.asList(1, 2, 4, null, null, 5, null, null, 3, null, 6, null, null)));
        levelTraveral(tree);
    }
}
