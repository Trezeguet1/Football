package com.dirmidante.ndd.football.Model.Entity.LeagueTableData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LeagueTableData extends RealmObject{


    private static final String STANDING = "standing";
    @PrimaryKey
    private String id;

    @SerializedName(STANDING)
    @Expose
    private RealmList<Standing> standing = null;

       /**
     * 
     * @return
     *     The standing
     */
    public RealmList<Standing> getStanding() {
        return standing;
    }

    /**
     * 
     * @param standing
     *     The standing
     */
    public void setStanding(RealmList<Standing> standing) {
        this.standing = standing;
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
        if (!(o instanceof LeagueTableData)) return false;

        LeagueTableData that = (LeagueTableData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return standing != null ? standing.equals(that.standing) : that.standing == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (standing != null ? standing.hashCode() : 0);
        return result;
    }
}
