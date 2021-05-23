package com.example.firstapp.ui.api

import com.example.firstapp.ui.WorldClockApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class TimeZoneAPISingleton {
    companion object{
        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10*1024*1024 /*10Mo*/);

        val okhttpClient: OkHttpClient= OkHttpClient().newBuilder()
                .cache(cache)
                .build();

        val timeZoneAPI: TimeZoneAPI= Retrofit.Builder()
                .baseUrl("http://api.timezonedb.com/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(TimeZoneAPI::class.java);
    }
}