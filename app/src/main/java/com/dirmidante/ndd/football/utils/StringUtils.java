package com.dirmidante.ndd.football.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import com.dirmidante.ndd.football.FootballApplication;

public final class StringUtils {

    private static Context sContext = FootballApplication.getCurrentApplicationContext();

    private StringUtils(){}

    public static String getString(@StringRes int resId){
        return sContext.getString(resId);
    }

    public static String getString(@StringRes int resId, Object... formatArgs){
        return sContext.getString(resId, formatArgs);
    }
}
