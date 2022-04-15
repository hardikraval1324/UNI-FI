package com.example.uni_fikotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.uni_fikotlin.databinding.ActivityLoginBinding
import com.example.uni_fikotlin.databinding.ActivitySignupAspringBinding
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class signup_aspring : AppCompatActivity() {
    private lateinit var already_sigin : TextView
    private lateinit var create_account: Button
    private lateinit var binding: ActivitySignupAspringBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivitySignupAspringBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Signin.setOnClickListener {
            startActivity(Intent(this, login::class.java))
        }
        binding.createAccount.setOnClickListener{
            val name = binding.Name.text.toString()
            val phonenumber = binding.PhoneNum.text.toString()
            val email = binding.Email.text.toString()
            val password = binding.userPassword.text.toString()
            val confirpassword = binding.ConfirmPassword.text.toString()

            if(name.isNotEmpty() && phonenumber.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirpassword.isNotEmpty()){
                if(password == confirpassword){

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful){
                            startActivity(Intent(this,login::class.java))
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