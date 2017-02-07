package com.dirmidante.ndd.football.Presenter;

/**
 * Created by Dima on 2016-12-18.
 */

public interface ITablePresenter {
    void getTableFromNetwork(String leagueID);
    void getTableFromRealm(String leagueCaption);
}
