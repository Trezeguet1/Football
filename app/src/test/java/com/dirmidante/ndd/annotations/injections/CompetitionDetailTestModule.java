package com.dirmidante.ndd.annotations.injections;

import com.dirmidante.ndd.football.injections.modules.CompetitionDetailModule;
import com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionDetailPresenter;

import static com.dirmidante.ndd.annotations.view.CompetitionDetailActivityTest.sPresenter;


/**
 * Created by Dima on 28.02.2017.
 */

public class CompetitionDetailTestModule extends CompetitionDetailModule{
    @Override
    public ICompetitionDetailPresenter providePresenter(IFootballDataAPI api, IRealmHelper db) {
        return sPresenter;
    }
}
