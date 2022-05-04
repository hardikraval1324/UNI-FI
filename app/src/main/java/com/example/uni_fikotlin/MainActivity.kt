package com.example.uni_fikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uni_fikotlin.databinding.ActivityMainBinding
import com.example.uni_fikotlin.models.event_listitems
import com.google.firebase.database.*
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity()
{

    private lateinit var binding : ActivityMainBinding

//
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userarraylist : ArrayList<event_listitems>
    //

    var textArray:ArrayList<Int> = ArrayList()

    var imageArray:ArrayList<Int> = ArrayList()
    var carouselView:CarouselView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageArray.add(R.drawable.a)
        imageArray.add(R.drawable.b)
        imageArray.add(R.drawable.c)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.event.setOnClickListener{
            startActivity(Intent(this, event::class.java))
        }
        binding.scan.setOnClickListener{
            startActivity(Intent(this, scan::class.java))
        }
        carouselView=findViewById(R.id.carouselView)
        carouselView!!.pageCount=imageArray.size
        carouselView!!.setImageListener(imageListener)


        supportActionBar?.hide()

//
//        userRecyclerview = findViewById(R.id.eventlist)
//        userRecyclerview.layoutManager = LinearLayoutManager(this)
//        userRecyclerview.setHasFixedSize(true)
//        userarraylist = arrayListOf<event_listitems>()
//        getEventData()
        //
    }
    //
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
    //
    var imageListener = ImageListener {position, imageView -> imageView.setImageResource(imageArray[position]) }
}

