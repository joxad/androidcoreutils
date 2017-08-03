package com.joxad.androidtemplate.core.log;

import android.util.Log;

/**
 * Created by Jocelyn on 30/07/2017.
 */

public enum AppLog {
    INSTANCE;

    private String baseLog;

    public void init(String baseLog) {
        this.baseLog = baseLog;
    }

    public void d(String channel, String message) {
        Log.d(baseLog,channel + message);
    }
    public void e(String channel, String message) {
        Log.e(baseLog,channel + message);
    }
}
