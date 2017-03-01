package com.dirmidante.ndd.annotations.view;

import com.dirmidante.ndd.annotations.TestApp;
import com.dirmidante.ndd.football.BuildConfig;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionDetailPresenter;
import com.dirmidante.ndd.football.view.CompetitionDetailActivity;
import com.dirmidante.ndd.football.view.CompetitionDetailActivity_;
import com.dirmidante.ndd.football.view.CompetitionsListActivity_;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by Dima on 28.02.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "AndroidManifest.xml", constants = BuildConfig.class, application = TestApp.class)
public class CompetitionDetailActivityTest {

    private CompetitionDetailActivity mDetailActivity;

    @Mock
    public static ICompetitionDetailPresenter sPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mDetailActivity = Robolectric.setupActivity(CompetitionDetailActivity_.class);
    }

    @Test
    public void should_not_be_null() {
        assertNotNull(mDetailActivity);
    }

    @Test
    public void should_setView_onCreate() {
        verify(sPresenter).setView(mDetailActivity);
    }

    @Test
    public void should_getTable_onCreate() {
        verify(sPresenter).getTable(anyString());
    }

}
