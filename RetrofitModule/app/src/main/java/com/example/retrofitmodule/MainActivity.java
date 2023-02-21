package com.example.retrofitmodule;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitmodule.API.SingletonRetrofitClient;
import com.example.retrofitmodule.POJO.Verse;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Sending request & reading response */

        /*[1] No RXJava with Retrofit*/
        Call<Verse> apiResponse = SingletonRetrofitClient.getInstance().getApi().getVerse(5);

        apiResponse.enqueue(new Callback<Verse>() {
            @Override
            public void onResponse(Call<Verse> call, Response<Verse> response) {
                Toast.makeText(MainActivity.this, response.body().getData().getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Verse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        /*[2] RXJava with Retrofit */
//        Observable apiResponse=SingletonRetrofitClient.getInstance().getApi().getVerse(5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//
//        Observer<Verse> observer=new Observer<Verse>() {
//            @Override
//            public void onSubscribe(Disposable d) {}
//
//            @Override
//            public void onNext(Verse verse) {
//                Toast.makeText(MainActivity.this, verse.getData().getText(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onComplete() {}
//        };
//
//        apiResponse.subscribe(observer);

    }
}