package com.dirmidante.ndd.football.injections.modules;

import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.CompetitionDetailPresenter;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Dima on 28.02.2017.
 */

@Module
public class CompetitionDetailModule {

    @Provides
    public ICompetitionDetailPresenter providePresenter(IFootballDataAPI api, IRealmHelper db){
        return new CompetitionDetailPresenter(api, db);
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
