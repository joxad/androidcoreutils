package com.joxad.androidtemplate.core.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;

import com.joxad.androidtemplate.core.android.AndroidUtils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;


/**
 * Created by Jocelyn on 24/08/2017.
 */

public enum NetworkStatusManager {
    INSTANCE;

    INetworkInfomation iNetworkInfomation;
    static PublishSubject<Boolean> connected;
    private NetworkReceiver networkReceiver;
    private CustomNetworkCallback networkCallback;
    private ConnectivityManager connectivityManager;
    private Context context;


    public static Observable<Boolean> networkStatusObservable() {
        return connected;
    }

    @SuppressLint("MissingPermission")
    public void register(final Context context) {
        this.context = context;
        connected = PublishSubject.create();
        iNetworkInfomation = new INetworkInfomation() {
            @Override
            public void onNetworkValid(boolean valid) {
                connected.onNext(valid);
            }
        };
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            networkCallback = new CustomNetworkCallback(connectivityManager, iNetworkInfomation);
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } else {
            networkReceiver = new NetworkReceiver(connectivityManager, iNetworkInfomation);
            context.registerReceiver(networkReceiver, new IntentFilter(
                    ConnectivityManager.CONNECTIVITY_ACTION));
        }

    }

    public void unregister() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } else {
            context.unregisterReceiver(networkReceiver);
        }
    }


    public boolean hasGoodConnection() {
        return AndroidUtils.getQualityConnection(connectivityManager) != AndroidUtils.QualityConnection.BAD_CONNECTION;
    }
}
