package com.dirmidante.ndd.football.model.entity.leaguestabledata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Standing extends RealmObject{

    private static final String POSITION = "position";
    private static final String TEAM_NAME = "teamName";
    private static final String PLAYED_GAMES = "playedGames";
    private static final String POINTS = "points";
    private static final String GOALS = "goals";
    private static final String GOALS_AGAINST = "goalsAgainst";
    private static final String GOAL_DIFFERENCE = "goalDifference";
    private static final String WINS = "wins";
    private static final String DRAWS = "draws";
    private static final String LOSSES = "losses";


    @SerializedName(POSITION)
    @Expose
    private Integer position;
    @SerializedName(TEAM_NAME)
    @Expose
    private String teamName;
    @SerializedName(PLAYED_GAMES)
    @Expose
    private Integer playedGames;
    @SerializedName(POINTS)
    @Expose
    private Integer points;
    @SerializedName(GOALS)
    @Expose
    private Integer goals;
    @SerializedName(GOALS_AGAINST)
    @Expose
    private Integer goalsAgainst;
    @SerializedName(GOAL_DIFFERENCE)
    @Expose
    private Integer goalDifference;
    @SerializedName(WINS)
    @Expose
    private Integer wins;
    @SerializedName(DRAWS)
    @Expose
    private Integer draws;
    @SerializedName(LOSSES)
    @Expose
    private Integer losses;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Standing)) return false;

        Standing standing = (Standing) o;

        if (position != null ? !position.equals(standing.position) : standing.position != null)
            return false;
        if (teamName != null ? !teamName.equals(standing.teamName) : standing.teamName != null)
            return false;
        if (playedGames != null ? !playedGames.equals(standing.playedGames) : standing.playedGames != null)
            return false;
        if (points != null ? !points.equals(standing.points) : standing.points != null)
            return false;
        if (goals != null ? !goals.equals(standing.goals) : standing.goals != null) return false;
        if (goalsAgainst != null ? !goalsAgainst.equals(standing.goalsAgainst) : standing.goalsAgainst != null)
            return false;
        if (goalDifference != null ? !goalDifference.equals(standing.goalDifference) : standing.goalDifference != null)
            return false;
        if (wins != null ? !wins.equals(standing.wins) : standing.wins != null) return false;
        if (draws != null ? !draws.equals(standing.draws) : standing.draws != null) return false;
        return losses != null ? losses.equals(standing.losses) : standing.losses == null;

    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (playedGames != null ? playedGames.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (goals != null ? goals.hashCode() : 0);
        result = 31 * result + (goalsAgainst != null ? goalsAgainst.hashCode() : 0);
        result = 31 * result + (goalDifference != null ? goalDifference.hashCode() : 0);
        result = 31 * result + (wins != null ? wins.hashCode() : 0);
        result = 31 * result + (draws != null ? draws.hashCode() : 0);
        result = 31 * result + (losses != null ? losses.hashCode() : 0);
        return result;
    }
}
