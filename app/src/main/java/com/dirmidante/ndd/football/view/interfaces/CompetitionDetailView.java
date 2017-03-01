package com.dirmidante.ndd.football.view.interfaces;


import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;

/**
 * Created by Dima on 2016-12-18.
 */

public interface CompetitionDetailView {
    void setTableData(LeagueTableData tableData);
    void setTableData(CupTableData tableData);
    void showNoConnectionMessage();
    void showErrorMessage();
    void showRefreshMessage();
}
