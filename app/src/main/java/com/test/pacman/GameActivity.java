package com.test.pacman;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.test.pacman.view.MyMapView;
import com.test.pacman.view.PersonView;

public class GameActivity extends Activity implements View.OnTouchListener{
    private Button btn_left,btn_right,btn_top,btn_bottom;
    private  PersonView personView;
    private MyMapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);
        LinearLayout personlayout = (LinearLayout) findViewById(R.id.activity_game);
        FrameLayout maplayout = (FrameLayout) findViewById(R.id.map_layout);

        personView = new PersonView(this);
     /*   personlayout.addView(personView);
        personView.raize();
*/
        map = new MyMapView(this);
        maplayout.addView(map);
        map.raize();

        maplayout.addView(personView);
        personView.raize();
        map.addMan(personView);

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
                        map.setType(PersonView.STATE_MOVE_DOWN);
                        break;
                    case R.id.btn_left:
                        personView.move(PersonView.STATE_MOVE_LEFT);
                        map.setType(PersonView.STATE_MOVE_LEFT);
                        break;
                    case R.id.btn_right:
                        personView.move(PersonView.STATE_MOVE_RIGHT);
                        map.setType(PersonView.STATE_MOVE_RIGHT);
                        break;
                    case R.id.btn_top:
                        personView.move(PersonView.STATE_MOVE_UP);
                        map.setType(PersonView.STATE_MOVE_UP);
                        break;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }


}
