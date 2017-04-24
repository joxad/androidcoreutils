package com.joxad.androidtemplate.core.fragment;

import android.support.v4.app.Fragment;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Jocelyn on 16/01/2017.
 * This class is to be used alongside the adapter fragment (for a viewpager)
 */
@Data
@AllArgsConstructor(suppressConstructorProperties = true)
public class FragmentTab {
    private final String title;
    private final Fragment fragment;
}
