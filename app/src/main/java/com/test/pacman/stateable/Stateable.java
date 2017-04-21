package com.test.pacman.stateable;

import android.graphics.Canvas;
import android.graphics.Paint;


public abstract class Stateable {
    public Paint paint;
    public Stateable(){
        paint = new Paint();
    }
    public abstract void draw(Canvas canvas);
}
