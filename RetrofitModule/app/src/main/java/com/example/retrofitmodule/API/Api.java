package com.example.retrofitmodule.API;

import com.example.retrofitmodule.POJO.Verse;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* Interface to defines requests & their EndPoints*/
/* It manage Api usage*/
public interface Api {

    String BASE_URL="https://api.alquran.cloud/v1/ayah/"; /* BaseURL used in every Api request */


   /* GET request where i/p paramater will be added to BASE_URL */

    /*[1] No RXJava with Retrofit */
    @GET("{verseNumber}")
    Call<Verse> getVerse(@Path("verseNumber") int verseNumber);

//    /*[2] RXJava with Retrofit */
//    @GET("{verseNumber}")
//    Observable<Verse> getVerse(@Path("verseNumber") int verseNumber);

}
