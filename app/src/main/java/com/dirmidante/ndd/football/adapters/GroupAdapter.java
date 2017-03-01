package com.dirmidante.ndd.football.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.model.entity.cuptable.Group;

import org.androidannotations.annotations.EBean;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by Dima on 2016-12-20.
 */

@EBean
public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private List<Group> mTeams = new RealmList<Group>();

    public void setTeams(@NonNull List<Group> teams) {
        this.mTeams = teams;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView mTableItem;

        private TextView rank;
        private TextView title;
        private TextView games;
        private TextView scored;
        private TextView conseded;
        private TextView points;
        private TextView difference;

        public ViewHolder(CardView tableItem) {
            super(tableItem);
            this.mTableItem = tableItem;
            rank = (TextView) tableItem.findViewById(R.id.position);
            title = (TextView) tableItem.findViewById(R.id.title);
            games = (TextView) tableItem.findViewById(R.id.gamesplayed);
            scored = (TextView) tableItem.findViewById(R.id.scored);
            conseded = (TextView) tableItem.findViewById(R.id.conseded);
            points = (TextView) tableItem.findViewById(R.id.points);
            difference = (TextView) tableItem.findViewById(R.id.difference);

        }

        public void setData(Group team) {
            rank.setText(String.format("%d", team.getRank()));
            title.setText(String.format("%s", team.getTeam()));
            games.setText(String.format("%d", team.getPlayedGames()));
            scored.setText(String.format("%d", team.getGoals()));
            conseded.setText(String.format("%d", team.getGoalsAgainst()));
            points.setText(String.format("%d", team.getPoints()));
            difference.setText(String.format("%d", team.getGoalDifference()));
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
        holder.setData(mTeams.get(position));
    }

    @Override
    public int getItemCount() {
        int count = (mTeams != null) ? mTeams.size() : 0;
        return count;
    }
}
