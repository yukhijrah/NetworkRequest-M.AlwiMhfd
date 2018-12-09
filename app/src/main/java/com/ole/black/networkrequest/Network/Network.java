package com.ole.black.networkrequest.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    public  static Retrofit request(){
        return new Retrofit.Builder().baseUrl("http://ti16-api.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
