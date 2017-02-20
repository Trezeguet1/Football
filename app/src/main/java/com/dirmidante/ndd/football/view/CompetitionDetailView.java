package com.dirmidante.ndd.football.view;


import com.dirmidante.ndd.football.model.entity.cuptabledata.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguestabledata.LeagueTableData;

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
