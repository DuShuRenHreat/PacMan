package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.test.pacman.stateable.Stateable;

/**
 * Created by asdf on 2017/4/20.
 */

public class StateDefault extends Stateable {
    public StateDefault(){

    }
    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.drawLine(0,0,50,50,paint);
    }
}
