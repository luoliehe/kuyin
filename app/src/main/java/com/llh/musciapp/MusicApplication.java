package com.llh.musciapp;

import android.app.Application;
import android.content.Context;

/**
 * MusicApp Application
 */
public class MusicApplication extends Application {
    private static Context ctx;


    @Override
    public void onCreate() {
        super.onCreate();
        ctx = getApplicationContext();
    }

    /**
     * 获得Context对象
     * @return
     */
    public static Context getContext(){
        return ctx;
    }
}
