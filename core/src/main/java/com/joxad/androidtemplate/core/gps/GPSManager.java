package com.joxad.androidtemplate.core.gps;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by Jocelyn on 07/03/2017.
 */

public enum GPSManager {

    INSTANCE;
    private Application application;
    public BehaviorSubject<Boolean> gpsEnabled = BehaviorSubject.create();
    private boolean isSearching;

    public Observable<Boolean> gpsEnableObservable() {
        return gpsEnabled.asObservable();
    }

    public void init(Application application) {
        this.application = application;
    }


    public boolean isEnabled() {
        return isGpsActivated(application);
    }


    private boolean isGpsActivated(Context context) {
        int locationMode = 0;
        try {
            locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return locationMode != Settings.Secure.LOCATION_MODE_OFF;

    }

    public void searching(boolean b) {
        isSearching = b;
    }

    public boolean isSearching() {
        return isSearching;
    }
}
