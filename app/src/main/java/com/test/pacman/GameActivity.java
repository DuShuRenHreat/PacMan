package com.test.pacman;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.test.pacman.view.PersonView;

public class GameActivity extends Activity implements View.OnTouchListener{
    private Button btn_left,btn_right,btn_top,btn_bottom;
    private  PersonView personView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_game);
        personView = new PersonView(this);
        layout.addView(personView);
        personView.raize();

        initView();
    }


    public void initView(){
        btn_bottom = (Button) findViewById(R.id.btn_bottom);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_top = (Button) findViewById(R.id.btn_top);
        btn_left.setOnTouchListener(this);
        btn_top.setOnTouchListener(this);
        btn_bottom.setOnTouchListener(this);
        btn_right.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                switch (view.getId()){
                    case R.id.btn_bottom:
                        personView.move(PersonView.STATE_MOVE_DOWN);
                        break;
                    case R.id.btn_left:
                        personView.move(PersonView.STATE_MOVE_LEFT);
                        break;
                    case R.id.btn_right:
                        personView.move(PersonView.STATE_MOVE_RIGHT);
                        break;
                    case R.id.btn_top:
                        personView.move(PersonView.STATE_MOVE_UP);
                        break;
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("test","app:" + "up");
                break;
        }
        return false;
    }
}
