package com.dirmidante.ndd.football.Model.CompetitonsData;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links {

    @Override
    public String toString() {
        return "Links{" +
                "\n\t\tself=" + self +
                "\n\t\tteams=" + teams +
                "\n\t\tfixtures=" + fixtures +
                "\n\t\tleagueTable=" + leagueTable +
                '}';
    }

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("teams")
    @Expose
    private Teams teams;
    @SerializedName("fixtures")
    @Expose
    private Fixtures fixtures;
    @SerializedName("leagueTable")
    @Expose
    private LeagueTable leagueTable;

    /**
     * 
     * @return
     *     The self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The teams
     */
    public Teams getTeams() {
        return teams;
    }

    /**
     * 
     * @param teams
     *     The teams
     */
    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    /**
     * 
     * @return
     *     The fixtures
     */
    public Fixtures getFixtures() {
        return fixtures;
    }

    /**
     * 
     * @param fixtures
     *     The fixtures
     */
    public void setFixtures(Fixtures fixtures) {
        this.fixtures = fixtures;
    }

    /**
     * 
     * @return
     *     The leagueTable
     */
    public LeagueTable getLeagueTable() {
        return leagueTable;
    }

    /**
     * 
     * @param leagueTable
     *     The leagueTable
     */
    public void setLeagueTable(LeagueTable leagueTable) {
        this.leagueTable = leagueTable;
    }

}
