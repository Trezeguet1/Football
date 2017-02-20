package com.dirmidante.ndd.football.model;

import com.dirmidante.ndd.football.model.entity.competitonsdata.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptabledata.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguestabledata.LeagueTableData;

import java.util.List;

import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

public interface IFootballDataAPI {

    String BASE_URL = "http://api.football-data.org/v1/";
    String EUROPEAN_CHAMPIONSHIP_ID = "424";
    String CHAMPIONS_LEAGUE_ID = "440";
    String API_TOKEN = "X-Auth-Token: 776e07b83bfd4b57bd53c126558f9937";


    Observable<List<CompetitonsData>> getCompetitons();

    Observable<LeagueTableData> getLeagueTable(String leagueId);

    Observable<CupTableData> getCupTable(String leagueId);
}
