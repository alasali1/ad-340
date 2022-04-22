package com.example.datingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView simpleImageView=(ImageView) findViewById(R.id.simpleImageView);
        simpleImageView.setImageResource(R.drawable.helloimage);
    }
}