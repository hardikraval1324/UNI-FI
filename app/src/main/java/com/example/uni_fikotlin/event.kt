package com.example.uni_fikotlin

import android.app.usage.UsageEvents
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uni_fikotlin.databinding.ActivitySignupAspringBinding
import com.example.uni_fikotlin.databinding.EventlistBinding
import com.example.uni_fikotlin.models.event_listitems
import com.google.firebase.database.*
import com.google.firebase.events.Event

class event : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userarraylist : ArrayList<event_listitems>
    private lateinit var binding: event
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        userRecyclerview = findViewById(R.id.eventlist)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)
        userarraylist = arrayListOf<event_listitems>()
        getEventData()
    }

    private fun getEventData() {
        dbref = FirebaseDatabase.getInstance().getReference("Events")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (userSnapshot in snapshot.children) {
                        Log.i("userSnapshot" , userSnapshot.toString())
                        userarraylist.add(event_listitems(Event =  userSnapshot.getValue().toString()))
                    }

                    userRecyclerview.adapter = Myadapter(userarraylist)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}