
package com.dirmidante.ndd.football.m.e.cuptable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Group extends RealmObject{

    private static final String GROUP = "group";
    private static final String RANK = "rank";
    private static final String TEAM = "team";
    private static final String TEAM_ID = "teamId";
    private static final String PLAYED_GAMES = "playedGames";
    private static final String POINTS = "points";
    private static final String GOALS = "goals";
    private static final String GOALS_AGAINST = "goalsAgainst";
    private static final String GOAL_DIFFERENCE = "goalDifference";


    @SerializedName(GROUP)
    @Expose
    private String group;
    @SerializedName(RANK)
    @Expose
    private Integer rank;
    @SerializedName(TEAM)
    @Expose
    private String team;
    @SerializedName(TEAM_ID)
    @Expose
    private Integer teamId;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(Integer playedGames) {
        this.playedGames = playedGames;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(Integer goalDifference) {
        this.goalDifference = goalDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group1 = (Group) o;

        if (group != null ? !group.equals(group1.group) : group1.group != null) return false;
        if (rank != null ? !rank.equals(group1.rank) : group1.rank != null) return false;
        if (team != null ? !team.equals(group1.team) : group1.team != null) return false;
        if (teamId != null ? !teamId.equals(group1.teamId) : group1.teamId != null) return false;
        if (playedGames != null ? !playedGames.equals(group1.playedGames) : group1.playedGames != null)
            return false;
        if (points != null ? !points.equals(group1.points) : group1.points != null) return false;
        if (goals != null ? !goals.equals(group1.goals) : group1.goals != null) return false;
        if (goalsAgainst != null ? !goalsAgainst.equals(group1.goalsAgainst) : group1.goalsAgainst != null)
            return false;
        return goalDifference != null ? goalDifference.equals(group1.goalDifference) : group1.goalDifference == null;

    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + (team != null ? team.hashCode() : 0);
        result = 31 * result + (teamId != null ? teamId.hashCode() : 0);
        result = 31 * result + (playedGames != null ? playedGames.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (goals != null ? goals.hashCode() : 0);
        result = 31 * result + (goalsAgainst != null ? goalsAgainst.hashCode() : 0);
        result = 31 * result + (goalDifference != null ? goalDifference.hashCode() : 0);
        return result;
    }
}
