package com.dirmidante.ndd.football.View.Impl;


import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.dirmidante.ndd.football.Adapter.CompetitionsAdapter;
import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Presenter.Impl.CompetitionsListPresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.CompetitionsListView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

@EActivity((R.layout.activity_main))
public class CompetitionsListActivity extends AppCompatActivity implements CompetitionsListView {

    @Bean
    protected CompetitionsListPresenter mPresenter;

    @Bean
    protected CompetitionsAdapter mAdapter;

    @ViewById(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.toolbar)
    protected Toolbar mToolbar;


    @AfterViews
    void afterViews() {
        setSupportActionBar(mToolbar);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getCompetitionsFromNetwork());
        mPresenter.getCompetitionsFromRealm();
    }

    @AfterInject
    void afterInject(){
        mPresenter.setView(this);
    }

    @Override
    public void setCompetitionsListData(@NonNull List<CompetitonsData> competitions) {
        RecyclerView competitionsList = (RecyclerView) findViewById(R.id.competitionsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        competitionsList.setLayoutManager(layoutManager);
        if (competitions != null) {
            mAdapter.setCompetitions(competitions);
            mAdapter.setListener((position) -> {
                startDetailActivity(competitions.get(position).getId(), competitions.get(position).getCaption());
            });
            competitionsList.setAdapter(mAdapter);
        }
    }

    @Override
    public void startDetailActivity(int id, String title) {
        CompetitionDetailActivity_.intent(this)
                .extra(CompetitionDetailActivity.EXTRA_ID,id)
                .extra(CompetitionDetailActivity.EXTRA_TITLE,title)
                .start();
    }

    @Override
    public void showNoConnectionMessage() {
        Toast.makeText(this, R.string.noInternetConnection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showRefreshMessage() {
        Toast.makeText(this, R.string.infoRefreshed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, R.string.noData, Toast.LENGTH_SHORT).show();
    }
}
