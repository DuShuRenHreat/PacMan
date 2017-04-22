package com.test.pacman;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import com.test.pacman.messager.Mess;
import com.test.pacman.messager.Messager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Messager.getInstance().register(this);
        Message msg = new Message();
        msg.what = 91;
        Messager.post("Book",msg);
    }

    @Mess("Book")
    public void test(Message msg){
        Log.e("Tset","test输出" + msg.what);
    }

    @Mess("Book")
    public void test1(Message msg){
        Log.e("Tset","test1输出" + msg.what);
    }

}
