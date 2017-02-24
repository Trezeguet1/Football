package com.dirmidante.ndd.football;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.injections.CompetitionsListModule;
import com.dirmidante.ndd.football.injections.CompetitonsListComponent;
import com.dirmidante.ndd.football.injections.DaggerCompetitonsListComponent;

import io.realm.Realm;


public class FootballApplication extends Application {


    private static FootballApplication sInstance;
    private static CompetitonsListComponent sCompetitonsListComponent;

    @Override

    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initRealm();
        sCompetitonsListComponent = buildCompetitionsListComponent();
    }

    protected void initRealm() {
        Realm.init(this);
    }

    /**
     * @return Context of Application. (Application typecast to Context)
     */
    public static Context getCurrentApplicationContext() {
        return sInstance;
    }


    /**
     * @return Current Application instance.
     */
    public static FootballApplication getInstance() {
        return sInstance;
    }

    public static CompetitonsListComponent getCompetitonsListComponent() {
        return sCompetitonsListComponent;
    }

    protected CompetitonsListComponent buildCompetitionsListComponent(){
       return DaggerCompetitonsListComponent.builder()
                .competitionsListModule(new CompetitionsListModule())
                .build();
    }


}
