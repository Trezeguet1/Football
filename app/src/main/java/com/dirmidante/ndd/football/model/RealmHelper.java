package com.dirmidante.ndd.football.model;

import android.content.Context;

import com.dirmidante.ndd.football.model.entity.competition.CompetitonsData;
import com.dirmidante.ndd.football.model.entity.cuptable.CupTableData;
import com.dirmidante.ndd.football.model.entity.leaguetable.LeagueTableData;
import com.dirmidante.ndd.football.model.interfaces.IRealmHelper;

import org.androidannotations.annotations.EBean;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Dima on 18.01.2017.
 */


@EBean
public class RealmHelper implements IRealmHelper {

    public static final String ID = "id";


    @Override
    public <T extends RealmObject> void writeToRealm(T data) {
        Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(transaction -> realm.copyToRealmOrUpdate(data));
    }


    @Override
    public List<CompetitonsData> getCompetitions() {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<CompetitonsData> result = realm.where(CompetitonsData.class).findAll();
        return result;
    }

    @Override
    public LeagueTableData getLeagueTable(String leagueId) {
        Realm realm = Realm.getDefaultInstance();
        LeagueTableData result = realm.where(LeagueTableData.class)
                .equalTo(ID, leagueId)
                .findFirst();
        return result;
    }

    @Override
    public CupTableData getCupTable(String cupId) {
        Realm realm = Realm.getDefaultInstance();
        CupTableData result = realm.where(CupTableData.class)
                .equalTo(ID, cupId)
                .findFirst();
        return result;
    }


    @Override
    public boolean hasCompetitions() {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(CompetitonsData.class)
                .count() > 0;
    }

    @Override
    public boolean hasLeague(String leagueId) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(LeagueTableData.class).equalTo(ID, leagueId).count() > 0;
    }

    @Override
    public boolean hasCup(String cupId) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(CupTableData.class).equalTo(ID, cupId).count() > 0;
    }
}
