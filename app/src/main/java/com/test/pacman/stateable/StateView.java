package com.test.pacman.stateable;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.HashMap;

/**
 * Created by asdf on 2017/4/20.
 */

public class StateView extends View{
    private HashMap<String,Stateable> states = new HashMap<>();
    public StateView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
