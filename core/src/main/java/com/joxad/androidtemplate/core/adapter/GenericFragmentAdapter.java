package com.joxad.androidtemplate.core.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.joxad.androidtemplate.core.fragment.FragmentTab;

import java.util.List;


/**
 * Created by Jocelyn on 09/01/2017.
 */

public abstract class GenericFragmentAdapter extends FragmentPagerAdapter {

    private final Resources resources;
    private final Context context;

    private List<FragmentTab> tabTitles;


    /**
     * Create pager adapter
     *
     * @param context
     * @param fm
     */
    public GenericFragmentAdapter(final Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.resources = context.getResources();
        this.tabTitles = tabTitles();
    }

    @Override
    public Fragment getItem(int position) {
        return tabTitles.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        return tabTitles.get(position).getTitle();
    }


    public abstract List<FragmentTab> tabTitles() ;
}
