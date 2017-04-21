package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.BitMapCache.BitMapCache;
import com.test.pacman.stateable.StateView;
import com.test.pacman.stateable.Stateable;
import com.test.pacman.view.PersonView;


public class StateDefault extends Stateable {
    private int playID = 0;
    private int type = -1;
    public StateDefault(final StateView view){
        super();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (;;){
                    view.postInvalidate();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public StateDefault() {
    }

    public int whichOne(){
        return ++playID == 4 ? playID = 0 : playID;
    }
    @Override
    public void draw(Canvas canvas) {
        if(type == -1){
            type = PersonView.STATE_MOVE_RIGHT;
        }
        switch (whichOne()){
            case 0: canvas.drawBitmap(BitMapCache.create(PersonView.imgs[type][0]),0,0,paint);break;
            case 1: canvas.drawBitmap(BitMapCache.create(PersonView.imgs[type][1]),0,0,paint);break;
            case 2: canvas.drawBitmap(BitMapCache.create(PersonView.imgs[type][2]),0,0,paint);break;
            case 3: canvas.drawBitmap(BitMapCache.create(PersonView.imgs[type][3]),0,0,paint);break;
        }
    }
    public void setType(int type){
        this.type = type;
    }
}
