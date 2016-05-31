package com.joxad.androidtemplate;

import android.app.Application;
import android.content.Context;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.joxad.androidtemplate.core.notification.AppNotification;
import com.joxad.androidtemplate.core.utils.AppPrefs;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(new FlowConfig.Builder(this).build());
        AppPrefs.init(this);
        AppNotification.init(this);

    }

}
