package com.example.uni_fikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.firestore.auth.User

class event : AppCompatActivity() {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userarraylist : ArrayList<event_listitems>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        userRecyclerview = findViewById(R.id.event)
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
                    for (userSnapshot in snapshot.children){
                        val eventModel = userSnapshot.getValue(event_listitems::class.java)
                        userarraylist.add(eventModel!!)
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