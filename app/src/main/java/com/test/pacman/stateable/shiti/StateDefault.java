package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.stateable.Stateable;

/**
 * Created by asdf on 2017/4/20.
 */

public class StateDefault extends Stateable {
    public StateDefault(){
        super();

    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(150,150,200,200,paint);
    }
}
