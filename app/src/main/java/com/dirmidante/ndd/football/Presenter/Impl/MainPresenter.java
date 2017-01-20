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

        Log.v("mytag","getCompetitionsFromNetwork");
        if (networkInfo != null && networkInfo.isConnected()) {
            Observable<List<CompetitonsData>> competitionsDataObservable = mFootballDataAPI.getCompetitons();
            competitionsDataObservable
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .map(competitonsData -> {
                        mRealmHelper.addCompetitions(competitonsData);
                        return competitonsData;
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(competitonsData -> {
                        if (mRealmHelper.hasCompetitions())
                            getCompetitionsFromRealm();

                    });


        } else {
            mView.showNoConnectionMessage();
        }
        mView.setRefreshing();
    }

    @Override
    public void getCompetitionsFromRealm() {
        Log.v("mytag","getCompetitionsFromRealm");

        if (mRealmHelper.hasCompetitions())
            mView.setCompetitionsListData(mRealmHelper.getCompetitions());
        else
            getCompetitionsFromNetwork();
    }
}
