package com.test.pacman;

import android.app.Application;

import com.test.pacman.BitMapCache.BitMapCache;

/**
 * Created by asdf on 2017/4/21.
 */

public class MyAppliaction extends Application {
    private BitMapCache cache;

    @Override
    public void onCreate() {
        super.onCreate();
        cache = new BitMapCache(this);
    }


}
