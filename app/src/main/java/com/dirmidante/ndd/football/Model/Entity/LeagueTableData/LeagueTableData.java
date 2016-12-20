package com.dirmidante.ndd.football.Model.Entity.LeagueTableData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueTableData {

    @Override
    public String toString() {
        return "\nLeagueTableData{" +
                "\n\tstanding=" + standing +
                '}';
    }

    @SerializedName("standing")
    @Expose
    private List<Standing> standing = null;

       /**
     * 
     * @return
     *     The standing
     */
    public List<Standing> getStanding() {
        return standing;
    }

    /**
     * 
     * @param standing
     *     The standing
     */
    public void setStanding(List<Standing> standing) {
        this.standing = standing;
    }

}
