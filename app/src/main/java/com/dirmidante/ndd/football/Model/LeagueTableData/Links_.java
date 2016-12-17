package com.dirmidante.ndd.football.Model.LeagueTableData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("team")
    @Expose
    private Team team;

    /**
     * 
     * @return
     *     The team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * 
     * @param team
     *     The team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

}
