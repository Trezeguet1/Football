package com.dirmidante.ndd.football.injections;

import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.CompetitionsListPresenter;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;

import javax.annotation.Nullable;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dima on 22.02.2017.
 */

@Module
public class CompetitionsListModule {



    @Provides
    public ICompetitionsListPresenter providePresenter(IFootballDataAPI api, IRealmHelper db){
        return new CompetitionsListPresenter (api, db);
    }

    @Provides
    public IFootballDataAPI provideAPI(){
        return new FootballDataAPI();
    }

    @Provides
    public IRealmHelper provideDB(){
        return new RealmHelper();
    }



}
