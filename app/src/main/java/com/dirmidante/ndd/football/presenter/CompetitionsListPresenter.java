package com.dirmidante.ndd.football.presenter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;
import com.dirmidante.ndd.football.view.interfaces.CompetitionsListView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.dirmidante.ndd.football.FootballApplication.getCurrentApplicationContext;

/**
 * Created by Dima on 2016-12-17.
 */


@EBean(scope = EBean.Scope.Singleton)
public class CompetitionsListPresenter implements ICompetitionsListPresenter {

    private CompetitionsListView mView;
    @Bean
    protected FootballDataAPI mFootballDataAPI;
    @Bean
    protected RealmHelper mRealmHelper;


    @Override
    public void setView(CompetitionsListView view) {
        this.mView = view;
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
                    },error -> mView.showErrorMessage());
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
