package com.example.uni_fikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class signup_cat : AppCompatActivity() {
    private lateinit var signup_aspring: Button
    private lateinit var signupExisting: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_cat)
        signup_aspring = findViewById(R.id.aspring)
        signupExisting = findViewById(R.id.existing)

        signup_aspring.setOnClickListener {

            startActivity(Intent(this, com.example.uni_fikotlin.signup_aspring::class.java))
        }
    }
}