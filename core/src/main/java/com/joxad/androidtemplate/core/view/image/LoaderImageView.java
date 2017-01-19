package com.joxad.androidtemplate.core.view.image;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.joxad.androidtemplate.core.R;


/**
 * Created by Jocelyn on 21/11/2016.
 */

public class LoaderImageView extends RelativeLayout {


    public ImageView imageView;
    public ProgressBar progressBar;

    public LoaderImageView(Context context) {
        this(context, null, 0);
    }

    public LoaderImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoaderImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.image_progress, this);
        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar) findViewById(R.id.progress);
    }


}
