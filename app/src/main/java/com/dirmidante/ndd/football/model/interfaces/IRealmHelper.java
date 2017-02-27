package com.dirmidante.ndd.football.model.interfaces;


import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Dima on 19.01.2017.
 */

public interface IRealmHelper {
    public <T extends RealmObject> void writeToRealm(T data);

    List<CompetitonsData> getCompetitions();

    LeagueTableData getLeagueTable(String leagueId);

    CupTableData getCupTable(String cupId);

    boolean hasCompetitions();

    boolean hasLeague(String leagueId);

    boolean hasCup(String cupId);

}
