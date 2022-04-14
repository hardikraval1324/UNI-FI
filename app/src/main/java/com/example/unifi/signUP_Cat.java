package com.example.unifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signUP_Cat extends AppCompatActivity {
    private Button aspring,existing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_cat);
        aspring = findViewById(R.id.aspring);
        existing = findViewById(R.id.existing);

        aspring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signUP_Cat.this , signup.class);
                startActivity(i);
            }
        });
        existing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(signUP_Cat.this , signup_existing.class);
                startActivity(i);
            }
        });
    }
}