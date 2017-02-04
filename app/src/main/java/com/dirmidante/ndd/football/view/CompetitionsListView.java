package com.dirmidante.ndd.football.View;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;

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
