package com.ac.algorithm.resolution;

/**
 * Grid
 *
 * @author <a href="mailto:angrycow1111@gmail.com">angrycow1111</a>
 * @since 2019/9/10
 */
public class Grid {
    int x;
    int y;
    Grid parent;
    int g;
    int f;
    int h;


    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void init(Grid parent, Grid end) {
        this.parent = parent;
        if (parent != null) {
            this.g = parent.g + 1;
        } else {
            this.g = 1;
        }

        this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
        this.f = this.g + this.h;
    }
}
