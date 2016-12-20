package com.dirmidante.ndd.football.View.Impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirmidante.ndd.football.Adapter.CupTableAdapter;
import com.dirmidante.ndd.football.Adapter.LeagueTableAdapter;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IDetailPresenter;
import com.dirmidante.ndd.football.Presenter.Impl.DetailPresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.DetailView;

public class DetailActivity extends AppCompatActivity implements DetailView {

    public static final String EXTRA_ID = "id";

    private IDetailPresenter presenter;

    private RecyclerView leagueTableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        leagueTableList = (RecyclerView) findViewById(R.id.leagueTableList);
        presenter = new DetailPresenter(this, new FootballDataAPI(), this);
        presenter.getTable(Integer.toString(getIntent().getIntExtra(EXTRA_ID, 0)));
    }

    @Override
    public void setTableData(LeagueTableData tableData) {

        CardView header = (CardView) getLayoutInflater().inflate(R.layout.league_table_item,null);
        ViewGroup head = (ViewGroup) findViewById(R.id.activity_detail);
        head.addView(header, 0);
        LeagueTableAdapter leagueTableAdapter = new LeagueTableAdapter(tableData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        leagueTableList.setLayoutManager(layoutManager);
        leagueTableList.setAdapter(leagueTableAdapter);
    }

    @Override
    public void setTableData(CupTableData tableData) {
        CupTableAdapter cupTableadapter = new CupTableAdapter(tableData, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        leagueTableList.setLayoutManager(layoutManager);
        leagueTableList.setAdapter(cupTableadapter);
    }

    @Override
    public void showNoConnectionMessage() {
        Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
    }
}
