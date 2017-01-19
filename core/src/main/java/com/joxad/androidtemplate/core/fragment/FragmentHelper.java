package com.joxad.androidtemplate.core.fragment;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.joxad.androidtemplate.core.R;


/**
 * Created by josh on 24/08/16.
 */
public class FragmentHelper {


    public static void replaceFragmentNoAnim(FragmentManager fragmentManager, Fragment fragment, @IdRes int id, boolean clearBackstack, boolean withBackstack) {
        updateFragment(false, fragmentManager, fragment, id, clearBackstack, withBackstack, false);
    }

    public static void replaceFragment(FragmentManager fragmentManager, Fragment fragment, @IdRes int id, boolean clearBackstack, boolean withBackstack) {
        updateFragment(false, fragmentManager, fragment, id, clearBackstack, withBackstack, true);
    }

    /***
     * @param fragment
     * @param clearBackStack
     * @param withBackstack
     */
    public static void addFragment(FragmentManager fragmentManager, Fragment fragment, @IdRes int id,
                                   boolean clearBackStack, boolean withBackstack) {
        updateFragment(true, fragmentManager, fragment, id, clearBackStack, withBackstack, true);
    }


    /***
     * @param fragmentName
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Fragment fragmentByName(String fragmentName) throws IllegalAccessException, InstantiationException {
        Class<?> className = null;
        try {
            className = Class.forName(fragmentName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Fragment) className.newInstance();
    }

    /***
     * @param fragment
     * @param clearBackStack
     * @param withBackstack
     */
    private static void updateFragment(boolean add, FragmentManager fragmentManager, Fragment fragment, @IdRes int id,
                                       boolean clearBackStack, boolean withBackstack, boolean withAnim) {

        // Clear the back stack if needed
        if (clearBackStack) {
            while (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStackImmediate();
            }
        }
        // Set up the transaction
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (withAnim)
            transaction.setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        if (add)
            transaction.add(id, fragment, fragment.getClass().getSimpleName());
        else
            transaction.replace(id, fragment, fragment.getClass().getSimpleName());
        // Add the new fragment to back stack if needed
        if (withBackstack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }

        // Commit transaction
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction = fragmentManager.beginTransaction();
            transaction.replace(id, fragment);
            transaction.commitAllowingStateLoss();
        }
    }


}
