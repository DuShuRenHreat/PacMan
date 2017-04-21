package com.test.pacman.stateable.shiti;

import android.graphics.Canvas;

import com.test.pacman.BitMapCache.BitMapCache;
import com.test.pacman.R;
import com.test.pacman.stateable.StateView;
import com.test.pacman.stateable.Stateable;

/**
 * Created by asdf on 2017/4/20.
 */

public class StateDefault extends Stateable {
    private int playID = 0;
    private StateView view = null;
    public StateDefault(final StateView view){
        super();
        this.view = view;
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
    public int whichOne(){
        return ++playID == 4 ? playID = 0 : playID;
    }
    @Override
    public void draw(Canvas canvas) {
        switch (whichOne()){
            case 0: canvas.drawBitmap(BitMapCache.create(R.drawable.pic_down_1),0,0,paint);break;
            case 1: canvas.drawBitmap(BitMapCache.create(R.drawable.pic_down_2),0,0,paint);break;
            case 2: canvas.drawBitmap(BitMapCache.create(R.drawable.pic_down_3),0,0,paint);break;
            case 3: canvas.drawBitmap(BitMapCache.create(R.drawable.pic_down_4),0,0,paint);break;
        }

    }
}
