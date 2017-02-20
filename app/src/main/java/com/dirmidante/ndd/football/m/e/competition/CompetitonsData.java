package com.dirmidante.ndd.football.m.e.competition;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CompetitonsData extends RealmObject {

    private static final String ID = "id";
    private static final String CAPTION = "caption";
    private static final String YEAR = "year";
    private static final String CURRENT_MATCHDAY = "currentMatchday";
    private static final String NUMBER_OF_MATCHDAYS = "numberOfMatchdays";
    private static final String NUMBER_OF_TEAMS = "numberOfTeams";
    private static final String LAST_UPDATED = "lastUpdated";

    @SerializedName(ID)
    @Expose
    @PrimaryKey
    private Integer id;
    @SerializedName(CAPTION)
    @Expose
    private String caption;
    @SerializedName(YEAR)
    @Expose
    private String year;
    @SerializedName(CURRENT_MATCHDAY)
    @Expose
    private Integer currentMatchday;
    @SerializedName(NUMBER_OF_MATCHDAYS)
    @Expose
    private Integer numberOfMatchdays;
    @SerializedName(NUMBER_OF_TEAMS)
    @Expose
    private Integer numberOfTeams;
    @SerializedName(LAST_UPDATED)
    @Expose
    private String lastUpdated;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(Integer currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public Integer getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    public void setNumberOfMatchdays(Integer numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    public Integer getNumberOfTeams() {
        return numberOfTeams;
    }

    public void setNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompetitonsData)) return false;

        CompetitonsData that = (CompetitonsData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (caption != null ? !caption.equals(that.caption) : that.caption != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (currentMatchday != null ? !currentMatchday.equals(that.currentMatchday) : that.currentMatchday != null)
            return false;
        if (numberOfMatchdays != null ? !numberOfMatchdays.equals(that.numberOfMatchdays) : that.numberOfMatchdays != null)
            return false;
        if (numberOfTeams != null ? !numberOfTeams.equals(that.numberOfTeams) : that.numberOfTeams != null)
            return false;
        return lastUpdated != null ? lastUpdated.equals(that.lastUpdated) : that.lastUpdated == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (currentMatchday != null ? currentMatchday.hashCode() : 0);
        result = 31 * result + (numberOfMatchdays != null ? numberOfMatchdays.hashCode() : 0);
        result = 31 * result + (numberOfTeams != null ? numberOfTeams.hashCode() : 0);
        result = 31 * result + (lastUpdated != null ? lastUpdated.hashCode() : 0);
        return result;
    }
}
