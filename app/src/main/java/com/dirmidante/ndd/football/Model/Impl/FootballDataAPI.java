package com.dirmidante.ndd.football.Model.Impl;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Model.IFootballDataAPI;
import com.dirmidante.ndd.football.Model.IFootballDataService;

import java.util.List;

import io.realm.Realm;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

public class FootballDataAPI implements IFootballDataAPI {

    @Override
    public Observable<List<CompetitonsData>> getCompetitons() {
        Retrofit getCompetitionsRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        IFootballDataService footballDataService = getCompetitionsRetrofit.create(IFootballDataService.class);

        Observable<List<CompetitonsData>> competitions = footballDataService.getCompetitions();

        return competitions;
    }

    @Override
    public Observable<LeagueTableData> getLeagueTable(String leagueId) {
        Retrofit getLeagueTableRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        IFootballDataService footballDataService = getLeagueTableRetrofit.create(IFootballDataService.class);
        return footballDataService.getLeagueTable(leagueId);
    }

    @Override
    public Observable<CupTableData> getCupTable(String leagueId) {
        Retrofit getCupTableRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        IFootballDataService footballDataService = getCupTableRetrofit.create(IFootballDataService.class);
        return  footballDataService.getCupTable(leagueId);
    }
}
