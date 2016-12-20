package com.dirmidante.ndd.football.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.LeagueTableData.LeagueTableData;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.View.Impl.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Dima on 2016-12-19.
 */

public class LeagueTableAdapter extends RecyclerView.Adapter<LeagueTableAdapter.ViewHolder> {

    private LeagueTableData leagueTableData;

    public LeagueTableAdapter(LeagueTableData leagueTableData) {
        this.leagueTableData = leagueTableData;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView leagueTableItem;

        public ViewHolder(CardView leagueTableItem) {
            super(leagueTableItem);
            this.leagueTableItem = leagueTableItem;
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
        CardView leagueTableItem = holder.leagueTableItem;

        TextView title = (TextView) leagueTableItem.findViewById(R.id.title);
        TextView games = (TextView) leagueTableItem.findViewById(R.id.gamesplayed);
        TextView scored = (TextView) leagueTableItem.findViewById(R.id.scored);
        TextView conseded = (TextView) leagueTableItem.findViewById(R.id.conseded);
        TextView win = (TextView) leagueTableItem.findViewById(R.id.win);
        TextView draw = (TextView) leagueTableItem.findViewById(R.id.draw);
        TextView lose = (TextView) leagueTableItem.findViewById(R.id.lose);
        TextView points = (TextView) leagueTableItem.findViewById(R.id.points);
        TextView difference = (TextView) leagueTableItem.findViewById(R.id.difference);

        title.setText(leagueTableData.getStanding().get(position).getTeamName());
        games.setText(leagueTableData.getStanding().get(position).getPlayedGames().toString());
        scored.setText(leagueTableData.getStanding().get(position).getGoals().toString());
        conseded.setText(leagueTableData.getStanding().get(position).getGoalsAgainst().toString());
        win.setText(leagueTableData.getStanding().get(position).getWins().toString());
        draw.setText(leagueTableData.getStanding().get(position).getDraws().toString());
        lose.setText(leagueTableData.getStanding().get(position).getLosses().toString());
        points.setText(leagueTableData.getStanding().get(position).getPoints().toString());
        difference.setText(leagueTableData.getStanding().get(position).getGoalDifference().toString());

    }

    @Override
    public int getItemCount() {
        return leagueTableData.getStanding().size();
    }
}
