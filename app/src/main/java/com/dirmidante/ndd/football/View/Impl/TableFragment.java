package com.dirmidante.ndd.football.View.Impl;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirmidante.ndd.football.Adapter.CupTableAdapter;
import com.dirmidante.ndd.football.Adapter.LeagueTableAdapter;
import com.dirmidante.ndd.football.Model.Entity.CupTableData.CupTableData;
import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.ITablePresenter;
import com.dirmidante.ndd.football.Presenter.Impl.TablePresenter;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.TableView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableFragment extends Fragment implements TableView {

    private ITablePresenter mPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private boolean mHasHeader = false;
    private View mLayout;
    private String mLeagueId;

    public TableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mLayout = inflater.inflate(R.layout.fragment_table, container, false);
        mLeagueId = ((CompetitionDetailActivity) getActivity()).getLeagueId();

        mSwipeRefreshLayout = (SwipeRefreshLayout) mLayout.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getTableFromNetwork(mLeagueId));


        mRecyclerView = (RecyclerView) mLayout.findViewById(R.id.leagueTableList);
        mPresenter = new TablePresenter(this, new FootballDataAPI());
        mPresenter.getTableFromRealm(mLeagueId);
        return mLayout;
    }

    @Override
    public void setTableData(@NonNull LeagueTableData tableData) {
        Log.v("mytag", "a");
        setHeader();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        LeagueTableAdapter leagueTableAdapter = new LeagueTableAdapter();
        leagueTableAdapter.setLeagueTableData(tableData);
        mRecyclerView.setAdapter(leagueTableAdapter);
    }

    @Override
    public void setTableData(@NonNull CupTableData tableData) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        CupTableAdapter cupTableadapter = new CupTableAdapter();
        cupTableadapter.setCupTableData(tableData);
        mRecyclerView.setAdapter(cupTableadapter);

    }

    @Override
    public void setHeader() {
        if (!mHasHeader) {
            CardView header = (CardView) LayoutInflater.from(getActivity()).inflate(R.layout.table_header, null);
            ViewGroup head = (ViewGroup) mLayout.findViewById(R.id.head);
            head.addView(header, 0);
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
