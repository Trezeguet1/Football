package com.dirmidante.ndd.football.Presenter.Impl;

import static com.dirmidante.ndd.football.FootballApplication.getCurrentApplicationContext;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.IRealmHelper;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Model.Impl.RealmHelper;
import com.dirmidante.ndd.football.Presenter.ICompetitionsListPresenter;
import com.dirmidante.ndd.football.View.CompetitionsListView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-17.
 */

public class CompetitionsListPresenter implements ICompetitionsListPresenter {

    private CompetitionsListView mView;
    private FootballDataAPI mFootballDataAPI;
    private IRealmHelper mRealmHelper;


    public CompetitionsListPresenter(CompetitionsListView view, FootballDataAPI footballDataAPI) {
        this.mView = view;
        this.mFootballDataAPI = footballDataAPI;
        this.mRealmHelper = new RealmHelper(getCurrentApplicationContext());
    }

    @Override
    public void getCompetitionsFromNetwork() {
        ConnectivityManager connMgr = (ConnectivityManager) getCurrentApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Observable<List<CompetitonsData>> competitionsDataObservable = mFootballDataAPI.getCompetitons();
            competitionsDataObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .doOnNext(competitonsData -> {
                        mRealmHelper.addCompetitions(competitonsData);
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(competitonsData -> {
                            mView.setCompetitionsListData(competitonsData);
                            mView.showRefreshMessage();
                    },error -> mView.showNoConnectionMessage());
        } else {
            mView.showNoConnectionMessage();
        }
        mView.setRefreshing();
    }

    @Override
    public void getCompetitionsFromRealm() {
        if (mRealmHelper.hasCompetitions())
            mView.setCompetitionsListData(mRealmHelper.getCompetitions());
        else
            getCompetitionsFromNetwork();
    }
    
}
