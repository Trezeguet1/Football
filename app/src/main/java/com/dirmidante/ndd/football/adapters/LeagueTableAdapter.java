package com.dirmidante.ndd.football.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.Standing;

import org.androidannotations.annotations.EBean;

/**
 * Created by Dima on 2016-12-19.
 */

@EBean
public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.ViewHolder> {

    private LeagueTableData mLeagueTableData = new LeagueTableData();

    public void setLeagueTableData(LeagueTableData leagueTableData) {
        if (leagueTableData != null)
            this.mLeagueTableData = leagueTableData;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mLeagueTableItem;

        private TextView mRank;
        private TextView mTitle;
        private TextView mGames;
        private TextView mScored;
        private TextView mConseded;
        private TextView mWin;
        private TextView mDraw;
        private TextView mLose;
        private TextView mPoints;
        private TextView mDifference;


        public void setData(Standing standing) {
            mRank.setText(String.format("%d", standing.getPosition()));
            mTitle.setText(String.format("%s", standing.getTeamName()));
            mGames.setText(String.format("%d", standing.getPlayedGames()));
            mScored.setText(String.format("%d", standing.getGoals()));
            mConseded.setText(String.format("%d", standing.getGoalsAgainst()));
            mWin.setText(String.format("%d", standing.getWins()));
            mDraw.setText(String.format("%d", standing.getDraws()));
            mLose.setText(String.format("%d", standing.getLosses()));
            mPoints.setText(String.format("%d", standing.getPoints()));
            mDifference.setText(String.format("%d", standing.getGoalDifference()));
        }

        public ViewHolder(CardView leagueTableItem) {
            super(leagueTableItem);
            this.mLeagueTableItem = leagueTableItem;
            mRank = (TextView) leagueTableItem.findViewById(R.id.position);
            mTitle = (TextView) leagueTableItem.findViewById(R.id.title);
            mGames = (TextView) leagueTableItem.findViewById(R.id.gamesplayed);
            mScored = (TextView) leagueTableItem.findViewById(R.id.scored);
            mConseded = (TextView) leagueTableItem.findViewById(R.id.conseded);
            mWin = (TextView) leagueTableItem.findViewById(R.id.win);
            mDraw = (TextView) leagueTableItem.findViewById(R.id.draw);
            mLose = (TextView) leagueTableItem.findViewById(R.id.lose);
            mPoints = (TextView) leagueTableItem.findViewById(R.id.points);
            mDifference = (TextView) leagueTableItem.findViewById(R.id.difference);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView leagueTableItem = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.league_table_item, parent, false);
        return new ViewHolder(leagueTableItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView leagueTableItem = holder.mLeagueTableItem;
        holder.setData(mLeagueTableData.getStanding().get(position));


    }

    @Override
    public int getItemCount() {
        int count = (mLeagueTableData.getStanding() != null) ? mLeagueTableData.getStanding().size() : 0;
        return count;
    }
}
