package com.test.pacman.messager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by asdf on 2017/4/22.
 */

public class Subscriber {
    private Object context;
    private Method method;
    public Subscriber(Object object,Method method){
        this.context = object;
        this.method = method;
    }
    public Object getContext(){
        return context;
    }

    public void post(Object message){
        try {
           // Log.e("invoke", String.format("target: %s, message: %d", context.getClass().getSimpleName(), message.hashCode()));
            method.invoke(context,message);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
