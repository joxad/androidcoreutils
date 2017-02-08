package com.joxad.androidtemplate.core.view.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Jocelyn on 27/10/2016.
 */

public class MaterialUtils {

    public static void setStatusBarColor(Activity activity, @ColorRes int statusBarColor) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = ContextCompat.getColor(activity, statusBarColor);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    public static void setSvgColor(Context context, @DrawableRes int idDrawable, @ColorRes int idColor) {
        Drawable drawable = ContextCompat.getDrawable(context, idDrawable);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, ContextCompat.getColor(context,idColor));
    }
}
