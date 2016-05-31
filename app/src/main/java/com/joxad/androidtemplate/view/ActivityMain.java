package com.joxad.androidtemplate.view;

import android.os.Bundle;

import com.joxad.androidtemplate.R;
import com.joxad.androidtemplate.databinding.ActivityMainBinding;
import com.joxad.androidtemplate.viewmodel.ActivityMainVM;
import com.joxad.easydatabinding.activity.ActivityBase;

/**
 * Created by josh on 31/05/16.
 */
public class ActivityMain extends ActivityBase<ActivityMainBinding, ActivityMainVM> {
    @Override
    public int data() {
        return 0;
    }

    @Override
    public int layoutResources() {
        return R.layout.activity_main;
    }

    @Override
    public ActivityMainVM baseActivityVM(ActivityMainBinding binding, Bundle savedInstanceState) {
        return new ActivityMainVM(this, binding);
    }
}
