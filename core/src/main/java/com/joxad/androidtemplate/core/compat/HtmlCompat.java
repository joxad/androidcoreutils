package com.joxad.androidtemplate.core.compat;

import android.text.Html;
import android.text.Spanned;

/**
 * Created by Jocelyn on 30/01/2017.
 */

public class HtmlCompat {

    public static Spanned fromHtml(String htmlText) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(htmlText);
        }
    }
}
