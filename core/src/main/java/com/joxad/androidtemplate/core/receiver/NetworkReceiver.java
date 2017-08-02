package com.joxad.androidtemplate.core.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created by Jocelyn on 12/04/2017.
 */
public class NetworkReceiver extends BroadcastReceiver {
    static BehaviorSubject<Boolean> connected = BehaviorSubject.create();


    public static Observable<Boolean> networkStatusObservable() {
        return connected;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager conn = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = conn.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        connected.onNext(isConnected);
    }
}