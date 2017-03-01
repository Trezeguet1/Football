package com.dirmidante.ndd.football.presenter;

import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;
import com.dirmidante.ndd.football.view.interfaces.CompetitionsListView;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.dirmidante.ndd.football.utils.NetworkUtils.networkAvailable;

/**
 * Created by Dima on 2016-12-17.
 */


public class CompetitionsListPresenter implements ICompetitionsListPresenter {

    private CompetitionsListView mView;
    private IFootballDataAPI mFootballDataAPI;
    private IRealmHelper mRealmHelper;

    public CompetitionsListPresenter(IFootballDataAPI footballDataAPI, IRealmHelper realmHelper) {
        mFootballDataAPI = footballDataAPI;
        mRealmHelper = realmHelper;
    }

    @Override
    public void setView(CompetitionsListView view) {
        this.mView = view;
    }

    @Override
    public void getCompetitions() {
        if (mRealmHelper.hasCompetitions())
            mView.setCompetitionsListData(mRealmHelper.getCompetitions());
        else {
            getCompetitionsFromNetwork();
        }
    }

    @Override
    public void getCompetitionsFromNetwork() {
        if (networkAvailable()) {
            loadCompetitions();
        } else {
            mView.showNoConnectionMessage();
        }
    }

    public void loadCompetitions() {
        Observable<List<CompetitonsData>> competitionsDataObservable = mFootballDataAPI.getCompetitons();
        competitionsDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(competitonsData -> {
                    for (CompetitonsData competition : competitonsData) {
                        mRealmHelper.writeToRealm(competition);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(competitonsData -> {
                    mView.setCompetitionsListData(competitonsData);
                    mView.showRefreshMessage();
                }, error -> mView.showErrorMessage());
    }

}
