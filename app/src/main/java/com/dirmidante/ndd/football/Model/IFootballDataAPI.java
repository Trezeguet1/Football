package com.dirmidante.ndd.football.Model;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;

import java.util.List;

import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

public interface IFootballDataAPI {

    static final String BASE_URL = "http://api.football-data.org/v1/";

    static final String EUROPEAN_CHAMPIONSHIP_ID = "424";
    static final String CHAMPIONS_LEAGUE_ID = "440";

    Observable<List<CompetitonsData>> getCompetitons();
    Observable<LeagueTableData> getLeagueTable(String leagueId);
    Observable<CupTableData> getCupTable(String leagueId);
}

