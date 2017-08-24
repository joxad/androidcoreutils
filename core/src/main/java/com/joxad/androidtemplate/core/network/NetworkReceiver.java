package com.joxad.androidtemplate.core.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.joxad.androidtemplate.core.android.AndroidUtils;


/**
 * Created by Jocelyn on 12/04/2017.
 */
public class NetworkReceiver extends BroadcastReceiver {

    INetworkInfomation listener;
    ConnectivityManager connectivityManager;

    public NetworkReceiver(ConnectivityManager con, INetworkInfomation listener) {
        this.connectivityManager = con;
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.onNetworkValid(AndroidUtils.getQualityConnection(connectivityManager) !=
                AndroidUtils.QualityConnection.BAD_CONNECTION);
    }
}
