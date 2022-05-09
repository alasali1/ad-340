package com.example.datingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
TextView welcome;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        welcome = findViewById(R.id.welcome);
        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get bundle
        Bundle bundle = getIntent().getExtras();
        String stringDate = bundle.getString("date");
        String stringName = bundle.getString("name");
        String stringEmail = bundle.getString("email");
        String stringUserName = bundle.getString("userName");

        //set username in welcome message.
        welcome.setText("Welcome " + stringUserName);
    }

}
