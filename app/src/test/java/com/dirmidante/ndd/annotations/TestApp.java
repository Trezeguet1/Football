package com.dirmidante.ndd.annotations;

import com.dirmidante.ndd.annotations.injections.CompetitionDetailTestModule;
import com.dirmidante.ndd.annotations.injections.CompetitionsListTestModule;
import com.dirmidante.ndd.football.FootballApplication;
import com.dirmidante.ndd.football.injections.components.CompetitionDetailComponent;
import com.dirmidante.ndd.football.injections.components.CompetitonsListComponent;
import com.dirmidante.ndd.football.injections.components.DaggerCompetitionDetailComponent;
import com.dirmidante.ndd.football.injections.components.DaggerCompetitonsListComponent;

/**
 * Created by Dima on 23.02.2017.
 */

public class TestApp extends FootballApplication {

    @Override
    protected CompetitonsListComponent buildCompetitionsListComponent() {
        return DaggerCompetitonsListComponent.builder()
                .competitionsListModule(new CompetitionsListTestModule())
                .build();
    }

    @Override
    protected CompetitionDetailComponent buildCompetitionDetailComponent() {
        return DaggerCompetitionDetailComponent.builder()
                .competitionDetailModule(new CompetitionDetailTestModule())
                .build();
    }

    @Override
    protected void initRealm() {
    }
}
