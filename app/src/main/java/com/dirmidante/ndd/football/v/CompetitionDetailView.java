package com.dirmidante.ndd.football.v;


import com.dirmidante.ndd.football.m.e.cuptable.CupTableData;
import com.dirmidante.ndd.football.m.e.leaguetable.LeagueTableData;

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
