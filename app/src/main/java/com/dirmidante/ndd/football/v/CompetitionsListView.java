package com.dirmidante.ndd.football.v;

import com.dirmidante.ndd.football.m.e.competition.CompetitonsData;

import java.util.List;

/**
 * Created by Dima on 2016-12-18.
 */

public interface CompetitionsListView {
    void setCompetitionsListData(List<CompetitonsData> competitions);
    void startDetailActivity(int id);
    void showNoConnectionMessage();
    void setRefreshing();
    void showRefreshMessage();
    void showErrorMessage();
}
