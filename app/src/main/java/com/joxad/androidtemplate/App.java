package com.joxad.androidtemplate;

import android.app.Application;

import com.joxad.androidtemplate.core.notification.AppNotification;
import com.joxad.androidtemplate.utils.AppPrefs;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppPrefs.init(this);
        AppNotification.init(this);

    }

}
