package com.dirmidante.ndd.football.Adapter;

import static com.dirmidante.ndd.football.utils.StringUtils.getString;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.utils.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by Dima on 2016-12-18.
 */

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<CompetitonsData> mCompetitions;
    private RecyclerListener mRecyclerListener;
    private Context mContext;

    public void setListener(RecyclerListener listener) {
        this.mRecyclerListener = listener;
    }

    public void setCompetitions(List<CompetitonsData> competitions) {
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
        mContext = parent.getContext();
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
//TODO avoid copy-past
        String matchday = getString(R.string.currentMatchDay);
        String teamsNumber = getString(R.string.numberOfTeams);
        String updated = getString(R.string.LastUpdate);



        if (mCompetitions.get(position).getCurrentMatchday() != null) {
            //TODO use String.format instead of concat it's more readable. Replace concat in all code by format logic.
            matchday = String.format("%s%d/", matchday, mCompetitions.get(position).getCurrentMatchday());
            if (mCompetitions.get(position).getNumberOfMatchdays() != null) {
                matchday = matchday.concat(mCompetitions.get(position).getNumberOfMatchdays().toString());
            }
        }
        if (mCompetitions.get(position).getNumberOfTeams().toString() != null) {
            teamsNumber = teamsNumber.concat(mCompetitions.get(position).getNumberOfTeams().toString());
        }

        if (mCompetitions.get(position).getLastUpdated()!=null)
                updated = updated.concat(mCompetitions.get(position).getLastUpdated());

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
        //TODO steal potential bug NullpoinerException, is never initialized locally.
        return mCompetitions.size();
    }


}
