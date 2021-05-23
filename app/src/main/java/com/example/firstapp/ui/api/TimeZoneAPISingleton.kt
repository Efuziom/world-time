package com.example.firstapp.ui.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TimeZoneAPISingleton {
    companion object{
        val okhttpClient: OkHttpClient= OkHttpClient().newBuilder()
                .build();

        val timeZoneAPI: TimeZoneAPI= Retrofit.Builder()
                .baseUrl("http://api.timezonedb.com/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(TimeZoneAPI::class.java);
    }
}