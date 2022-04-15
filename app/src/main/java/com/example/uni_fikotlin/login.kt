package com.example.uni_fikotlin

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.uni_fikotlin.databinding.ActivityLoginBinding
import com.example.uni_fikotlin.databinding.ActivitySignupAspringBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var user_mail:EditText
    private lateinit var user_password :EditText
    private lateinit var user_signup :TextView
    private lateinit var user_login :Button
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
       /* user_mail = findViewById(R.id.username)
        user_password = findViewById(R.id.password)
        user_signup = findViewById(R.id.signup)
        user_login = findViewById(R.id.btn_login)*/
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            val email = binding.username.text.toString()
            val password = binding.password.text.toString()

            if( email.isNotEmpty() && password.isNotEmpty() ){

                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            startActivity(Intent(this,MainActivity::class.java))
                        }
                        else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
            }
            else{
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()

            }


        }

        binding.signup.setOnClickListener{
            startActivity(Intent(applicationContext, signup_cat::class.java))
            Toast.makeText(this@login, "Sign up", Toast.LENGTH_SHORT).show()
        }



    }
}