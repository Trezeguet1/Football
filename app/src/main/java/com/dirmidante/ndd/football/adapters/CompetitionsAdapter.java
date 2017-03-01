package com.dirmidante.ndd.football.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.R;
import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.List;

import static com.dirmidante.ndd.football.utils.StringUtils.getString;

/**
 * Created by Dima on 2016-12-18.
 */

@EBean
public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<CompetitonsData> mCompetitions = new ArrayList<CompetitonsData>();
    private RecyclerListener mRecyclerListener;

    public void setListener(RecyclerListener listener) {
        if (listener!=null)
        this.mRecyclerListener = listener;
    }

    public void setCompetitions(List<CompetitonsData> competitions) {
        if (competitions!=null)
        mCompetitions = competitions;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView mView;

        private TextView mCaption;
        private TextView mCurrentMatchDay;
        private TextView mNumberOfTeams;
        private TextView mLastUpdate;

        public void setData(CompetitonsData competition) {
            mCaption.setText(competition.getCaption());
            String matchday = getString(R.string.currentMatchDay);
            String teamsNumber = getString(R.string.numberOfTeams);
            String updated = getString(R.string.LastUpdate);

            if (competition.getCurrentMatchday() != null) {
                matchday = String.format("%s%d/", matchday, competition.getCurrentMatchday());
                if (competition.getNumberOfMatchdays() != null) {
                    matchday = String.format("%s%d", matchday, competition.getNumberOfMatchdays());
                }
            }

            if (competition.getNumberOfTeams() != null)
                teamsNumber = String.format("%s%d", teamsNumber, competition.getNumberOfTeams());

            if (competition.getLastUpdated() != null)
                updated = String.format("%s%s", updated, competition.getLastUpdated());
            mLastUpdate.setText(updated);
            mNumberOfTeams.setText(teamsNumber);
            mCurrentMatchDay.setText(matchday);
        }

        public ViewHolder(CardView competitionCard) {
            super(competitionCard);
            this.mView = competitionCard;
            this.mCaption = (TextView) mView.findViewById(R.id.caption);
            this.mCurrentMatchDay = (TextView) mView.findViewById(R.id.current_matchday);
            this.mNumberOfTeams = (TextView) mView.findViewById(R.id.number_of_teams);
            this.mLastUpdate = (TextView) mView.findViewById(R.id.last_update);
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
        holder.setData(mCompetitions.get(position));
        competitionItem.setOnClickListener(v -> {
            if (mRecyclerListener != null) {
                mRecyclerListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        int count = (mCompetitions != null) ? mCompetitions.size() : 0;
        return count;
    }


}
