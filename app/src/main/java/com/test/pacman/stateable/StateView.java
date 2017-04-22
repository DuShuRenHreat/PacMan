package com.test.pacman.stateable;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import com.test.pacman.stateable.shiti.StateDefault;
import com.test.pacman.stateable.shiti.StateMove;
import java.util.HashMap;

public class StateView extends View{
    public OnDrawLinstener linstener = null;
    private String type = null;
    private HashMap<String,Stateable> states = new HashMap<>();
    public StateView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.states.get(type).draw(canvas);
    }
    public void setStates(String type,int direction){
        this.type = type;
        ((StateMove)this.states.get(type)).setType(direction);
    }
    public void setDefalutStates(String type,int direction){
        this.type = type;
        ((StateDefault)this.states.get(type)).setType(direction);
    }
    public void setStates(String type){
        this.type = type;
        updateDraw();
    }
    public void addState(String type ,Stateable stateable){
        states.put(type,stateable);
    }
    public boolean isMainLoop(){
        return Looper.getMainLooper() == Looper.myLooper();
    }
    public void updateDraw(){
        if(isMainLoop()){
            invalidate();
        }else{
            postInvalidate();
        }
    }
    public void setOnDrawLinstener(OnDrawLinstener onDrawLinstener){
        linstener = onDrawLinstener;
    }
    public interface OnDrawLinstener{
        public void OnDraw(int x,int y);
    }

}
