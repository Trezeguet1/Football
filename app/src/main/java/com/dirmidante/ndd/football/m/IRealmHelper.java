package com.dirmidante.ndd.football.m;



import com.dirmidante.ndd.football.m.e.competition.CompetitonsData;
import com.dirmidante.ndd.football.m.e.cuptable.CupTableData;
import com.dirmidante.ndd.football.m.e.leaguetable.LeagueTableData;

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
