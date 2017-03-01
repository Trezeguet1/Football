package com.dirmidante.ndd.football.injections.components;

import com.dirmidante.ndd.football.injections.modules.CompetitionDetailModule;
import com.dirmidante.ndd.football.view.CompetitionDetailActivity;

import dagger.Component;

/**
 * Created by Dima on 28.02.2017.
 */

@Component(modules = CompetitionDetailModule.class)
public interface CompetitionDetailComponent {
    void inject(CompetitionDetailActivity activity);
}
