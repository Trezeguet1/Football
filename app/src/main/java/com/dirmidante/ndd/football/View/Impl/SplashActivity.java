package com.dirmidante.ndd.football.View.Impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dima on 2016-12-17.
 */

public class SplashActivity extends AppCompatActivity {

    public static final int DELAY = 1000;

    private static Handler sHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sHandler.postDelayed(() -> navigate(), DELAY);
    }

    private void navigate() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
