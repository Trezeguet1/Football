package com.dirmidante.ndd.football.Presenter.Impl;

import android.util.Log;

import com.dirmidante.ndd.football.Model.Entity.CompetitonsData.CompetitonsData;
import com.dirmidante.ndd.football.Model.Impl.FootballDataAPI;
import com.dirmidante.ndd.football.Presenter.IMainPresenter;
import com.dirmidante.ndd.football.View.MainView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Dima on 2016-12-17.
 */

public class MainPresenter implements IMainPresenter {

    private MainView view;
    private FootballDataAPI footballDataAPI;

    public MainPresenter(MainView view, FootballDataAPI footballDataAPI) {
        this.view = view;
        this.footballDataAPI = footballDataAPI;
    }

    @Override
    public void getCompetitions() {

        Observable<List<CompetitonsData>> competitionsDataObservable = footballDataAPI.getCompetitons();
        competitionsDataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(competitonsData -> {
                    List<CompetitonsData> competitonsList = new ArrayList<>();
                    competitonsList.addAll(competitonsData);
                    view.setCompetitionsListData(competitonsList);
                });
    }
}
