package com.dirmidante.ndd.football.p.imp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.m.IRealmHelper;
import com.dirmidante.ndd.football.m.e.cuptable.CupTableData;
import com.dirmidante.ndd.football.m.e.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.m.imp.FootballDataAPI;
import com.dirmidante.ndd.football.m.imp.RealmHelper;
import com.dirmidante.ndd.football.p.ICompetitionDetailPresenter;
import com.dirmidante.ndd.football.v.CompetitionDetailView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.dirmidante.ndd.football.FootballApplication.getCurrentApplicationContext;

/**
 * Created by Dima on 2016-12-18.
 */

public class CompetitionDetailPresenter implements ICompetitionDetailPresenter {

    private CompetitionDetailView mView;
    private FootballDataAPI mFootballDataAPI;
    private IRealmHelper mRealmHelper;

    public CompetitionDetailPresenter(CompetitionDetailView view, FootballDataAPI footballDataAPI) {
        this.mView = view;
        this.mFootballDataAPI = footballDataAPI;
        mRealmHelper = new RealmHelper(getCurrentApplicationContext());
    }

    @Override
    public void getTableFromNetwork(String leagueId) {

        ConnectivityManager connMgr = (ConnectivityManager)
                getCurrentApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (isCup(leagueId)) {
                getCupTableFromNetwork(leagueId);
            } else {
                getLeagueTableFromNetwork(leagueId);
            }

        } else mView.showNoConnectionMessage();

        mView.setRefreshing();
    }

    @Override
    public void getTableFromRealm(String leagueId) {
        if (isCup(leagueId)) {
            getCupTableFromRealm(leagueId);
        } else {
            getLeagueTableFromRealm(leagueId);
        }
    }

    private void getLeagueTableFromNetwork(String leagueId) {
        Observable<LeagueTableData> leagueTableObservable = mFootballDataAPI.getLeagueTable(leagueId);
        leagueTableObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnNext(table -> mRealmHelper.addLeagueTable(table, leagueId))
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
                .doOnNext(table -> mRealmHelper.addCupTable(table, leagueId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> {
                    mView.setTableData(table);
                    mView.showRefreshMessage();
                }, error -> mView.showErrorMessage());
    }

    private void getLeagueTableFromRealm(String leagueId) {
        if (mRealmHelper.hasLeague(leagueId)) {
            mView.setTableData(mRealmHelper.getLeagueTable(leagueId));
            mView.setHeader();
        } else getTableFromNetwork(leagueId);
    }

    private void getCupTableFromRealm(String leagueId) {
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
