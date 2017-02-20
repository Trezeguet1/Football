package com.dirmidante.ndd.football.view;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.adapters.CupTableAdapter;
import com.dirmidante.ndd.football.adapters.LeagueTableAdapter;
import com.dirmidante.ndd.football.model.FootballDataAPI;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.presenter.CompetitionDetailPresenter;
import com.dirmidante.ndd.football.view.interfaces.CompetitionDetailView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_detail)
public class CompetitionDetailActivity extends AppCompatActivity implements CompetitionDetailView {

    public static final String EXTRA_ID = "id";

    @Bean
    protected CompetitionDetailPresenter mPresenter;

    @Bean
    protected LeagueTableAdapter mLeagueTableAdapter;

    @Bean
    protected CupTableAdapter mCupTableAdapter;

    @ViewById(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    @ViewById(R.id.leagueTableList)
    protected RecyclerView mRecyclerView;

    @Extra(EXTRA_ID)
    String mLeagueId;

    private boolean mHasHeader = false;

    @ViewById(R.id.head)
    protected ViewGroup mLayout;

    @AfterInject
    void afterInject() {
        mPresenter.setView(this);
    }

    @AfterViews
    void afterView() {


        mSwipeRefreshLayout.setOnRefreshListener(() ->
                mPresenter.getTableFromNetwork(mLeagueId));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        setAdapter();

        mPresenter.getTableFromRealm(mLeagueId);
    }


    private void setAdapter() {
        if (mLeagueId.equals(FootballDataAPI.CHAMPIONS_LEAGUE_ID)
                || mLeagueId.equals(FootballDataAPI.EUROPEAN_CHAMPIONSHIP_ID))
            mRecyclerView.setAdapter(mCupTableAdapter);
        else mRecyclerView.setAdapter(mLeagueTableAdapter);
    }

    @Override
    public void setTableData(@NonNull LeagueTableData tableData) {
        setHeader();
        mLeagueTableAdapter.setLeagueTableData(tableData);
        mLeagueTableAdapter.notifyDataSetChanged();
    }

    @Override
    public void setTableData(@NonNull CupTableData tableData) {
        mCupTableAdapter.setCupTableData(tableData);
        mCupTableAdapter.notifyDataSetChanged();
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
