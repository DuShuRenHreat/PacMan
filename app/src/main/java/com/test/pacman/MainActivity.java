package com.test.pacman;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;

import com.test.pacman.messager.Messager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Messager.getInstance().register(this);
        Message msg = new Message();
        msg.what = 91;
    }

}
