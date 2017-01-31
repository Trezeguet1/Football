
package com.dirmidante.ndd.football.Model.Entity.CupTableData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CupTableData extends RealmObject{


    @PrimaryKey
    private String id;

    @SerializedName("standings")
    @Expose
    private Standings standings;


    public Standings getStandings() {
        return standings;
    }

    public void setStandings(Standings standings) {
        this.standings = standings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
