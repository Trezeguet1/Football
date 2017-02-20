package com.dirmidante.ndd.football.model;

import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataService;

import org.androidannotations.annotations.EBean;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

@EBean
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
