package com.dirmidante.ndd.annotations.view;

import com.dirmidante.ndd.annotations.TestApp;
import com.dirmidante.ndd.football.BuildConfig;
import com.dirmidante.ndd.football.presenter.CompetitionsListPresenter;
import com.dirmidante.ndd.football.view.CompetitionsListActivity;
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
import static org.mockito.Mockito.verify;

/**
 * Created by Dima on 21.02.2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "AndroidManifest.xml", constants = BuildConfig.class, application = TestApp.class)
public class CompetitionsListActivityTest {

    CompetitionsListActivity mCompetitionsListActivity;

    @Mock
    public static CompetitionsListPresenter sPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mCompetitionsListActivity = Robolectric.setupActivity(CompetitionsListActivity_.class);
    }

    @Test
    public void should_not_be_null() {
        assertNotNull(mCompetitionsListActivity);
    }

    @Test
    public void should_setView_onCreate() {
        verify(sPresenter).setView(mCompetitionsListActivity);
    }

    @Test
    public void should_getCompetitions_onCreate() {
        verify(sPresenter).getCompetitions();
    }
}
