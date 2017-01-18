package com.dirmidante.ndd.football.Model.Entity.CompetitonsData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class CompetitonsData extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("currentMatchday")
    @Expose
    private Integer currentMatchday;
    @SerializedName("numberOfMatchdays")
    @Expose
    private Integer numberOfMatchdays;
    @SerializedName("numberOfTeams")
    @Expose
    private Integer numberOfTeams;
    @SerializedName("lastUpdated")
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

}
