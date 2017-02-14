package com.dirmidante.ndd.football.View.Impl;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirmidante.ndd.football.Adapter.CupTableAdapter;
import com.dirmidante.ndd.football.Adapter.LeagueTableAdapter;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Presenter.Impl.TablePresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.TableView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * A simple {@link Fragment} subclass.
 */

@EFragment(R.layout.fragment_table)
public class TableFragment extends Fragment implements TableView {

    @Bean
    protected TablePresenter mPresenter;

    @Bean
    protected LeagueTableAdapter mLeagueTableAdapter;

    @Bean
    protected CupTableAdapter mCupTableAdapter;

    @ViewById(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    @ViewById(R.id.leagueTableList)
    protected RecyclerView mRecyclerView;


    private boolean mHasHeader = false;

    @ViewById(R.id.head)
    protected ViewGroup mLayout;

    private String mLeagueId;

    public TableFragment() {
        // Required empty public constructor
    }

    @AfterInject
    void afterInject() {
        mPresenter.setView(this);
    }

    @AfterViews
    void afterView() {
        mLeagueId = ((CompetitionDetailActivity_) getActivity()).getLeagueId();
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getTableFromNetwork(mLeagueId));
        mPresenter.getTableFromRealm(mLeagueId);
    }

    @Override
    public void setTableData(@NonNull LeagueTableData tableData) {
        setHeader();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mLeagueTableAdapter.setLeagueTableData(tableData);
        mRecyclerView.setAdapter(mLeagueTableAdapter);
    }

    @Override
    public void setTableData(@NonNull CupTableData tableData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mCupTableAdapter.setCupTableData(tableData);
        mRecyclerView.setAdapter(mCupTableAdapter);

    }

    @Override
    public void setHeader() {
        if (!mHasHeader) {
            View header = LayoutInflater.from(getActivity()).inflate(R.layout.table_header, null);
            mLayout.addView(header, 0);
            mHasHeader = true;
        }
    }

    @Override
    public void showNoConnectionMessage() {
        Toast.makeText(getContext(), R.string.noInternetConnection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), R.string.noInfo, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }


    @Override
    public void showRefreshMessage() {
        Toast.makeText(getContext(), R.string.infoRefreshed, Toast.LENGTH_SHORT).show();
    }
}
