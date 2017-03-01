package com.dirmidante.ndd.football;

import android.app.Application;
import android.content.Context;

import com.dirmidante.ndd.football.injections.components.CompetitionDetailComponent;
import com.dirmidante.ndd.football.injections.components.DaggerCompetitionDetailComponent;
import com.dirmidante.ndd.football.injections.components.DaggerCompetitonsListComponent;
import com.dirmidante.ndd.football.injections.modules.CompetitionDetailModule;
import com.dirmidante.ndd.football.injections.modules.CompetitionsListModule;
import com.dirmidante.ndd.football.injections.components.CompetitonsListComponent;

import io.realm.Realm;


public class FootballApplication extends Application {


    private static FootballApplication sInstance;
    private static CompetitonsListComponent sCompetitonsListComponent;
    private static CompetitionDetailComponent sCompetitonDetailComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initRealm();
        sCompetitonsListComponent = buildCompetitionsListComponent();
        sCompetitonDetailComponent = buildCompetitionDetailComponent();
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

    public static CompetitionDetailComponent getCompetitonDetailComponent() {
        return sCompetitonDetailComponent;
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
    protected CompetitionDetailComponent buildCompetitionDetailComponent(){
       return DaggerCompetitionDetailComponent.builder()
                .competitionDetailModule(new CompetitionDetailModule())
                .build();
    }


}
