package com.dirmidante.ndd.football.Model.Entity.LeagueTableData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LeagueTableData extends RealmObject{


    @PrimaryKey
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
