package com.joxad.androidtemplate.core.ws;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by josh on 11/04/16.
 */
public class RetrofitBase {

    private Retrofit retrofit;

    public RetrofitBase(String url) {
        this(url, null);
    }

    public RetrofitBase(String url, @Nullable Interceptor interceptor) {
        this(url, null, null);
    }

    public RetrofitBase(String url, @Nullable Interceptor interceptor, Gson gson) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);
        if (interceptor != null)
            builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(gson == null ? GsonConverterFactory.create() : GsonConverterFactory.create(gson))
                .client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit retrofit() {
        return retrofit;
    }

    public <T> T create(final Class<T> service) {
        return retrofit().create(service);
    }

}
