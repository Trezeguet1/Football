package com.dirmidante.ndd.football.models;

import com.dirmidante.ndd.football.models.entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.models.entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.models.entity.LeagueTableData.LeagueTableData;

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
