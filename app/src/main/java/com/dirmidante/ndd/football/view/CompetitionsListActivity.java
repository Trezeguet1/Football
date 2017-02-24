package com.dirmidante.ndd.football.view;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dirmidante.ndd.football.FootballApplication;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.adapters.CompetitionsAdapter;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;
import com.dirmidante.ndd.football.view.interfaces.CompetitionsListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import javax.inject.Inject;


@EActivity((R.layout.activity_main))
public class CompetitionsListActivity extends AppCompatActivity implements CompetitionsListView {

    @Inject
    protected ICompetitionsListPresenter mPresenter;

    @Bean
    protected CompetitionsAdapter mAdapter;

    @ViewById(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @ViewById(R.id.competitionsList)
    protected RecyclerView competitionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((FootballApplication)getApplication()).getCompetitonsListComponent().inject(this);
        mPresenter.setView(this);
    }

    @AfterViews
    void afterViews() {

        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getCompetitionsFromNetwork());
        mPresenter.getCompetitions();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        competitionsList.setLayoutManager(layoutManager);

        competitionsList.setAdapter(mAdapter);

    }


    @Override
    public void setCompetitionsListData(@NonNull List<CompetitonsData> competitions) {

        if (competitions != null) {
            mAdapter.setCompetitions(competitions);
            mAdapter.setListener((position) -> {
                startDetailActivity(competitions.get(position));
            });

            mAdapter.notifyDataSetChanged();
        }
        setRefreshing();
    }

    @Override
    public void startDetailActivity(CompetitonsData competiton) {
        CompetitionDetailActivity_.intent(this)
                .extra(CompetitionDetailActivity.EXTRA_ID, competiton.getId().toString())
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