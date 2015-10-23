package com.kasib.stl.sign;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.kasib.stl.network.parameters.Sign;

import java.io.FileOutputStream;


/**
 * Created by pasencukviktor on 08.11.13
 */

public class SignView extends View {

    private InputHistory mInputHistory;
    private Drawer mDrawer;

    public SignView(Context context) {
        super(context);
        init();
    }

    public SignView(Context context, AttributeSet attires) {
        super(context, attires);
        init();
    }

    public SignView(Context context, AttributeSet attires, int defStyle) {
        super(context, attires, defStyle);
        init();
    }

    private void init() {
        this.setBackgroundColor(Color.WHITE);
        mInputHistory = new InputHistory();
        mDrawer = new Drawer();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                onDown(event.getX(), event.getY(), event.getPressure());
                return true;
            case MotionEvent.ACTION_MOVE:
                onMove(event.getX(), event.getY(), event.getPressure());
                return true;
            case MotionEvent.ACTION_UP:
                onEnd();
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void onDown(float x, float y, float p) {
        mInputHistory.startObject(x, y, p);
    }

    private void onMove(float x, float y, float p) {
        mInputHistory.updateObject(x, y, p);
        invalidate();
    }

    private void onEnd() {
        mInputHistory.endObject();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDrawer.draw(canvas, mInputHistory, getWidth(), getHeight());
    }

    public void clear() {
        mInputHistory.clear();
        invalidate();
    }

    public void setColor(int color) {
        mDrawer.setColor(color);
        invalidate();
    }

    public Bitmap getSignBitmap() {
        final Bitmap bitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        mDrawer.draw(canvas, mInputHistory, getWidth(), getHeight());
        return bitmap;
    }

    public void setStrokeWidth(float width) {
        mDrawer.setStrokeWidth(width);
        invalidate();
    }

    public void saveFile(FileOutputStream outputStream) throws Exception {
        Bitmap bitmap = getSignBitmap();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        outputStream.flush();
        outputStream.close();
    }

    public Sign getSign() {
        return mInputHistory.getSign();
    }
}
