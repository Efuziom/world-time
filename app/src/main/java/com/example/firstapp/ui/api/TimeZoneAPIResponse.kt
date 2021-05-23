package com.example.firstapp.ui.api

import com.example.firstapp.ui.list.TimeZone

data class TimeZoneAPIResponse(
    val status: String,
    val zones: List<TimeZone>
);
