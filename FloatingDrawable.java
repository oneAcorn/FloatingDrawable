package com.acorn.weightrecorder.drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;


/**
 * 圆形悬浮StateListDrawable
 * Created by Acorn on 2015/8/31.
 */
public class FloatingDrawable extends StateListDrawable {
    private static final int DEFAULT_COLOR = 0xffffffff;
    private static final int DEFAULT_PRESS_COLOR = 0xfff5f5f5;
    private static final int DEFAULT_SHADOW_COLOR = Color.DKGRAY;
    private int size;
    private Paint paint;
    private int color;
    private int pressColor;
    private int shadowColor;
    private int radius;
    private int shadowRadius;
    private int shadowOffset = 2;

    public FloatingDrawable() {
        this(DEFAULT_COLOR, DEFAULT_PRESS_COLOR, DEFAULT_SHADOW_COLOR);
    }

    public FloatingDrawable(int color, int pressColor) {
        this(color, pressColor, DEFAULT_SHADOW_COLOR);
    }

    public FloatingDrawable(int color, int pressColor, int shadowColor) {
        this.color = color;
        this.pressColor = pressColor;
        this.shadowColor = shadowColor;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
    }

    @Override
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.drawCircle(bounds.centerX(), bounds.centerY(), radius, paint);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        computeSize(bounds);
    }

    private void computeSize(Rect bounds) {
        size = Math.min(bounds.width(), bounds.height());
        shadowRadius = size / 10 / 2;
        shadowOffset = shadowRadius * 4 / 5;
        radius = size * 9 / 10 / 2 - shadowOffset;
        paint.setShadowLayer(shadowRadius, 0, shadowOffset, shadowColor);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter cf) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicWidth() {
        return size;
    }

    @Override
    public int getIntrinsicHeight() {
        return size;
    }

    @Override
    protected boolean onStateChange(int[] stateSet) {
        if (size != 0 && contains(stateSet, android.R.attr.state_enabled)) {
            if (contains(stateSet, android.R.attr.state_pressed)) {
                paint.setShadowLayer(shadowRadius / 2, 0, shadowOffset, shadowColor);
                paint.setColor(pressColor);
                invalidateSelf();
            } else {
                paint.setShadowLayer(shadowRadius, 0, shadowOffset, shadowColor);
                paint.setColor(color);
                invalidateSelf();
            }
        }
        return super.onStateChange(stateSet);
    }

    private boolean contains(int[] states, int state) {
        boolean res = false;
        for (int i = 0; i < states.length; i++) {
            if (states[i] == state) {
                res = true;
                break;
            }
        }
        return res;
    }
}
