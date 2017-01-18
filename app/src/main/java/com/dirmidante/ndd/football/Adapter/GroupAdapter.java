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

    private RealmList<Group> teams = null;

    public GroupAdapter(RealmList<Group> teams) {
        this.teams = teams;
    }

class ViewHolder extends RecyclerView.ViewHolder{
    CardView tableItem;

    public ViewHolder(CardView tableItem) {
        super(tableItem);
        this.tableItem = tableItem;
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
        CardView tableItem = holder.tableItem;

        TextView title = (TextView) tableItem.findViewById(R.id.title);
        TextView games = (TextView) tableItem.findViewById(R.id.gamesplayed);
        TextView scored = (TextView) tableItem.findViewById(R.id.scored);
        TextView conseded = (TextView) tableItem.findViewById(R.id.conseded);
        TextView points = (TextView) tableItem.findViewById(R.id.points);
        TextView difference = (TextView) tableItem.findViewById(R.id.difference);

        title.setText(teams.get(position).getTeam());
        games.setText(teams.get(position).getPlayedGames().toString());
        scored.setText(teams.get(position).getGoals().toString());
        conseded.setText(teams.get(position).getGoalsAgainst().toString());
        points.setText(teams.get(position).getPoints().toString());
        difference.setText(teams.get(position).getGoalDifference().toString());
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }
}
