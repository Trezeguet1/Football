package com.dirmidante.ndd.annotations.presenter;

import com.dirmidante.ndd.annotations.rules.RxSchedulersOverrideRule;
import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.RealmHelper;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.presenter.CompetitionDetailPresenter;
import com.dirmidante.ndd.football.utils.NetworkUtils;
import com.dirmidante.ndd.football.view.CompetitionDetailActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rx.Observable;

import static com.dirmidante.ndd.football.model.interfaces.IFootballDataAPI.PREMIER_LEAGUE_ID;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Dima on 01.03.2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(NetworkUtils.class)
public class CompetitionDetailPresenterTest {

    private CompetitionDetailPresenter mPresenter;

    private LeagueTableData mLeagueTable = new LeagueTableData();
    private CupTableData mCupTable = new CupTableData();
    private Observable<LeagueTableData> mLeagueTableDataObservable = Observable.just(mLeagueTable);
    private Observable<CupTableData> mCupTableDataObservable = Observable.just(mCupTable);

    @Mock
    RealmHelper mRealmHelper;
    @Mock
    FootballDataAPI mAPI;
    @Mock
    CompetitionDetailActivity mActivity;

    @Rule
    public final RxSchedulersOverrideRule mRule = new RxSchedulersOverrideRule();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mPresenter = new CompetitionDetailPresenter(mAPI,mRealmHelper);
        mPresenter.setView(mActivity);
        PowerMockito.mockStatic(NetworkUtils.class);

        when(mRealmHelper.getCupTable(anyString())).thenReturn(mCupTable);
        when(mRealmHelper.getLeagueTable(anyString())).thenReturn(mLeagueTable);

        when(mAPI.getCupTable(anyString())).thenReturn(mCupTableDataObservable);
        when(mAPI.getLeagueTable(anyString())).thenReturn(mLeagueTableDataObservable);
    }

    @Test
    public void should_getLeagueTable_from_DB(){
        when(mRealmHelper.hasLeague(anyString())).thenReturn(true);
        mPresenter.getTable(PREMIER_LEAGUE_ID);
        verify(mRealmHelper).getLeagueTable(PREMIER_LEAGUE_ID);
        verify(mActivity).setTableData(mLeagueTable);
    }

    @Test
    public void should_getLeagueTable_from_network(){
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(true);
        when(mRealmHelper.hasLeague(anyString())).thenReturn(false);
        mPresenter.getTable(PREMIER_LEAGUE_ID);
        verify(mAPI).getLeagueTable(PREMIER_LEAGUE_ID);
        verify(mActivity).setTableData(mLeagueTable);
    }

    @Test
    public void should_showNoConnetctionMessage(){
        PowerMockito.when(NetworkUtils.networkAvailable()).thenReturn(false);
        when(mRealmHelper.hasLeague(anyString())).thenReturn(false);
        mPresenter.getTable(PREMIER_LEAGUE_ID);
        verify(mActivity).showNoConnectionMessage();
    }

}
