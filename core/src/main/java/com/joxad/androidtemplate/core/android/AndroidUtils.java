package com.joxad.androidtemplate.core.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;

import java.util.Locale;

/**
 * Created by Jocelyn on 02/12/2016.
 */

public class AndroidUtils {

    public static String getApkName(Context context) {
        String packageName = context.getPackageName();
        PackageManager pm = context.getPackageManager();
        try {
            ApplicationInfo ai = pm.getApplicationInfo(packageName, 0);
            String[] apk = ai.publicSourceDir.split("/");
            return apk[apk.length - 1];
        } catch (Throwable x) {
        }
        return null;
    }


    /**
     * @param inputMethodManager
     * @param windowToken        null to hide
     */
    public static void updateKeyboard(InputMethodManager inputMethodManager, @Nullable IBinder windowToken, boolean show) {
        if (show)
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        else
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);

    }

    @Nullable
    public static String getStringFromName(Context context, String value) {
        int resourceId = context.getResources().
                getIdentifier(value, "string", context.getPackageName());
        try {
            return context.getString(resourceId);
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }
/*
    public static <T> Set<T> intersection(List<T>... list) {
        Set<T> result = Sets.newHashSet(list[0]);
        for (List<T> numbers : list) {
            result = Sets.intersection(result, Sets.newHashSet(numbers));
        }
        return result;
    }

    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }
*/
    public static void updateLocale(Context context, String language, String country) {
        Locale locale = new Locale(language,country);
        Locale.setDefault(locale);

        Resources resources = context.getResources();

        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    @TargetApi(Build.VERSION_CODES.N)
    public static Locale getCurrentLocale(Context ctx){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return ctx.getResources().getConfiguration().getLocales().get(0);
        } else{
            //noinspection deprecation
            return ctx.getResources().getConfiguration().locale;
        }
    }

    /**
     * Return the type of quality connection
     */
    public static QualityConnection getQualityConnection(ConnectivityManager connectivityManager) {
        @SuppressLint("MissingPermission") final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return QualityConnection.BAD_CONNECTION;
        } else {
            int type = networkInfo.getType();
            int subType = networkInfo.getSubtype();
            switch (type) {
                case ConnectivityManager.TYPE_WIFI:
                    return QualityConnection.WIFI_CONNECTION;
                default:
                    switch (subType) {
                        //EDGE, 2G
                        case TelephonyManager.NETWORK_TYPE_EDGE:
                        case TelephonyManager.NETWORK_TYPE_GPRS:
                        case TelephonyManager.NETWORK_TYPE_CDMA:
                        case TelephonyManager.NETWORK_TYPE_1xRTT:
                        case TelephonyManager.NETWORK_TYPE_IDEN:
                            return QualityConnection.BAD_CONNECTION;

                        //3G, 3.5G
                        case TelephonyManager.NETWORK_TYPE_HSPAP:
                        case TelephonyManager.NETWORK_TYPE_HSDPA:
                        case TelephonyManager.NETWORK_TYPE_EHRPD:
                        case TelephonyManager.NETWORK_TYPE_UMTS:
                        case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        case TelephonyManager.NETWORK_TYPE_HSUPA:
                        case TelephonyManager.NETWORK_TYPE_HSPA:
                        case TelephonyManager.NETWORK_TYPE_EVDO_B:
                            return QualityConnection.MODERATE_CONNECTION;

                        //4G
                        case TelephonyManager.NETWORK_TYPE_LTE:
                            return QualityConnection.GOOD_CONNECTION;

                        //UNKNOWN
                        default:
                            return QualityConnection.UNKNOWN_CONNECTION;
                    }
            }
        }
    }
    /**
     * Private enum to characterize connection
     */
    public enum QualityConnection {
        WIFI_CONNECTION,
        BAD_CONNECTION, //EDGE, 2G
        MODERATE_CONNECTION, //3G, 3.5G
        GOOD_CONNECTION,//4G
        UNKNOWN_CONNECTION
    }
}
