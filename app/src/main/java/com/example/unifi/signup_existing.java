package com.example.unifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class signup_existing extends AppCompatActivity {
    private Button createAccount2;
    private TextView signin2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_existing);
        createAccount2 = findViewById(R.id.createAccount2);
        signin2 = findViewById(R.id.Signin2);
        createAccount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup_existing.this , login.class);
                startActivity(i);
            }
        });
        signin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signup_existing.this , login.class);
                startActivity(i);
            }
        });
    }
}