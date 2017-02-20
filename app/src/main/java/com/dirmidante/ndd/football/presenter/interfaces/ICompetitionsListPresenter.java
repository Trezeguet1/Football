package com.dirmidante.ndd.football.presenter.interfaces;

import com.dirmidante.ndd.football.view.interfaces.CompetitionsListView;

/**
 * Created by Dima on 2016-12-17.
 */

public interface ICompetitionsListPresenter {
    void getCompetitionsFromNetwork();
    void getCompetitionsFromRealm();
    void setView(CompetitionsListView view);
}
