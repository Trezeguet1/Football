package com.dirmidante.ndd.football.a;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.m.e.competition.CompetitonsData;

import java.util.ArrayList;
import java.util.List;

import static com.dirmidante.ndd.football.utils.StringUtils.getString;

/**
 * Created by Dima on 2016-12-18.
 */

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<CompetitonsData> mCompetitions = new ArrayList<CompetitonsData>();
    private RecyclerListener mRecyclerListener;

    public void setListener(@NonNull RecyclerListener listener) {
        this.mRecyclerListener = listener;
    }

    public void setCompetitions(@NonNull List<CompetitonsData> competitions) {
        mCompetitions = competitions;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mView;

        public ViewHolder(CardView competitionCard) {
            super(competitionCard);
            this.mView = competitionCard;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView competitionItem = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.competition_item, parent, false);
        return new ViewHolder(competitionItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        CardView competitionItem = holder.mView;

        TextView caption = (TextView) competitionItem.findViewById(R.id.caption);
        TextView currentMatchDay = (TextView) competitionItem.findViewById(R.id.current_matchday);
        TextView numberOfTeams = (TextView) competitionItem.findViewById(R.id.number_of_teams);
        TextView lastUpdate = (TextView) competitionItem.findViewById(R.id.last_update);


        caption.setText(mCompetitions.get(position).getCaption());

        String matchday = getString(R.string.currentMatchDay);
        String teamsNumber = getString(R.string.numberOfTeams);
        String updated = getString(R.string.LastUpdate);


        if (mCompetitions.get(position).getCurrentMatchday() != null) {

            matchday = String.format("%s%d/", matchday, mCompetitions.get(position).getCurrentMatchday());
            if (mCompetitions.get(position).getNumberOfMatchdays() != null) {
                matchday = String.format("%s%d", matchday, mCompetitions.get(position).getNumberOfMatchdays());
            }
        }
        if (mCompetitions.get(position).getNumberOfTeams() != null) {
            teamsNumber = String.format("%s%d", teamsNumber, mCompetitions.get(position).getNumberOfTeams());

        }

        if (mCompetitions.get(position).getLastUpdated() != null)
            updated = String.format("%s%s", updated, mCompetitions.get(position).getLastUpdated());

        lastUpdate.setText(updated);
        numberOfTeams.setText(teamsNumber);
        currentMatchDay.setText(matchday);
        competitionItem.setOnClickListener(v -> {
            if (mRecyclerListener != null) {
                mRecyclerListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        int count=(mCompetitions!=null)?mCompetitions.size():0;
        return count;
    }


}
