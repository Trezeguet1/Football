package com.dirmidante.ndd.football.Presenter.Impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Model.IRealmHelper;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Model.Impl.RealmHelper;
import com.dirmidante.ndd.football.Presenter.IDetailPresenter;
import com.dirmidante.ndd.football.View.DetailView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-18.
 */

public class DetailPresenter implements IDetailPresenter {



    private DetailView mView;
    private FootballDataAPI mFootballDataAPI;
    private IRealmHelper mRealmHelper;
    private Context mContext;

    public DetailPresenter(DetailView view, FootballDataAPI footballDataAPI, Context context) {
        this.mView = view;
        this.mFootballDataAPI = footballDataAPI;
        this.mContext = context;
        mRealmHelper = new RealmHelper(context);
    }

    @Override
    public void getTableFromNetwork(String leagueId) {

        ConnectivityManager connMgr = (ConnectivityManager)
                mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
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
                .observeOn(Schedulers.computation())
                .doOnNext(table -> mRealmHelper.addLeagueTable(table, leagueId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> {
                    mView.setTableData(table);
                    mView.setHeader();
                }, error -> mView.showErrorMessage());
    }

    private void getCupTableFromNetwork(String leagueId) {
        Observable<CupTableData> cupTableDataObservable = mFootballDataAPI.getCupTable(leagueId);
        cupTableDataObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext(table -> mRealmHelper.addCupTable(table, leagueId))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(table -> mView.setTableData(table), error -> mView.showErrorMessage());
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
        if (id.equals(FootballDataAPI.EUROPEAN_CHAMPIONSHIP_ID) || id.equals(FootballDataAPI.CHAMPIONS_LEAGUE_ID)) return true;
        else return false;
    }
}
