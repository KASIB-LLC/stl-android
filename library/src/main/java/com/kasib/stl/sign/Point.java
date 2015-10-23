package com.kasib.stl.sign;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pasencukviktor on 08.11.13
 */

public class Point {
    protected final float X;
    protected final float Y;
    protected final float P;

    public Point(float x, float y) {
        X = x;
        Y = y;
        P = 0;
    }

    public Point(float x, float y, float p) {
        X = x;
        Y = y;
        if (p > 1) P = 1;
        else P = p;
    }


    protected static Point between(Point first, Point second) {
        return new Point((second.X + first.X) / 2.0f, (second.Y + first.Y) / 2.0f);
    }

    protected Point subtract(Point point) {
        return new Point(X - point.X, Y - point.Y, P);
    }

    protected JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("p", P);
            jsonObject.put("y", (int) Y);
            jsonObject.put("x", (int) X);
        } catch (JSONException ignored) {
        }
        return jsonObject;
    }

    @Override
    public String toString() {
        return "{\"x\":" + (int) X + ",\"y\":" + (int) Y + ",\"p\":" + (int) P + "}";
    }
}

