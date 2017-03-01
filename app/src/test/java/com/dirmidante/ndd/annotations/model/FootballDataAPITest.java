package com.dirmidante.ndd.annotations.model;

import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import rx.Observable;

import static com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI.CHAMPIONS_LEAGUE_ID;
import static com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI.PREMIER_LEAGUE_ID;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Dima on 24.02.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class FootballDataAPITest {

    IFootballDataAPI mFootballDataAPI = new FootballDataAPI();

    @Test
    public void competitions_should_not_be_null() {
        Observable<List<CompetitonsData>> competitonsData = mFootballDataAPI.getCompetitons();
        assertNotNull(competitonsData);
    }

    @Test
    public void leagueTable_should_not_be_null() {
        Observable<LeagueTableData> leagueTableData = mFootballDataAPI.getLeagueTable(PREMIER_LEAGUE_ID);
        assertNotNull(leagueTableData);
    }

    @Test
    public void cupTable_should_not_be_null() {
        Observable<CupTableData> cupTableData = mFootballDataAPI.getCupTable(CHAMPIONS_LEAGUE_ID);
        assertNotNull(cupTableData);
    }

}
