package com.dirmidante.ndd.football.model;

import com.dirmidante.ndd.football.model.entity.competitonsdata.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptabledata.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguestabledata.LeagueTableData;

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
