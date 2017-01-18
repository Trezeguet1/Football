package com.dirmidante.ndd.football.Presenter.Impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IMainPresenter;
import com.dirmidante.ndd.football.View.MainView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-17.
 */

public class MainPresenter implements IMainPresenter {

    private MainView mView;
    private FootballDataAPI mFootballDataAPI;
    private Context mContext;

    public MainPresenter(MainView view, FootballDataAPI footballDataAPI, Context context) {
        this.mView = view;
        this.mFootballDataAPI = footballDataAPI;
        this.mContext = context;
    }

    @Override
    public void getCompetitions() {
        ConnectivityManager connMgr = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Observable<List<CompetitonsData>> competitionsDataObservable = mFootballDataAPI.getCompetitons();
            competitionsDataObservable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(competitonsData -> {
                        List<CompetitonsData> competitonsList = new ArrayList<>();
                        competitonsList.addAll(competitonsData);
                        mView.setCompetitionsListData(competitonsList);
                    });
        } else mView.showNoConnectionMessage();

        mView.setRefreshing();
    }
}
