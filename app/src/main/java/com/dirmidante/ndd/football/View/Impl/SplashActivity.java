package com.dirmidante.ndd.football.View.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.EActivity;

/**
 * Created by Dima on 2016-12-17.
 */

@EActivity
public class SplashActivity extends AppCompatActivity {

    public static final int DELAY_MILLIS = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed((() -> {
            CompetitionsListActivity_.intent(this).start();
        }), DELAY_MILLIS);
    }
}
