package com.example.sys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {
    private ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final Intent newIntent = new Intent(this,MainActivity.class);
        layout = findViewById(R.id.m_login_button);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(newIntent);
                finish();
            }
        });


    }
}
