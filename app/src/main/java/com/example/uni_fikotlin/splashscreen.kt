package com.example.uni_fikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.uni_fikotlin.Auth.login
import com.google.firebase.auth.FirebaseAuth

class splashscreen : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mAuth = FirebaseAuth.getInstance()
        if(mAuth != null){
            startActivity(Intent(this, MainActivity::class.java))
            Log.i("hai log", mAuth.toString())
        }else{
            Log.e("no auth", mAuth.toString())
        }
        supportActionBar?.hide()
        setContentView(R.layout.activity_splashscreen)
        Handler().postDelayed({
            val i = Intent(
                this@splashscreen,
                login::class.java
            )
            //Intent is used to switch from one activity to another.
            startActivity(i)
            //invoke the SecondActivity.
            finish()
            //the current activity will get finished.
        },5000)

    }
}