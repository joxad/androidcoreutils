package com.joxad.androidtemplate.core.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Jocelyn on 16/01/2017.
 * This class is to be used alongside the adapter fragment (for a viewpager)
 */
public class FragmentTab {
    private final String title;
    private final Fragment fragment;

    public FragmentTab(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
