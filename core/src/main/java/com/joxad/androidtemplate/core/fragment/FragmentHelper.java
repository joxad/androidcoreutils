package com.joxad.androidtemplate.core.fragment;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by josh on 24/08/16.
 */
public class FragmentHelper {

    public static void replace(FragmentActivity activity, Fragment fragment, @IdRes int id) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .commit();
    }
}
