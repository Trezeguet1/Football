package com.dirmidante.ndd.football.View.Impl;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private IDetailPresenter mPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private String mLeagueId;
    private boolean mHasHeader = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mLeagueId = Integer.toString(getIntent().getIntExtra(EXTRA_ID, 0));

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getTableFromNetwork(mLeagueId));


        mRecyclerView = (RecyclerView) findViewById(R.id.leagueTableList);
        mPresenter = new DetailPresenter(this, new FootballDataAPI(), this);
        mPresenter.getTableFromRealm(mLeagueId);
    }

    @Override
    public void setTableData(LeagueTableData tableData) {
        setHeader();
        showRefreshMessage();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        if (tableData != null) {
            LeagueTableAdapter leagueTableAdapter = new LeagueTableAdapter();
            leagueTableAdapter.setLeagueTableData(tableData);
            mRecyclerView.setAdapter(leagueTableAdapter);
        }
    }

    @Override
    public void setTableData(CupTableData tableData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        if (tableData != null) {
            CupTableAdapter cupTableadapter = new CupTableAdapter();
            cupTableadapter.setCupTableData(tableData);
            mRecyclerView.setAdapter(cupTableadapter);
        }
    }

    @Override
    public void setHeader() {
        if (!mHasHeader) {
            CardView header = (CardView) getLayoutInflater().inflate(R.layout.table_header, null);
            ViewGroup head = (ViewGroup) findViewById(R.id.head);
            head.addView(header, 0);
            mHasHeader = true;
        }
    }

    @Override
    public void showNoConnectionMessage() {
        Toast.makeText(this, R.string.noInternetConnection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, R.string.noInfo, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showRefreshMessage() {
        Toast.makeText(this, R.string.infoRefreshed, Toast.LENGTH_SHORT).show();
    }
}
