package com.dirmidante.ndd.football.injections;

import com.dirmidante.ndd.football.view.CompetitionsListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Dima on 22.02.2017.
 */

@Component(modules = CompetitionsListModule.class)
public interface CompetitonsListComponent {
    void inject (CompetitionsListActivity activity);
}
