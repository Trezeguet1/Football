package com.dirmidante.ndd.football.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import static com.dirmidante.ndd.football.FootballApplication.getCurrentApplicationContext;

/**
 * Created by Dima on 24.02.2017.
 */

public final class NetworkUtils {
    public static boolean networkAvailable(){
        ConnectivityManager connMgr = (ConnectivityManager)
                getCurrentApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
