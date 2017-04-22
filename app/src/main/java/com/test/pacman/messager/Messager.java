package com.test.pacman.messager;

import android.util.Log;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asdf on 2017/4/22.
 */

public class Messager {
    private static HashMap<Class<?> ,List<Subscriber>> subs = new HashMap<>();
    private static Messager messager = null;
    public static Messager getInstance(){
        if(messager == null){
            synchronized (Messager.class){
                if(messager == null){
                    messager = new Messager();
                }
            }
        }
        return messager;
    }
    /*
    *
    * */
//    public static void post(Class<?> tClass){
//        List<Subscriber> list = subs.get(tClass);
//        if (list == null) {
//            Log.e("test","没有此订阅者");
//            return;
//        }
//        for (Subscriber subscriber : list) {
//            subscriber.psot();
//        }
//    }

    public static void post(String msg,Object message){
        List<Subscriber> list = subs.get(message.getClass());
        if (list == null) {
            Log.e("test","没有此订阅者");
            return;
        }

        for (Subscriber subscriber : list) {
      //      Log.e("post", subscriber.hashCode() + "");
            subscriber.post(message);
        }
    }

    public void register(Object context){
        for (Method method : context.getClass().getDeclaredMethods()){
            Mess mess = method.getAnnotation(Mess.class);
            if(mess != null){
                if(method.getParameterTypes().length == 1){
                    Class<?> c = method.getParameterTypes()[0];
                   // Log.e("put","FirstTypeClassName: " + c.getSimpleName() + " ContextClassName: " + context.getClass().getSimpleName() + " MethodName: " + method.getName());
                    putValue(c,context,method);
                }
            }
        }
    }

    public void putValue(Class<?> tCalss,Object context,Method method){
        List<Subscriber> list = this.subs.get(tCalss);
        if (list == null) list = new ArrayList<>();
        list.add(new Subscriber(context,method));
        subs.put(tCalss,list);
        Log.e("register", String.format("%s 已注册 %s", context.getClass().getSimpleName(), method.getName()));
    }


    public static void close(Object context){
        for(Class<?> c : subs.keySet()){
            if(c == context.getClass()){
                List<Subscriber> list = subs.get(c);
                for(Subscriber s: list){
                    if(s.getContext() == context){
                        list.remove(s);
                    }
                }
            }
        }
    }
}
