package com.dirmidante.ndd.football.presenter;

import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionDetailPresenter;
import com.dirmidante.ndd.football.view.CompetitionDetailActivity;
import com.dirmidante.ndd.football.view.interfaces.CompetitionDetailView;

import org.androidannotations.annotations.EBean;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.dirmidante.ndd.football.utils.NetworkUtils.networkAvailable;

/**
 * Created by Dima on 2016-12-18.
 */

public class CompetitionDetailPresenter implements ICompetitionDetailPresenter {

    private CompetitionDetailView mView;
    protected IFootballDataAPI mFootballDataAPI;
    protected IRealmHelper mRealmHelper;

    public CompetitionDetailPresenter(IFootballDataAPI api, IRealmHelper db) {
        this.mFootballDataAPI = api;
        this.mRealmHelper = db;
    }

    @Override
    public void setView(CompetitionDetailView view) {
        this.mView = view;
    }

    @Override
    public void getTable(String leagueId) {
        if (isCup(leagueId)) {
            getCupTableFromDB(leagueId);
        } else {
            getLeagueTableFromDB(leagueId);
        }
    }

    @Override
    public void getTableFromNetwork(String leagueId) {
        if (networkAvailable()) {
            if (isCup(leagueId)) {
                getCupTableFromNetwork(leagueId);
            } else {
                getLeagueTableFromNetwork(leagueId);
            }

        } else mView.showNoConnectionMessage();
    }

    private void getLeagueTableFromNetwork(String leagueId) {
        Observable<LeagueTableData> leagueTableObservable = mFootballDataAPI.getLeagueTable(leagueId);
        leagueTableObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(table -> {
                    table.setId(leagueId);
                    mRealmHelper.writeToRealm(table);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> {
                    mView.setTableData(table);
                    mView.showRefreshMessage();
                }, error -> mView.showErrorMessage());
    }

    private void getCupTableFromNetwork(String leagueId) {
        Observable<CupTableData> cupTableDataObservable = mFootballDataAPI.getCupTable(leagueId);
        cupTableDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(table -> {
                    table.setId(leagueId);
                    mRealmHelper.writeToRealm(table);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> {
                    mView.setTableData(table);
                    mView.showRefreshMessage();
                }, error -> mView.showErrorMessage());
    }

    private void getLeagueTableFromDB(String leagueId) {
        if (mRealmHelper.hasLeague(leagueId)) {
            mView.setTableData(mRealmHelper.getLeagueTable(leagueId));
        } else getTableFromNetwork(leagueId);
    }

    private void getCupTableFromDB(String leagueId) {
        if (mRealmHelper.hasCup(leagueId))
            mView.setTableData(mRealmHelper.getCupTable(leagueId));
        else getTableFromNetwork(leagueId);
    }

    private boolean isCup(String id) {
        if (id.equals(FootballDataAPI.EUROPEAN_CHAMPIONSHIP_ID) || id.equals(FootballDataAPI.CHAMPIONS_LEAGUE_ID))
            return true;
        else return false;
    }


}
