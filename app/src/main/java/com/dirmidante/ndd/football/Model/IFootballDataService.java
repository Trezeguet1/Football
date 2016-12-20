package com.dirmidante.ndd.football.Model;


import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Dima on 2016-12-17.
 */

public interface IFootballDataService {

    @Headers("X-Auth-Token: 776e07b83bfd4b57bd53c126558f9937")
    @GET("competitions/{league_id}/leagueTable")
    Observable<LeagueTableData> getLeagueTable(@Path("league_id") String league_id);


    @Headers("X-Auth-Token: 776e07b83bfd4b57bd53c126558f9937")
    @GET("competitions/{league_id}/leagueTable")
    Observable<CupTableData> getCupTable(@Path("league_id") String league_id);

    @Headers("X-Auth-Token: 776e07b83bfd4b57bd53c126558f9937")
    @GET("competitions/")
    Observable<List<CompetitonsData>> getCompetitions();

}
