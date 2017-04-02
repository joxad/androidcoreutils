package com.joxad.androidtemplate.core.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Callable;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jocelyn on 01/04/2017.
 */

public class BitmapUtils {


    public static Observable<String> getB64(Context context, final String path) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                byte fileContent[] = new byte[3000];
                String encImage = "";
                try (FileInputStream fin = new FileInputStream(path)) {
                    while (fin.read(fileContent) >= 0) {
                        encImage += Base64.encodeToString(fileContent, Base64.DEFAULT);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return encImage.replaceAll("\n", "");
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }

    public static Observable<String> getB64Bitmap(final Context context, final Uri path) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(path));
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
                byte[] image = stream.toByteArray();
                String encodedImage = Base64.encodeToString(image, Base64.DEFAULT);
                return encodedImage.replaceAll("\n", "");
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }
}
