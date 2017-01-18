
package com.dirmidante.ndd.football.Model.Entity.CupTableData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class CupTableData extends RealmObject{


    @SerializedName("leagueCaption")
    @Expose
    private String leagueCaption = null;

    @SerializedName("standings")
    @Expose
    private Standings standings;


    public Standings getStandings() {
        return standings;
    }

    public void setStandings(Standings standings) {
        this.standings = standings;
    }

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }
}
