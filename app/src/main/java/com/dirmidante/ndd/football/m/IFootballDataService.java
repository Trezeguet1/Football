package com.dirmidante.ndd.football.m;



import com.dirmidante.ndd.football.m.e.competition.CompetitonsData;
import com.dirmidante.ndd.football.m.e.cuptable.CupTableData;
import com.dirmidante.ndd.football.m.e.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.m.imp.FootballDataAPI;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;
/**
 * Created by Dima on 2016-12-17.
 */

public interface IFootballDataService {


    @Headers(FootballDataAPI.API_TOKEN)
    @GET("competitions/{league_id}/leagueTable")
    Observable<LeagueTableData> getLeagueTable(@Path("league_id") String league_id);


    @Headers(FootballDataAPI.API_TOKEN)
    @GET("competitions/{league_id}/leagueTable")
    Observable<CupTableData> getCupTable(@Path("league_id") String league_id);

    @Headers(FootballDataAPI.API_TOKEN)
    @GET("competitions/")
    Observable<List<CompetitonsData>> getCompetitions();

}
