package com.example.firstapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.firstapp.R
import com.example.firstapp.ui.list.TimeZone
import com.example.firstapp.ui.utils.TimeUtil.fromEpochToString

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class TimeZoneDetailFragment : Fragment() {

    private lateinit var textViewTimeZoneCountryName: TextView;
    private lateinit var textViewTimeZoneCountryCode: TextView;
    private lateinit var textViewTimeZoneName: TextView;
    private lateinit var textViewTimeZoneTime: TextView;

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timezone_detail, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById<Button>(R.id.button_back_to_list).setOnClickListener {
            findNavController().navigate(R.id.navToTimeZoneList);
        }

        val countryName:String? = arguments?.getString("timezoneCountryName");
        val countryCode:String? = arguments?.getString("timezoneCountryCode");
        val name:String? = arguments?.getString("timezoneName");
        val time:Long? = arguments?.getString("timezoneTime")?.toLongOrNull();

        this.textViewTimeZoneCountryName= view.findViewById(R.id.textview_timezone_countryname);
        this.textViewTimeZoneCountryCode= view.findViewById(R.id.textview_timezone_countrycode);
        this.textViewTimeZoneName= view.findViewById(R.id.textview_timezone_name);
        this.textViewTimeZoneTime= view.findViewById(R.id.textview_timezone_time);

        this.textViewTimeZoneCountryName.setText("country name: "+countryName);
        this.textViewTimeZoneCountryCode.setText("ISO3 A2 code: "+countryCode);
        this.textViewTimeZoneName.setText("TZ name: "+name);
        this.textViewTimeZoneTime.setText(fromEpochToString(time)); //FIXME should send fromEpochToString(currTime( of etc0 ) + time) instead to have it mostly up to date
    }
}