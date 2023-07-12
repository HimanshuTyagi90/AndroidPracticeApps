package com.example.backgroundservice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button startBtn = findViewById(R.id.startBtn);
        Button stopBtn = findViewById(R.id.stopBtn);

        Intent serviceIntent = new Intent(MainActivity.this,musicService.class);
        startBtn.setOnClickListener(view -> startService(serviceIntent));

        stopBtn.setOnClickListener(view -> stopService(serviceIntent));
    }



}