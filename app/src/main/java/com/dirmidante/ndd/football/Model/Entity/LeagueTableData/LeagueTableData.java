package com.dirmidante.ndd.football.Model.Entity.LeagueTableData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueTableData {

    @Override
    public String toString() {
        return "\nLeagueTableData{" +
                "\n\tlinks=" + links +
                "\n\tleagueCaption='" + leagueCaption + '\'' +
                "\n\tmatchday=" + matchday +
                "\n\tstanding=" + standing +
                '}';
    }

    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("leagueCaption")
    @Expose
    private String leagueCaption;
    @SerializedName("matchday")
    @Expose
    private Integer matchday;
    @SerializedName("standing")
    @Expose
    private List<Standing> standing = null;

    /**
     * 
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The leagueCaption
     */
    public String getLeagueCaption() {
        return leagueCaption;
    }

    /**
     * 
     * @param leagueCaption
     *     The leagueCaption
     */
    public void setLeagueCaption(String leagueCaption) {
        this.leagueCaption = leagueCaption;
    }

    /**
     * 
     * @return
     *     The matchday
     */
    public Integer getMatchday() {
        return matchday;
    }

    /**
     * 
     * @param matchday
     *     The matchday
     */
    public void setMatchday(Integer matchday) {
        this.matchday = matchday;
    }

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
