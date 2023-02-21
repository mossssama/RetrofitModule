package com.example.retrofitmodule.API;

import static com.example.retrofitmodule.API.Api.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* Single Retrofit instance because Retrofit consumes large resources */
public class SingletonRetrofitClient {
    public static SingletonRetrofitClient instance =null;
    private Api api;

    /* Retrofit instance to send requests to Api */

    /*[1] No RXJava with Retrofit */
    private SingletonRetrofitClient(){
        Retrofit retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        api=retrofit.create(Api.class);
    }

//    /*[2] RXJava with Retrofit */
//    private SingletonRetrofitClient(){
//        Retrofit retrofit= new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
//        api=retrofit.create(Api.class);
//    }


    public static synchronized SingletonRetrofitClient getInstance(){
        if(instance==null){ instance=new SingletonRetrofitClient(); }
        return instance;
    }

    public Api getApi(){
        return api;
    }
}
