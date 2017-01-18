package com.dirmidante.ndd.football.Presenter.Impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IDetailPresenter;
import com.dirmidante.ndd.football.View.DetailView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-18.
 */

public class DetailPresenter implements IDetailPresenter {

    private static final String EUROPEAN_CHAMPIONSHIP_ID = "424";
    private static final String  CHAMPIONS_LEAGUE_ID = "440";
    private DetailView view;
    private FootballDataAPI footballDataAPI;
    private Context context;

    public DetailPresenter(DetailView view, FootballDataAPI footballDataAPI, Context context) {
        this.view = view;
        this.footballDataAPI = footballDataAPI;
        this.context = context;
    }

    @Override
    public void getTable(String leagueId) {

        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {


            if (leagueId.equals(EUROPEAN_CHAMPIONSHIP_ID) || leagueId.equals(CHAMPIONS_LEAGUE_ID)) {
                Observable<CupTableData> cupTableDataObservable = footballDataAPI.getCupTable(leagueId);
                cupTableDataObservable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(table -> {
                            view.setTableData(table);
                        });
            } else {
                Observable<LeagueTableData> leagueTableObservable = footballDataAPI.getLeagueTable(leagueId);
                leagueTableObservable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(table -> {
                            view.setTableData(table);
                        });
            }

        } else view.showNoConnectionMessage();

        view.setRefreshing();
    }
}
