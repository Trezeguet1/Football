package com.dirmidante.ndd.football.Model.Entity.LeagueTableData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class LeagueTableData extends RealmObject{


    @SerializedName("leagueCaption")
    @Expose
    private String leagueCaption = null;

    @SerializedName("standing")
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

    public String getLeagueCaption() {
        return leagueCaption;
    }

    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }
}
