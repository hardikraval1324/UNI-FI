package com.example.unifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = findViewById(R.id.signup);
        if (getSupportActionBar() != null) { //remove action bar
            getSupportActionBar().hide();
        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(login.this , signUP_Cat.class);
                startActivity(i);
            }
        });
    }
}