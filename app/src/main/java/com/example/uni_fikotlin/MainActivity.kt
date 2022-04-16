package com.example.uni_fikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import com.example.uni_fikotlin.databinding.ActivityMainBinding
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity()
{

    private lateinit var binding : ActivityMainBinding

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

    }
    var imageListener = ImageListener {position, imageView -> imageView.setImageResource(imageArray[position]) }
}

