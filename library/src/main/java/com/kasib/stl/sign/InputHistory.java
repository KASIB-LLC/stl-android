package com.kasib.stl.sign;

/**
 * Created by pasencukviktor on 08.11.13
 */

import android.graphics.Path;

import com.kasib.stl.parameters.Sign;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения введенных данных и данных для отрисовки
 */
class InputHistory {

    private Path mCurrentGraphPath;
    private List<Path> mGraphPaths = new ArrayList<>();
    private List<Point> mGraphPoints = new ArrayList<>();
    private List<Point> mSignPoints = new ArrayList<>();
    private List<Float> mAvgPressures = new ArrayList<>();
    private List<Float> mPointPressures = new ArrayList<>();


    private static final float OFFSET_IS_NOT_A_POINT = 1.0f;
    private List<Point> mCurrentInput = new ArrayList<Point>();


    public InputHistory() {

    }

    protected Path getCurrentGraphPath() {
        return mCurrentGraphPath;
    }

    protected List<Path> getGraphPaths() {
        return mGraphPaths;
    }

    protected List<Point> getGraphPoints() {
        return mGraphPoints;
    }

    protected List<Float> getAvgPressures() {
        return mAvgPressures;
    }

    protected List<Float> getPointPressures() {
        return mPointPressures;
    }

    protected void startObject(float x, float y, float p) {
        mCurrentInput.clear();
        final Point startPoint = new Point(x, y, p);
        mCurrentInput.add(startPoint);
        mSignPoints.add(startPoint);
        mCurrentGraphPath = new Path();
    }

    protected void updateObject(float x, float y, float p) {
        final Point currentPoint = new Point(x, y, p);
        final Point lastPoint = mCurrentInput.get(mCurrentInput.size() - 1);
        mCurrentInput.add(currentPoint);
        mSignPoints.add(currentPoint);
        updateGraphHistory(currentPoint, lastPoint);
    }

    protected void updateGraphHistory(Point currentPoint, Point lastPoint) {
        final Point pathPoint = Point.between(lastPoint, currentPoint);
        if (mCurrentInput.size() == 2) {
            mCurrentGraphPath.moveTo(pathPoint.X, pathPoint.Y);
        } else {
            mCurrentGraphPath.quadTo(lastPoint.X, lastPoint.Y, pathPoint.X, pathPoint.Y);
        }
    }

    protected void endObject() {
        if (isPoint(mCurrentInput)) {
            mGraphPoints.add(mCurrentInput.get(0));
            mPointPressures.add(mCurrentInput.get(0).P);
        } else {
            mGraphPaths.add(mCurrentGraphPath);
            float totalPressures = 0;
            for (Point point : mCurrentInput) {
                totalPressures += point.P;
            }
            mAvgPressures.add(totalPressures / mCurrentInput.size());
        }
        mCurrentGraphPath = null;
    }

    protected void clear() {
        clearGraphInfo();
    }

    protected Sign getSign() {
        final Sign points = new Sign();
        final Point minPoint = getMinimumPoint(mSignPoints);
        for (Point point : mSignPoints)
            points.add(point.subtract(minPoint));
        return points;
    }

    private Point getMinimumPoint(List<Point> points) {
        Point minPoint = points.get(0);
        float minX = minPoint.X;
        float minY = minPoint.Y;

        for (Point point : points) {
            if (point.X < minX)
                minX = point.X;
            if (point.Y < minY)
                minY = point.Y;
        }
        return new Point(minX, minY);
    }

    private void clearGraphInfo() {
        mGraphPaths.clear();
        mGraphPoints.clear();
        mSignPoints.clear();
        mAvgPressures.clear();
        mPointPressures.clear();
        mCurrentGraphPath = null;
    }


    private boolean isPoint(List<Point> mPoints) {
        final float firstX = mPoints.get(0).X;
        final float firstY = mPoints.get(0).Y;
        for (Point point : mPoints) {
            if (Math.abs(point.X - firstX) > OFFSET_IS_NOT_A_POINT || Math.abs(point.Y - firstY) > OFFSET_IS_NOT_A_POINT) {
                return false;
            }
        }
        return true;
    }


}
