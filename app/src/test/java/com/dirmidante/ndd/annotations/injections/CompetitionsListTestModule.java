package com.dirmidante.ndd.annotations.injections;

import com.dirmidante.ndd.football.injections.CompetitionsListModule;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;

import static com.dirmidante.ndd.annotations.view.CompetitionsListActivityTest.mPresenter;

/**
 * Created by Dima on 23.02.2017.
 */

public class CompetitionsListTestModule extends CompetitionsListModule {
    @Override
    public ICompetitionsListPresenter providePresenter(IFootballDataAPI api, IRealmHelper db) {
        return mPresenter;
    }
}
