package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.stateable.StateView;
import com.test.pacman.stateable.Stateable;
import com.test.pacman.view.PersonView;


public class StateMove extends Stateable{
    private int type = 0;
    private StateView view;
    public StateMove(int type,StateView view){
        this.type = type;
        this.view = view;
    }
    @Override
    public void draw(Canvas canvas) {
        switch (type){
            case PersonView.STATE_MOVE_DOWN:view.setY(view.getY() + 10);break;
            case PersonView.STATE_MOVE_LEFT:view.setX(view.getX() - 10); break;
            case PersonView.STATE_MOVE_RIGHT: view.setX(view.getX()  + 10);break;
            case PersonView.STATE_MOVE_UP: view.setY(view.getY() - 10);break;
        }
        view.setStates(PersonView.STATE_DEFAULT);
    }
    public void setType(int type){
        this.type = type;
    }
}
