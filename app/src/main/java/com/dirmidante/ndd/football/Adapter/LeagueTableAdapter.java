package com.dirmidante.ndd.football.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.R;

/**
 * Created by Dima on 2016-12-19.
 */

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.ViewHolder> {

    private LeagueTableData mLeagueTableData;

    public void setLeagueTableData(LeagueTableData leagueTableData) {
        this.mLeagueTableData = leagueTableData;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mLeagueTableItem;

        public ViewHolder(CardView leagueTableItem) {
            super(leagueTableItem);
            this.mLeagueTableItem = leagueTableItem;
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

        TextView rank = (TextView) leagueTableItem.findViewById(R.id.position);
        TextView title = (TextView) leagueTableItem.findViewById(R.id.title);
        TextView games = (TextView) leagueTableItem.findViewById(R.id.gamesplayed);
        TextView scored = (TextView) leagueTableItem.findViewById(R.id.scored);
        TextView conseded = (TextView) leagueTableItem.findViewById(R.id.conseded);
        TextView win = (TextView) leagueTableItem.findViewById(R.id.win);
        TextView draw = (TextView) leagueTableItem.findViewById(R.id.draw);
        TextView lose = (TextView) leagueTableItem.findViewById(R.id.lose);
        TextView points = (TextView) leagueTableItem.findViewById(R.id.points);
        TextView difference = (TextView) leagueTableItem.findViewById(R.id.difference);

        rank.setText(Integer.toString(mLeagueTableData.getStanding().get(position).getPosition()));
        title.setText(mLeagueTableData.getStanding().get(position).getTeamName());
        games.setText(mLeagueTableData.getStanding().get(position).getPlayedGames().toString());
        scored.setText(mLeagueTableData.getStanding().get(position).getGoals().toString());
        conseded.setText(mLeagueTableData.getStanding().get(position).getGoalsAgainst().toString());
        win.setText(mLeagueTableData.getStanding().get(position).getWins().toString());
        draw.setText(mLeagueTableData.getStanding().get(position).getDraws().toString());
        lose.setText(mLeagueTableData.getStanding().get(position).getLosses().toString());
        points.setText(mLeagueTableData.getStanding().get(position).getPoints().toString());
        difference.setText(mLeagueTableData.getStanding().get(position).getGoalDifference().toString());

    }

    @Override
    public int getItemCount() {
        return mLeagueTableData.getStanding().size();
    }
}
