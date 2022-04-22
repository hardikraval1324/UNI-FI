package com.example.uni_fikotlin.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.uni_fikotlin.databinding.ActivitySignupAspringBinding
import com.example.uni_fikotlin.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup_aspring : AppCompatActivity() {
    private lateinit var already_sigin : TextView
    private lateinit var create_account: Button
    private lateinit var binding: ActivitySignupAspringBinding
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivitySignupAspringBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val uid = firebaseAuth.currentUser?.uid
        binding.Signin.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        //making new user
        binding.createAccount.setOnClickListener{
            val name = binding.Name.text.toString()
            val phonenumber = binding.PhoneNum.text.toString()
            val email = binding.Email.text.toString()
            val password = binding.userPassword.text.toString()
            val confirpassword = binding.ConfirmPassword.text.toString()

            if(name.isNotEmpty()  && email.isNotEmpty() && password.isNotEmpty() && confirpassword.isNotEmpty()){
                if(password == confirpassword){
                    // adding data into realtime database using User model
                        val user = User(Name = name, Number = phonenumber , Email = email , Password = password)

                    if(uid !=null){
                        databaseReference.child(uid).setValue(user).addOnCompleteListener{
                            if(it.isSuccessful){
                                binding.Name.text?.clear()
                                 binding.PhoneNum.text?.clear()
                                binding.Email.text?.clear()
                                binding.userPassword.text?.clear()
                                Toast.makeText(this, "Successfully updated profile", Toast.LENGTH_SHORT).show()

                            }
                            else{
                                Toast.makeText(this, "Fail to update profile", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    // creating User using email and password
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){

                            startActivity(Intent(this, login::class.java))
                        }
                        else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                }
                else{
                    Toast.makeText(this, "Passowrd not matched", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()

            }

        }
    }
}