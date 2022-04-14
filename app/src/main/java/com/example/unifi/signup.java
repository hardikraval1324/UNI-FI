package com.example.unifi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private Button createAccount;
    TextView signin;
    TextView name, Number, Email, password, confirmpass;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.Name);
        Number = findViewById(R.id.PhoneNum);
        Email = findViewById(R.id.Email);
        password  = findViewById(R.id.userPassword);
        confirmpass = findViewById(R.id.ConfirmPassword);
        createAccount = findViewById(R.id.createAccount);
        signin = findViewById(R.id.Signin);
        mAuth = FirebaseAuth.getInstance();
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating user Function
                createUser();
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup.this , login.class);
                startActivity(i);
            }
        });

    }

    private void createUser(){
        //getting email and pass into string
        String Name  = name.getText().toString();
        String phNumber = Number.getText().toString();
        String email  = Email.getText().toString();
        String Password  = password.getText().toString();
        String confirmPassword  = confirmpass.getText().toString();


        //if the text is empty then it will show error
        if(TextUtils.isEmpty(email)){
            Email.setError("Email cannot be empty");
            Email.requestFocus();
        }
        else if(TextUtils.isEmpty(Password)){
            password.setError("Password cannot be empty");
            password.requestFocus();
        }

        //if the text field is filled it will create user and show the toast
        else{
            mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(signup.this , "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this,login.class));
                    }
                    else{
                        Toast.makeText(signup.this , "Registration Error: " +task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            });
        }

    }
}