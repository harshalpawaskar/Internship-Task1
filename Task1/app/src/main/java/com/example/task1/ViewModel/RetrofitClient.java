package com.example.task1.ViewModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance = null;
    private PhotosAPI myApi;

    private RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        myApi = retrofit.create(PhotosAPI.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public PhotosAPI getMyApi() {
        return myApi;
    }
}