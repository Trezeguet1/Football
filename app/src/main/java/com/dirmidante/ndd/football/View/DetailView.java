package com.dirmidante.ndd.football.View;


import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;

/**
 * Created by Dima on 2016-12-18.
 */

public interface DetailView {
    void setTableData(LeagueTableData tableData);
    void setTableData(CupTableData tableData);
    void showNoConnectionMessage();
}
