package com.example.firstapp.ui.api

import retrofit2.Call
import retrofit2.http.GET

interface TimeZoneAPI {
    @GET("list-time-zone?key=Q34EKL0CLLUJ&format=json")
    fun getTimeZoneList(): Call<TimeZoneAPIResponse>;
}