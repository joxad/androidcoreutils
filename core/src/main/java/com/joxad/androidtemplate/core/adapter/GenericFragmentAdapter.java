package com.joxad.androidtemplate.core.adapter;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.joxad.androidtemplate.core.fragment.FragmentTab;

import java.util.List;


/**
 * {@link GenericFragmentAdapter} is an adapter for viewpager
 * Give it the list of fragmenttab with the tabTitles method.
 */
public abstract class GenericFragmentAdapter extends FragmentPagerAdapter {

    private final Resources resources;
    private final AppCompatActivity context;

    private List<FragmentTab> tabTitles;


    public GenericFragmentAdapter(final AppCompatActivity activity) {
        super(activity.getSupportFragmentManager());
        this.context = activity;
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
