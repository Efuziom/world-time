package com.example.firstapp.ui.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TimeZoneAPISingleton {
    companion object{
        val timeZoneAPI: TimeZoneAPI= Retrofit.Builder()
                .baseUrl("http://api.timezonedb.com/v2.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TimeZoneAPI::class.java);
    }
}