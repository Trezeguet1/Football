package com.dirmidante.ndd.football.Presenter;

import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.View.TableView;

/**
 * Created by Dima on 2016-12-18.
 */

public interface ITablePresenter {
    void getTableFromNetwork(String leagueID);
    void getTableFromRealm(String leagueCaption);
    void setView (TableView view);

    }
