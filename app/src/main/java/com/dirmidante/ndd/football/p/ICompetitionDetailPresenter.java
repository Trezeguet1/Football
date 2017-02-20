package com.dirmidante.ndd.football.p;

/**
 * Created by Dima on 2016-12-18.
 */

public interface ICompetitionDetailPresenter {
    void getTableFromNetwork(String leagueID);
    void getTableFromRealm(String leagueCaption);
}
