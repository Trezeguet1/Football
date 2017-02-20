package com.dirmidante.ndd.football.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dima on 2016-12-17.
 */

public class SplashActivity extends AppCompatActivity {


    public static final int DELAY_MILLIS = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed((() -> {
            Intent mainIntent = new Intent(SplashActivity.this, CompetitionsListActivity.class);
            SplashActivity.this.startActivity(mainIntent);
            SplashActivity.this.finish();
        }), DELAY_MILLIS);
    }
}
