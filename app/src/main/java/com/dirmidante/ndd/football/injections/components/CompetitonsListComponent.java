package com.dirmidante.ndd.football.injections.components;

import com.dirmidante.ndd.football.injections.modules.CompetitionsListModule;
import com.dirmidante.ndd.football.view.CompetitionsListActivity;

import dagger.Component;

/**
 * Created by Dima on 22.02.2017.
 */

@Component(modules = CompetitionsListModule.class)
public interface CompetitonsListComponent {
    void inject (CompetitionsListActivity activity);
}
