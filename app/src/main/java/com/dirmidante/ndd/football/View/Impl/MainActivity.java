package com.dirmidante.ndd.football.View.Impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dirmidante.ndd.football.Adapter.CompetitionsAdapter;
import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IMainPresenter;
import com.dirmidante.ndd.football.Presenter.Impl.MainPresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this, new FootballDataAPI());
        presenter.getCompetitions();
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setCompetitionsListData(List<CompetitonsData> competitions) {

        RecyclerView competitionsList = (RecyclerView) findViewById(R.id.competitionsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        competitionsList.setLayoutManager(layoutManager);
        competitionsList.setAdapter(new CompetitionsAdapter(competitions));
    }
}
