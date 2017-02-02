package com.dirmidante.ndd.football.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.CupTableData.Group;
import com.dirmidante.ndd.football.R;
import io.realm.RealmList;

/**
 * Created by Dima on 2016-12-20.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder>{

    private RealmList<Group> mTeams;

    public void setTeams(RealmList<Group> teams) {
        this.mTeams = teams;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
    CardView mTableItem;

    public ViewHolder(CardView tableItem) {
        super(tableItem);
        this.mTableItem = tableItem;
    }
}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView leagueTableItem = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_table_item, parent, false);
        return new ViewHolder(leagueTableItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView tableItem = holder.mTableItem;

        TextView rank = (TextView) tableItem.findViewById(R.id.position);
        TextView title = (TextView) tableItem.findViewById(R.id.title);
        TextView games = (TextView) tableItem.findViewById(R.id.gamesplayed);
        TextView scored = (TextView) tableItem.findViewById(R.id.scored);
        TextView conseded = (TextView) tableItem.findViewById(R.id.conseded);
        TextView points = (TextView) tableItem.findViewById(R.id.points);
        TextView difference = (TextView) tableItem.findViewById(R.id.difference);

        rank.setText(Integer.toString(mTeams.get(position).getRank()));
        title.setText(mTeams.get(position).getTeam());
        games.setText(mTeams.get(position).getPlayedGames().toString());
        scored.setText(mTeams.get(position).getGoals().toString());
        conseded.setText(mTeams.get(position).getGoalsAgainst().toString());
        points.setText(mTeams.get(position).getPoints().toString());
        difference.setText(mTeams.get(position).getGoalDifference().toString());
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }
}
