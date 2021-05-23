package com.example.firstapp.ui.list

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.ui.api.TimeZoneAPIResponse
import com.example.firstapp.ui.api.TimeZoneAPISingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TimeZoneListFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView;
    private val adapter= TimeZoneAdapter(listOf(), ::onClickTimeZone);
    private val layoutManager= LinearLayoutManager(context);

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timezone_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        this.recyclerView = view.findViewById<RecyclerView>(R.id.pokemon_recyclerview);              //init (as told by the attribute "lateinit")

        this.recyclerView.apply {
            this.layoutManager = this@TimeZoneListFragment.layoutManager;
            this.adapter = this@TimeZoneListFragment.adapter;
        }

        getListFromAPI()
    }

    private fun getListFromAPI(){
        TimeZoneAPISingleton.timeZoneAPI.getTimeZoneList().enqueue(object : Callback<TimeZoneAPIResponse> {
            override fun onResponse(call: Call<TimeZoneAPIResponse>, response: Response<TimeZoneAPIResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val timeZoneAPIResponse: TimeZoneAPIResponse = response.body()!!;
                    adapter.updateList(timeZoneAPIResponse.zones);
                }
            }

            override fun onFailure(call: Call<TimeZoneAPIResponse>, t: Throwable) {
                println("API Error: " + t.message);
                //TODO("Not yet implemented")
            }
        });
    }

    private fun onClickTimeZone(timeZone:TimeZone){
        findNavController().navigate(R.id.navToTimeZoneDetails, bundleOf(
                "timezoneCountryName" to timeZone.countryName,
                "timezoneCountryCode" to timeZone.countryCode,
                "timezoneName" to timeZone.zoneName,
                "timezoneTime" to timeZone.timestamp.toString()
        ));
    }
}