package com.example.unifi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.PrimitiveIterator;

public class login extends AppCompatActivity {
    private TextView signup, email, password;
    private Button Login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = findViewById(R.id.signup);
        email = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Login = findViewById(R.id.btn_login);
        mAuth = FirebaseAuth.getInstance();
        if (getSupportActionBar() != null) { //remove action bar
            getSupportActionBar().hide();
        }
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this , signUP_Cat.class);
                startActivity(i);
            }
        });
    }
    private void loginUser(){
        //getting email and pass into string
        String Email  = email.getText().toString();
        String Password  = password.getText().toString();

        //if the text is empty then it will show error
        if(TextUtils.isEmpty(Email)){
            email.setError("Email cannot be empty");
            email.requestFocus();
        }
        else if(TextUtils.isEmpty(Password)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }
        else{
           mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(login.this , "User logged in Successfully", Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(login.this,MainActivity.class));
                  }
                  else {
                      Toast.makeText(login.this , "Login Error: " +task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                  }
               }
           });
        }
    }
}