package com.dirmidante.ndd.football;

import android.app.Application;
import android.content.Context;


public class FootballApplication extends Application {

    private static FootballApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    /**@return Context of Application. (Application typecast to Context) */
    public static Context getCurrentApplicationContext() {
        return sInstance;
    }


    /**@return Current Application instance.*/
    public static FootballApplication getInstance() {
        return sInstance;
    }
}
