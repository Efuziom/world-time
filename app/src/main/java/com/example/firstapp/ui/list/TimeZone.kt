package com.example.firstapp.ui.list

import org.jetbrains.annotations.NotNull

data class TimeZone(
    val zoneName: String,
    val countryCode: String,
    val countryName: String,
    val timestamp: Int
);
