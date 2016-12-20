package com.dirmidante.ndd.football.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.R;

import java.util.List;

/**
 * Created by Dima on 2016-12-18.
 */

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {


    private List<CompetitonsData> competitions;
    private RecyclerListener onCompetitionClickListener;

    public void setListener(RecyclerListener listener){
        this.onCompetitionClickListener = listener;
    }

    public CompetitionsAdapter(List<CompetitonsData> competitions) {
        this.competitions = competitions;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CardView competitionCard;

        public ViewHolder(CardView competitionCard) {
            super(competitionCard);
            this.competitionCard = competitionCard;
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

        CardView competitionItem = holder.competitionCard;

        TextView caption = (TextView) competitionItem.findViewById(R.id.caption);
        TextView currentMatchDay = (TextView) competitionItem.findViewById(R.id.current_matchday);
        TextView numberOfTeams = (TextView) competitionItem.findViewById(R.id.number_of_teams);
        TextView lastUpdate = (TextView) competitionItem.findViewById(R.id.last_update);


        caption.setText(competitions.get(position).getCaption());
        currentMatchDay.setText("Current Matchday "
                +competitions.get(position).getCurrentMatchday().toString()+"/"
        +competitions.get(position).getNumberOfMatchdays().toString());
        numberOfTeams.setText("Number Of Teams "+competitions.get(position).getNumberOfTeams().toString());
        lastUpdate.setText("Last Updated "+competitions.get(position).getLastUpdated());

        competitionItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCompetitionClickListener!= null){
                    onCompetitionClickListener.onClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }


   }
