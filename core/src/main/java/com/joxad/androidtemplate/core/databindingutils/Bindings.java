package com.joxad.androidtemplate.core.databindingutils;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.graphics.Paint;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.joxad.androidtemplate.core.view.image.LoaderImageView;
import com.joxad.androidtemplate.core.view.list.FlingNestedScrollView;


/**
 * Created by josh on 26/03/16.
 */
public class Bindings {


    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {

        Glide.with(view.getContext()).load(imageUrl)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontTransform()
                .into(view);

    }


    /**
     * ViewGroup.FOCUS_BLOCK_DESCENDANTS
     *
     * @param nestedScrollView
     * @param descendant
     */
    @BindingAdapter("descendant")
    public static void setDescendant(FlingNestedScrollView nestedScrollView, int descendant) {
        nestedScrollView.setDescendantFocusability(descendant);

    }

    @BindingAdapter({"android:enabled"})
    public static void loadImage(ToggleButton view, boolean enable) {
        view.setEnabled(enable);
    }


    @BindingAdapter({"animateTranslation","translationY"})
    public static void translationY(final View view, final boolean show, final float translationY) {
        if (show & view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
            view.setY(translationY);
            view.animate().translationY(0).setDuration(400).start();
        } else if (!show && view.getVisibility() == View.VISIBLE) {
            view.animate().translationY(translationY).setDuration(400).withEndAction(new Runnable() {
                @Override
                public void run() {
                    view.setVisibility(View.GONE);
                }
            }).start();
        }


    }

    @BindingAdapter({"animateHideScale"})
    public static void animateHideScale(View view, boolean hide) {
        view.animate().scaleX(hide ? 0 : 1).scaleY(hide ? 0 : 1).setDuration(200).start();
    }

    @BindingAdapter({"strike"})
    public static void addStrike(TextView view, boolean b) {
        if (b)
            view.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @BindingAdapter({"nestedScrollingEnabled"})
    public static void nestedScroll(RecyclerView rv, boolean b) {
        rv.setNestedScrollingEnabled(b);
    }

    @BindingAdapter({"imageUrlLoader"})
    public static void loadImage(final LoaderImageView view, String imageUrl) {
        if (imageUrl == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
            Glide.with(view.getContext()).load(imageUrl)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .dontTransform().listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    view.progressBar.setVisibility(View.INVISIBLE);
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    view.progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).into(view.imageView);
        }
    }


    @BindingAdapter({"android:drawableTop"})
    public static void setDrawableTop(TextView view, int image) {
        view.setCompoundDrawablesWithIntrinsicBounds(0, image, 0, 0);
        
        /*
         Drawable img = ContextCompat.getDrawable(view.getContext(), image);
         view.setCompoundDrawables(null, img, null, null);*/
    }

    @BindingAdapter("android:layout_marginTop")
    public static void setTopMargin(View view, int topMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, topMargin,
                layoutParams.rightMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:layout_marginEnd")
    public static void setEndMargin(View view, float endMargin) {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin,
                (int) endMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:paddingTop")
    public static void setTopPadding(View view, int topMargin) {
        view.setPaddingRelative(view.getPaddingStart(), topMargin, view.getPaddingEnd(), view.getPaddingBottom());
    }

    @BindingAdapter("backgroundTint")
    public static void setBackgroundTint(Button button, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackgroundTintList(ColorStateList.valueOf(color));
        }
    }

}
