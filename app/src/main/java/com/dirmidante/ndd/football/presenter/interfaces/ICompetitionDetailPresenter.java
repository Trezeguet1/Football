package com.dirmidante.ndd.football.presenter.interfaces;

import com.dirmidante.ndd.football.view.CompetitionDetailActivity;
import com.dirmidante.ndd.football.view.interfaces.CompetitionDetailView;

/**
 * Created by Dima on 2016-12-18.
 */

public interface ICompetitionDetailPresenter {
    void getTableFromNetwork(String leagueID);
    void getTable(String leagueCaption);
    void setView(CompetitionDetailView view);

}
