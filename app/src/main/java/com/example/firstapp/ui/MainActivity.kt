package com.example.firstapp.ui

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.firstapp.R

class MainActivity : AppCompatActivity() {

    //in the vid: 32:00, https://youtu.be/AdLGvc1gK_c?t=1917 (list & API)
    //next video https://www.youtube.com/watch?v=E9YCHZGm_-E&list=PLFXfdx9emMb7qN7NtU3oGqoErGIKqVZsH&index=3 (caching)
    //api token for time zone api: Q34EKL0CLLUJ
    //   |-> http://timezonedb.com/api
    //   '-> http://api.timezonedb.com/v2.1/list-time-zone?key=Q34EKL0CLLUJ&format=json


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}