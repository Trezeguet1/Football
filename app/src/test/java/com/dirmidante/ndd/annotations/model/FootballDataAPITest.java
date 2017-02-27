package com.dirmidante.ndd.annotations.model;

import com.dirmidante.ndd.annotations.TestApp;
import com.dirmidante.ndd.football.BuildConfig;
import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;

import junit.framework.Assert;

import org.apache.tools.ant.types.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import rx.Observable;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Dima on 24.02.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class FootballDataAPITest {

    IFootballDataAPI mFootballDataAPI = new FootballDataAPI();

    @Test
    public void testGetCompetitions(){
        Observable<List<CompetitonsData>> competitonsData = mFootballDataAPI.getCompetitons();
        assertNotNull(competitonsData);
    }

}
