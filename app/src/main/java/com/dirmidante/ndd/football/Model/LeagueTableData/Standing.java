package com.dirmidante.ndd.football.Model.LeagueTableData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Standing {

    @Override
    public String toString() {
        return "\nStanding{" +
                "links=" + links +
                ", position=" + position +
                ", teamName='" + teamName + '\'' +
                ", crestURI='" + crestURI + '\'' +
                ", playedGames=" + playedGames +
                ", points=" + points +
                ", goals=" + goals +
                ", goalsAgainst=" + goalsAgainst +
                ", goalDifference=" + goalDifference +
                ", wins=" + wins +
                ", draws=" + draws +
                ", losses=" + losses +
                ", home=" + home +
                ", away=" + away +
                '}';
    }

    @SerializedName("_links")
    @Expose
    private Links_ links;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("crestURI")
    @Expose
    private String crestURI;
    @SerializedName("playedGames")
    @Expose
    private Integer playedGames;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("goals")
    @Expose
    private Integer goals;
    @SerializedName("goalsAgainst")
    @Expose
    private Integer goalsAgainst;
    @SerializedName("goalDifference")
    @Expose
    private Integer goalDifference;
    @SerializedName("wins")
    @Expose
    private Integer wins;
    @SerializedName("draws")
    @Expose
    private Integer draws;
    @SerializedName("losses")
    @Expose
    private Integer losses;
    @SerializedName("home")
    @Expose
    private Home home;
    @SerializedName("away")
    @Expose
    private Away away;

    /**
     * 
     * @return
     *     The links
     */
    public Links_ getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(Links_ links) {
        this.links = links;
    }

    /**
     * 
     * @return
     *     The position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 
     * @return
     *     The teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 
     * @param teamName
     *     The teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 
     * @return
     *     The crestURI
     */
    public String getCrestURI() {
        return crestURI;
    }

    /**
     * 
     * @param crestURI
     *     The crestURI
     */
    public void setCrestURI(String crestURI) {
        this.crestURI = crestURI;
    }

    /**
     * 
     * @return
     *     The playedGames
     */
    public Integer getPlayedGames() {
        return playedGames;
    }

    /**
     * 
     * @param playedGames
     *     The playedGames
     */
    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    /**
     * 
     * @return
     *     The points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * 
     * @param points
     *     The points
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     * 
     * @return
     *     The goals
     */
    public Integer getGoals() {
        return goals;
    }

    /**
     * 
     * @param goals
     *     The goals
     */
    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    /**
     * 
     * @return
     *     The goalsAgainst
     */
    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    /**
     * 
     * @param goalsAgainst
     *     The goalsAgainst
     */
    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    /**
     * 
     * @return
     *     The goalDifference
     */
    public Integer getGoalDifference() {
        return goalDifference;
    }

    /**
     * 
     * @param goalDifference
     *     The goalDifference
     */
    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    /**
     * 
     * @return
     *     The wins
     */
    public Integer getWins() {
        return wins;
    }

    /**
     * 
     * @param wins
     *     The wins
     */
    public void setWins(Integer wins) {
        this.wins = wins;
    }

    /**
     * 
     * @return
     *     The draws
     */
    public Integer getDraws() {
        return draws;
    }

    /**
     * 
     * @param draws
     *     The draws
     */
    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    /**
     * 
     * @return
     *     The losses
     */
    public Integer getLosses() {
        return losses;
    }

    /**
     * 
     * @param losses
     *     The losses
     */
    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    /**
     * 
     * @return
     *     The home
     */
    public Home getHome() {
        return home;
    }

    /**
     * 
     * @param home
     *     The home
     */
    public void setHome(Home home) {
        this.home = home;
    }

    /**
     * 
     * @return
     *     The away
     */
    public Away getAway() {
        return away;
    }

    /**
     * 
     * @param away
     *     The away
     */
    public void setAway(Away away) {
        this.away = away;
    }

}
