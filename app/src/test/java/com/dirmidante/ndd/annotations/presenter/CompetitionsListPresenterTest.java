package com.dirmidante.ndd.annotations.presenter;

import com.dirmidante.ndd.annotations.rules.RxSchedulersOverrideRule;
import com.dirmidante.ndd.annotations.TestApp;
import com.dirmidante.ndd.football.BuildConfig;
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
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.verify;

/**
 * Created by Dima on 24.02.2017.
 */


@RunWith(PowerMockRunner.class)
@PrepareForTest(NetworkUtils.class)
public class CompetitionsListPresenterTest {

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
    }


    @Test
    public void testWithNetwork() {
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(true);

        List<CompetitonsData> competitions = new ArrayList<>();
        competitions.add(new CompetitonsData());
        Observable<List<CompetitonsData>> competitionsObservable = Observable.just(competitions);
        Mockito.when(mFootballDataAPI.getCompetitons()).thenReturn(competitionsObservable);

        mPresenter.getCompetitionsFromNetwork();

        verify(mRealmHelper).addCompetitions(competitions);
        verify(mActivity).setCompetitionsListData(competitions);
        verify(mActivity).showRefreshMessage();
    }

    @Test
    public void testWithoutNetwork() {
        PowerMockito.mockStatic(NetworkUtils.class);
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(false);

        mPresenter.getCompetitionsFromNetwork();

        verify(mActivity).showNoConnectionMessage();
    }

    @Test
    public void testFromDB(){
        List<CompetitonsData> competitions = new ArrayList<>();
        competitions.add(new CompetitonsData());

        Mockito.when(mRealmHelper.getCompetitions()).thenReturn(competitions);
        Mockito.when(mRealmHelper.hasCompetitions()).thenReturn(true);

        mPresenter.getCompetitions();
        verify(mRealmHelper).getCompetitions();
        verify(mActivity).setCompetitionsListData(competitions);
    }

    @Test
    public void testEmptyDB(){
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(true);
        List<CompetitonsData> competitions = new ArrayList<>();
        competitions.add(new CompetitonsData());
        Observable<List<CompetitonsData>> competitionsObservable = Observable.just(competitions);
        Mockito.when(mFootballDataAPI.getCompetitons()).thenReturn(competitionsObservable);
        Mockito.when(mRealmHelper.hasCompetitions()).thenReturn(false);
        mPresenter.getCompetitions();
        verify(mRealmHelper).addCompetitions(competitions);
        verify(mActivity).setCompetitionsListData(competitions);
        verify(mActivity).showRefreshMessage();
    }

    @Test
    public void testEmptyDBWithoutNetwork(){
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(false);
        List<CompetitonsData> competitions = new ArrayList<>();
        competitions.add(new CompetitonsData());
        Observable<List<CompetitonsData>> competitionsObservable = Observable.just(competitions);
        Mockito.when(mFootballDataAPI.getCompetitons()).thenReturn(competitionsObservable);
        Mockito.when(mRealmHelper.hasCompetitions()).thenReturn(false);
        mPresenter.getCompetitions();
        verify(mActivity).showNoConnectionMessage();
    }
}
