package com.kasib.stl.sign;

/**
 * Created by pasencukviktor on 08.11.13
 */

public class Point {
    protected final float x;
    protected final float y;
    protected final float p;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
        p = 0;
    }

    public Point(float x, float y, float p) {
        this.x = x;
        this.y = y;

        if (p > 1)
            this.p = 1;
        else
            this.p = p;
    }


    protected static Point between(Point first, Point second) {
        return new Point((second.x + first.x) / 2.0f, (second.y + first.y) / 2.0f);
    }

    protected Point subtract(Point point) {
        return new Point(x - point.x, y - point.y, p);
    }
}

