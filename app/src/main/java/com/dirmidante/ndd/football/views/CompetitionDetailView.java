package com.dirmidante.ndd.football.views;


import com.dirmidante.ndd.football.models.entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.models.entity.LeagueTableData.LeagueTableData;

/**
 * Created by Dima on 2016-12-18.
 */

public interface CompetitionDetailView {
    void setTableData(LeagueTableData tableData);
    void setTableData(CupTableData tableData);
    void showNoConnectionMessage();
    void setRefreshing();
    void showErrorMessage();
    void setHeader();
    void showRefreshMessage();
}
