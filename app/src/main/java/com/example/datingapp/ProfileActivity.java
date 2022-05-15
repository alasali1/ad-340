package com.example.datingapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
TextView welcome;
TextView name;
TextView age;
TextView description;
TextView occupation;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        welcome = findViewById(R.id.welcome);
        name = findViewById(R.id.user_name);
        age = findViewById(R.id.age);
        description = findViewById(R.id.description);
        occupation = findViewById(R.id.occupation);
        //back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get bundle
        Bundle bundle = getIntent().getExtras();
        String stringDate = bundle.getString("date");
        String stringName = bundle.getString("name");
        String stringEmail = bundle.getString("email");
        String stringUserName = bundle.getString("userName");
        String stringDescription = bundle.getString("description");
        String stringOccupation = bundle.getString("occupation");
        int userAge = bundle.getInt("age");

        //set username in welcome message.
        welcome.setText("Welcome " + stringUserName);

        //set username, age, description, and job into the profile fields
        name.append(stringUserName);
        age.append(String.valueOf(userAge));
        description.append(stringDescription);
        occupation.append(stringOccupation);
    }

}
