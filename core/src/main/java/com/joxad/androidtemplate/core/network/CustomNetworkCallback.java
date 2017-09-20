package com.joxad.androidtemplate.core.network;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by Jocelyn on 24/08/2017.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class CustomNetworkCallback extends ConnectivityManager.NetworkCallback {
    private final INetworkInfomation networkInfomation;
    int MIN_BANDWIDTH_KBPS = 320;

    public CustomNetworkCallback( INetworkInfomation networkInfomation) {
        this.networkInfomation = networkInfomation;
    }

    @Override
    public void onAvailable(Network network) {
        super.onAvailable(network);

    }

    @Override
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        int bandwidth = networkCapabilities.getLinkDownstreamBandwidthKbps();
        networkInfomation.onNetworkValid(bandwidth < MIN_BANDWIDTH_KBPS);
    }


    @Override
    public void onLost(Network network) {
        networkInfomation.onNetworkValid(false);

    }

}
