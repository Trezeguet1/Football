package com.dirmidante.ndd.football.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.adapters.CompetitionsAdapter;
import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.presenter.CompetitionsListPresenter;
import com.dirmidante.ndd.football.presenter.interfaces.ICompetitionsListPresenter;
import com.dirmidante.ndd.football.view.interfaces.CompetitionsListView;

import java.util.List;


public class CompetitionsListActivity extends AppCompatActivity implements CompetitionsListView {

    private ICompetitionsListPresenter mPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mPresenter = new CompetitionsListPresenter(this, new FootballDataAPI());

        mPresenter.getCompetitionsFromRealm();

        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getCompetitionsFromNetwork());
    }

    @Override
    public void setCompetitionsListData(@NonNull List<CompetitonsData> competitions) {

        RecyclerView competitionsList = (RecyclerView) findViewById(R.id.competitionsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        competitionsList.setLayoutManager(layoutManager);
        if (competitions != null) {
            CompetitionsAdapter competitionsAdapter = new CompetitionsAdapter();
            competitionsAdapter.setCompetitions(competitions);
            competitionsAdapter.setListener((position) -> {
                startDetailActivity(competitions.get(position).getId());
            });
            competitionsList.setAdapter(competitionsAdapter);
        }
    }

    @Override
    public void startDetailActivity(int id) {
        Intent startDetail = new Intent(this, CompetitionDetailActivity.class);
        startDetail.putExtra(CompetitionDetailActivity.EXTRA_ID, id);
        startActivity(startDetail);
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
