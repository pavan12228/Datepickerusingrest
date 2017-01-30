package com.example.ravi.datecal.service;

import android.content.Context;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroHelper {
    private  final String BASEURL = "http://drapp.sciensdemos.in/index.php/";
    private static Context mContext;


    public static Retrofit getAdapter(Context ctx, String serverUrl) {
        mContext = ctx;
        Gson gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://drapp.sciensdemos.in/index.php/" + serverUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}