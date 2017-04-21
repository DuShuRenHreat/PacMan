package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.stateable.StateView;
import com.test.pacman.view.PersonView;


public class StateMove extends StateDefault{
    private int type = 0;
    private StateView view;
    private int mWidth = 0;
    private int mHeight = 0;
    public StateMove(int type,StateView view){
        this.type = type;
        this.view = view;
    }

    public StateMove(StateView view) {
        super(view);
    }
    public void setBoundary(int width,int height){
        this.mHeight = height;
        this.mWidth = width;
    }
    @Override
    public void draw(Canvas canvas) {
        float x = view.getX();
        float y = view.getY();
        switch (type){
            case PersonView.STATE_MOVE_DOWN:
                if(y  + view.getHeight() >= mHeight ){
                    view.setDefalutStates(PersonView.STATE_DEFAULT,PersonView.STATE_MOVE_DOWN);
                }else{
                    view.setY(view.getY() + 10);
                }
                break;
            case PersonView.STATE_MOVE_LEFT:
                if(x <= 0){
                    view.setDefalutStates(PersonView.STATE_DEFAULT,PersonView.STATE_MOVE_LEFT);
                }else{
                    view.setX(view.getX() - 10);
                }
                break;
            case PersonView.STATE_MOVE_RIGHT:
                if(x  + view.getWidth() >= mWidth){
                    view.setDefalutStates(PersonView.STATE_DEFAULT,PersonView.STATE_MOVE_RIGHT);
                }else{
                    view.setX(view.getX()  + 10);
                }
                break;
            case PersonView.STATE_MOVE_UP:
                if(y <= 0){
                    view.setDefalutStates(PersonView.STATE_DEFAULT,PersonView.STATE_MOVE_UP);
                }else{
                    view.setY(view.getY() - 10);
                }
                break;
        }
        super.setType(type);
        super.draw(canvas);
    }

    public void setType(int type){
        this.type = type;
    }
}
