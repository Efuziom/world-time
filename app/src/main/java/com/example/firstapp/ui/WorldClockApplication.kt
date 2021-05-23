package com.example.firstapp.ui

import android.app.Application
import android.content.Context

class WorldClockApplication: Application() {
    companion object{
        var context: Context?= null;
    }

    override fun onCreate(){
        super.onCreate();
        context= this;
    }
}