package com.dirmidante.ndd.football.Presenter;

import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.View.CompetitionsListView;

import org.androidannotations.annotations.EBean;

/**
 * Created by Dima on 2016-12-17.
 */


public interface ICompetitionsListPresenter {
    void getCompetitionsFromNetwork();
    void getCompetitionsFromRealm();
    void setView(CompetitionsListView view);
}
