package com.dirmidante.ndd.football.view.imp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirmidante.ndd.football.adapter.CupTableAdapter;
import com.dirmidante.ndd.football.adapter.LeagueTableAdapter;
import com.dirmidante.ndd.football.model.entity.cuptabledata.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguestabledata.LeagueTableData;
import com.dirmidante.ndd.football.model.imp.FootballDataAPI;
import com.dirmidante.ndd.football.presenter.ICompetitionDetailPresenter;
import com.dirmidante.ndd.football.presenter.Impl.CompetitionDetailPresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.view.CompetitionDetailView;

public class CompetitionDetailActivity extends AppCompatActivity implements CompetitionDetailView {

    public static final String EXTRA_ID = "id";

    private ICompetitionDetailPresenter mPresenter;
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
        mPresenter = new CompetitionDetailPresenter(this, new FootballDataAPI());
        mPresenter.getTableFromRealm(mLeagueId);
    }


    @Override
    public void setTableData(@NonNull LeagueTableData tableData) {
        Log.v("mytag", "a");
        setHeader();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        LeagueTableAdapter leagueTableAdapter = new LeagueTableAdapter();
        leagueTableAdapter.setLeagueTableData(tableData);
        mRecyclerView.setAdapter(leagueTableAdapter);
    }

    @Override
    public void setTableData(@NonNull CupTableData tableData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        CupTableAdapter cupTableadapter = new CupTableAdapter();
        cupTableadapter.setCupTableData(tableData);
        mRecyclerView.setAdapter(cupTableadapter);

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