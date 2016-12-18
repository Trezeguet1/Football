package com.dirmidante.ndd.football.Model;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;

import java.util.List;

import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

public interface IFootballDataAPI {

    String BASE_URL = "http://api.football-data.org/v1/";

    Observable<List<CompetitonsData>> getCompetitons();
    Observable<LeagueTableData> getLeagueTable(String leagueId);
}

