package com.kasib.stl.sign;

/**
 * Created by pasencukviktor on 08.11.13
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

class Drawer {

    private float mStrokeWidth = 3.0f;

    private Paint mLinesPaint;
    private Paint mPointsPaint;
    private Paint mBackgroundPaint;
    private int mColor;


    protected Drawer() {
        mColor = Color.BLACK;
        initLinesPaint();
        initPointsPaint();
        initBackgroundPaint();
    }

    protected void setStrokeWidth(float width) {
        mStrokeWidth = width;
        mLinesPaint.setStrokeWidth(mStrokeWidth);
        mPointsPaint.setStrokeWidth(mStrokeWidth);
    }

    private void initLinesPaint() {
        mLinesPaint = new Paint();
        mLinesPaint.setAntiAlias(true);
        mLinesPaint.setStrokeWidth(mStrokeWidth);
        mLinesPaint.setColor(Color.BLACK);
        mLinesPaint.setStyle(Paint.Style.STROKE);
        mLinesPaint.setStrokeJoin(Paint.Join.ROUND);
    }

    private void initPointsPaint() {
        mPointsPaint = new Paint();
        mPointsPaint.setAntiAlias(true);
        mPointsPaint.setStrokeWidth(5.0f);
        mPointsPaint.setColor(Color.BLACK);
    }

    private void initBackgroundPaint() {
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(Color.TRANSPARENT);
    }


    protected void setColor(int color) {
        if (mColor != color) {
            mPointsPaint.setColor(color);
            mLinesPaint.setColor(color);
            mColor = color;
        }
    }

    protected void draw(Canvas canvas, InputHistory inputHistory, int width, int height) {
        canvas.drawRect(0, 0, width, height, mBackgroundPaint);
        if (inputHistory.getCurrentGraphPath() != null) {
            canvas.drawPath(inputHistory.getCurrentGraphPath(), mLinesPaint);
        }
        for (int i = 0; i < inputHistory.getGraphPoints().size(); i++) {
            final Point point = inputHistory.getGraphPoints().get(i);
            final float avgPressure = inputHistory.getPointPressures().get(i);
            if (avgPressure == 0) mPointsPaint.setStrokeWidth(mStrokeWidth);
            else mPointsPaint.setStrokeWidth(mStrokeWidth * avgPressure);
            canvas.drawPoint(point.X, point.Y, mPointsPaint);
        }
        for (int i = 0; i < inputHistory.getGraphPaths().size(); i++) {
            final Path path = inputHistory.getGraphPaths().get(i);
            final float avgPressure = inputHistory.getAvgPressures().get(i);
            if (avgPressure == 0) mLinesPaint.setStrokeWidth(mStrokeWidth);
            else mLinesPaint.setStrokeWidth(mStrokeWidth * avgPressure);
            canvas.drawPath(path, mLinesPaint);
        }
    }
}
