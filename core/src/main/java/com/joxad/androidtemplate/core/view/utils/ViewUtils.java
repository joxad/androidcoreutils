package com.joxad.androidtemplate.core.view.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.DisplayMetrics;
import android.widget.ImageView;

/**
 * Created by Jocelyn on 04/11/2016.
 */

public class ViewUtils {

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static float getCenterX(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        return width * 0.5f;
    }


    public static float getCenterY(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        return height * 0.5f;
    }

    public static void updateStarsColors(LayerDrawable stars, int colorOn, int colorOff) {
        stars.getDrawable(2).setColorFilter(colorOn, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(colorOff, PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(colorOn, PorterDuff.Mode.SRC_ATOP);
    }


    public static float getHeight(FragmentActivity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;

    }

    public static float getWidth(FragmentActivity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;

    }

    public static void changeColor(ImageView imageView, @ColorInt int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(imageView.getDrawable());
        DrawableCompat.setTint(wrappedDrawable, color);
        imageView.setImageDrawable(wrappedDrawable);
    }
}

