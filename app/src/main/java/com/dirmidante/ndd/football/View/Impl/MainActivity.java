package com.dirmidante.ndd.football.View.Impl;


import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dirmidante.ndd.football.Adapter.CompetitionsAdapter;
import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IMainPresenter;
import com.dirmidante.ndd.football.Presenter.Impl.MainPresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private IMainPresenter mPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mPresenter = new MainPresenter(this, new FootballDataAPI(), this);

        mPresenter.getCompetitionsFromRealm();
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getCompetitionsFromNetwork());
    }

    @Override
    public void setCompetitionsListData(List<CompetitonsData> competitions) {

        RecyclerView competitionsList = (RecyclerView) findViewById(R.id.competitionsList);

        CompetitionsAdapter competitionsAdapter = new CompetitionsAdapter(competitions);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        competitionsList.setLayoutManager(layoutManager);
        competitionsList.setAdapter(competitionsAdapter);


        competitionsAdapter.setListener((position) -> {
            startDetailActivity(competitions.get(position).getId());
        });
    }

    @Override
    public void startDetailActivity(int id) {
        Intent startDetail = new Intent(this, DetailActivity.class);
        startDetail.putExtra(DetailActivity.EXTRA_ID, id);
        startActivity(startDetail);
    }

    @Override
    public void showNoConnectionMessage() {
        Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showRefreshMessage() {
        Toast.makeText(this, "Info Refreshed From Network", Toast.LENGTH_SHORT).show();
    }
}
