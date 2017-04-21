package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.stateable.Stateable;

/**
 * Created by asdf on 2017/4/21.
 */

public class StateEnd extends Stateable {
    public StateEnd(){
        super();
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawLine(0,0,100,100,paint);
    }
}
