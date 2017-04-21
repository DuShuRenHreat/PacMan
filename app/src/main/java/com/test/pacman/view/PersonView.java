package com.test.pacman.view;

import android.content.Context;

import com.test.pacman.R;
import com.test.pacman.stateable.StateView;
import com.test.pacman.stateable.shiti.StateDefault;
import com.test.pacman.stateable.shiti.StateEnd;

public class PersonView extends StateView{
    public static final int[][] imgs = {
            {R.drawable.pic_down_1,R.drawable.pic_down_2,R.drawable.pic_down_3,R.drawable.pic_down_4},
            {R.drawable.pic_left_1,R.drawable.pic_left_2,R.drawable.pic_left_3,R.drawable.pic_left_4},
            {R.drawable.pic_right_1,R.drawable.pic_right_2,R.drawable.pic_right_3,R.drawable.pic_right_4},
            {R.drawable.pic_up_1,R.drawable.pic_up_2,R.drawable.pic_up_3,R.drawable.pic_up_4}

    };

    public static final String STATE_DEFAULT = "default";
    public static final String STATE_END = "end";
    public PersonView(Context context) {
        super(context);
        this.addState(STATE_DEFAULT,new StateDefault());
        this.addState(STATE_END,new StateEnd());
        this.setStates(STATE_DEFAULT);
    }
    public void play(){
        this.setStates(STATE_DEFAULT);
    }
    public void end(){
        this.setStates(STATE_END);
    }
}
