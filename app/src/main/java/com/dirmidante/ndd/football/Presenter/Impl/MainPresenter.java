package com.dirmidante.ndd.football.Presenter.Impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.IRealmHelper;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Model.Impl.RealmHelper;
import com.dirmidante.ndd.football.Presenter.IMainPresenter;
import com.dirmidante.ndd.football.View.MainView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-17.
 */

public class MainPresenter implements IMainPresenter {

    private MainView mView;
    private FootballDataAPI mFootballDataAPI;
    private IRealmHelper mRealmHelper;
    private Context mContext;
//TODO Naming should be more descriptive rather than  MainSomething...
    public MainPresenter(MainView view, FootballDataAPI footballDataAPI, Context context) {
        this.mView = view;
        this.mFootballDataAPI = footballDataAPI;
        this.mContext = context;
        this.mRealmHelper = new RealmHelper(context);
    }

    @Override
    public void getCompetitionsFromNetwork() {
        ConnectivityManager connMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        Log.v("mytag", "getCompetitionsFromNetwork");
        if (networkInfo != null && networkInfo.isConnected()) {
            Observable<List<CompetitonsData>> competitionsDataObservable = mFootballDataAPI.getCompetitons();
            competitionsDataObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())//TODO do not use computation thread for IO operations, use  Schedulers.io instead
                    //as RX javaDoc sad. "Do not perform IO-bound work on this scheduler. Use io() instead."
                    //computation need only for long time compute operation for best CPU performance.
                    .doOnNext(competitonsData -> {
                        mRealmHelper.addCompetitions(competitonsData);
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(competitonsData -> {
                        if (mRealmHelper.hasCompetitions()) {
                            mView.setCompetitionsListData(competitonsData);
                            mView.showRefreshMessage();
                        }
                    });


        } else {
            mView.showNoConnectionMessage();
        }
        mView.setRefreshing();
    }

    @Override
    public void getCompetitionsFromRealm() {
        Log.v("mytag", "getCompetitionsFromRealm");

        if (mRealmHelper.hasCompetitions())
            mView.setCompetitionsListData(mRealmHelper.getCompetitions());
        else
            getCompetitionsFromNetwork();
    }
}
