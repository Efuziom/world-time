package com.example.firstapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R

class TimeZoneAdapter(
        private var dataSet: List<TimeZone>,
        var listener: ((TimeZone)-> Unit)?= null): RecyclerView.Adapter<TimeZoneAdapter.ViewHolder>()
    {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView;
        init{
           textView = view.findViewById(R.id.timezone_name);
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder{
        val view= LayoutInflater.from(viewGroup.context).inflate(R.layout.timezone_item, viewGroup, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
        val timeZone:TimeZone= dataSet[position];
        viewHolder.textView.text= timeZone.zoneName;
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(timeZone);
        }
    }

    override fun getItemCount()= dataSet.size;

    fun updateList(list: List<TimeZone>){
        dataSet= list;
        notifyDataSetChanged();
    }
}