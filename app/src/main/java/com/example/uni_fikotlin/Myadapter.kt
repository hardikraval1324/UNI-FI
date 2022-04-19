package com.example.uni_fikotlin

import android.app.usage.UsageEvents
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Myadapter(private val eventlist : ArrayList<event_listitems>) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eventlist,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem  = eventlist[position]
        holder.Event.text=currentitem.Event
    }

    override fun getItemCount(): Int {
       return eventlist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val Event : TextView = itemView.findViewById(R.id.event)

    }
}

