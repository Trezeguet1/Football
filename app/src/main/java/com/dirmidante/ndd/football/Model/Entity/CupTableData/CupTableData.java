
package com.dirmidante.ndd.football.Model.Entity.CupTableData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CupTableData {

    @SerializedName("standings")
    @Expose
    private Standings standings;



    public Standings getStandings() {
        return standings;
    }

    public void setStandings(Standings standings) {
        this.standings = standings;
    }

}
