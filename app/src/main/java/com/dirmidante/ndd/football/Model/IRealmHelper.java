package com.dirmidante.ndd.football.Model;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;

import java.util.List;

/**
 * Created by Dima on 19.01.2017.
 */

public interface IRealmHelper {

    void addCompetitions(List<CompetitonsData> competitons);

    void addCupTable(CupTableData cupTableData, String cupId);

    void addLeagueTable(LeagueTableData leagueTableData, String leagueId);

    List<CompetitonsData> getCompetitions();

    LeagueTableData getLeagueTable(String leagueId);

    CupTableData getCupTable(String cupId);

    boolean hasCompetitions();
    boolean hasLeague(String leagueId);
    boolean hasCup(String cupId);

}
