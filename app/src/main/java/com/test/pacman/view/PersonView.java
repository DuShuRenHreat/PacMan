package com.test.pacman.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import com.test.pacman.stateable.Stateable;

public class PersonView extends View{
    private Stateable stateable;

    public PersonView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
