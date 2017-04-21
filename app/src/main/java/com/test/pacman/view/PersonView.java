package com.test.pacman.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;

import com.test.pacman.BitMapCache.BitMapCache;
import com.test.pacman.R;
import com.test.pacman.stateable.StateView;
import com.test.pacman.stateable.shiti.StateDefault;
import com.test.pacman.stateable.shiti.StateEnd;
import com.test.pacman.stateable.shiti.StateMove;

public class PersonView extends StateView{
    public static final int[][] imgs = {
            {R.drawable.pic_down_1,R.drawable.pic_down_2,R.drawable.pic_down_3,R.drawable.pic_down_4},
            {R.drawable.pic_left_1,R.drawable.pic_left_2,R.drawable.pic_left_3,R.drawable.pic_left_4},
            {R.drawable.pic_right_1,R.drawable.pic_right_2,R.drawable.pic_right_3,R.drawable.pic_right_4},
            {R.drawable.pic_up_1,R.drawable.pic_up_2,R.drawable.pic_up_3,R.drawable.pic_up_4}

    };
    public static final int STATE_MOVE_LEFT = 1;
    public static final int STATE_MOVE_UP = 3;
    public static final int STATE_MOVE_RIGHT = 2;
    public static final int STATE_MOVE_DOWN = 0;
    public static final String STATE_MOVE = "move";
    public static final String STATE_DEFAULT = "default";
    public static final String STATE_END = "end";
    private int I_width = 0;
    private int I_height = 0;
    private StateMove move = null;
    public PersonView(Context context) {
        super(context);
        move = new StateMove(STATE_MOVE_RIGHT,this);
        this.addState(STATE_DEFAULT,new StateDefault(this));
        this.addState(STATE_END,new StateEnd());
        this.addState(STATE_MOVE,move);
        this.setStates(STATE_DEFAULT);
    }
    public void raize(){
        Bitmap bitmap = BitMapCache.create(R.drawable.pic_down_1);
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.width  = bitmap.getWidth();
        lp.height = bitmap.getHeight();
        setLayoutParams(lp);
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        ViewGroup layout = ((ViewGroup)this.getParent());
        I_height = layout.getMeasuredHeight();
        I_width = layout.getMeasuredWidth();
        move.setBoundary(I_width,I_height);

    }
    public void move(int type){
        this.setStates(PersonView.STATE_MOVE,type);
    }

    public void play(){
        this.setStates(STATE_DEFAULT);
    }
    public void end(){
        this.setStates(STATE_END);
    }
}
