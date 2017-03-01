package com.dirmidante.ndd.annotations.presenter;

import com.dirmidante.ndd.annotations.rules.RxSchedulersOverrideRule;
import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.presenter.CompetitionsListPresenter;
import com.dirmidante.ndd.football.utils.NetworkUtils;
import com.dirmidante.ndd.football.view.CompetitionsListActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Dima on 24.02.2017.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest(NetworkUtils.class)
public class CompetitionsListPresenterTest {

    List<CompetitonsData> mCompetitions = new ArrayList<>();
    Observable<List<CompetitonsData>> mCompetitionsObservable;

    @Mock
    RealmHelper mRealmHelper;
    @Mock
    FootballDataAPI mFootballDataAPI;

    @Mock
    CompetitionsListActivity mActivity;

    CompetitionsListPresenter mPresenter;

    @Rule
    public final RxSchedulersOverrideRule mRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new CompetitionsListPresenter(mFootballDataAPI, mRealmHelper);
        mPresenter.setView(mActivity);
        PowerMockito.mockStatic(NetworkUtils.class);

        mCompetitions.add(new CompetitonsData());
        mCompetitionsObservable = Observable.just(mCompetitions);
        when(mFootballDataAPI.getCompetitons()).thenReturn(mCompetitionsObservable);
        when(mRealmHelper.getCompetitions()).thenReturn(mCompetitions);
    }

    @Test
    public void should_setCompetitionsListData_and_writeToRealm_when_network_available() {
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(true);
        mPresenter.getCompetitionsFromNetwork();
        verify(mRealmHelper).writeToRealm(mCompetitions.get(0));
        verify(mActivity).setCompetitionsListData(mCompetitions);
        verify(mActivity).showRefreshMessage();
    }

    @Test
    public void should_showNoConnectionNetwork_when_network_unable() {
        PowerMockito.mockStatic(NetworkUtils.class);
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(false);
        mPresenter.getCompetitionsFromNetwork();
        verify(mActivity).showNoConnectionMessage();
    }

    @Test
    public void should_write_to_DB_and_setCompetitionsListData_when_getCompetitions() {
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(true);
        when(mRealmHelper.hasCompetitions()).thenReturn(false);
        mPresenter.getCompetitions();
        verify(mRealmHelper).writeToRealm(mCompetitions.get(0));
        verify(mActivity).setCompetitionsListData(mCompetitions);
        verify(mActivity).showRefreshMessage();
    }
}
