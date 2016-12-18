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
    public void onBindViewHolder(ViewHolder holder, int position) {

        CardView competitionItem = holder.competitionCard;

        TextView id = (TextView) competitionItem.findViewById(R.id.id);
        TextView caption = (TextView) competitionItem.findViewById(R.id.caption);
        TextView league = (TextView) competitionItem.findViewById(R.id.league);
        TextView year = (TextView) competitionItem.findViewById(R.id.year);
        TextView currentMatchDay = (TextView) competitionItem.findViewById(R.id.current_matchday);
        TextView numberOfMatchdays = (TextView) competitionItem.findViewById(R.id.number_of_matchdays);
        TextView numberOfTeams = (TextView) competitionItem.findViewById(R.id.number_of_teams);
        TextView numberOfGames = (TextView) competitionItem.findViewById(R.id.number_of_games);
        TextView lastUpdate = (TextView) competitionItem.findViewById(R.id.last_update);


        id.setText(competitions.get(position).getId().toString());
        caption.setText(competitions.get(position).getCaption());
        league.setText(competitions.get(position).getLeague());
        year.setText(competitions.get(position).getYear());
        currentMatchDay.setText(competitions.get(position).getCurrentMatchday().toString());
        numberOfMatchdays.setText(competitions.get(position).getNumberOfMatchdays().toString());
        numberOfTeams.setText(competitions.get(position).getNumberOfTeams().toString());
        numberOfGames.setText(competitions.get(position).getNumberOfGames().toString());
        lastUpdate.setText(competitions.get(position).getLastUpdated());

        competitionItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }


}
