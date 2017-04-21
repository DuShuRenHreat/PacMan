package com.test.pacman.BitMapCache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;


public class BitMapCache {
    private static Context c;
    public BitMapCache(Context context){
       this.c = context;
    }
    private static HashMap<Integer,Bitmap> bitmapcache = new HashMap<>();
    public static Bitmap create(Integer resID){
        for(Integer i : bitmapcache.keySet()){
            if(i == resID){
                return bitmapcache.get(resID);
            }
        }
        Bitmap bitmap = null;
        bitmap = BitmapFactory.decodeResource(c.getResources(),resID);
        bitmapcache.put(resID,bitmap);
        return bitmap;

    }
}
