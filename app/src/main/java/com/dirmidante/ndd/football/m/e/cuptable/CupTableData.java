
package com.dirmidante.ndd.football.m.e.cuptable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CupTableData extends RealmObject{

    private static final String STANDINGS =  "standings";

    @PrimaryKey
    private String id;

    @SerializedName(STANDINGS)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CupTableData)) return false;

        CupTableData that = (CupTableData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return standings != null ? standings.equals(that.standings) : that.standings == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (standings != null ? standings.hashCode() : 0);
        return result;
    }

}