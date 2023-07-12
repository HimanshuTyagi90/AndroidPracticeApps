package com.example.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Dynamic extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        loadFrag(new FragmentC(),false);
        Button btnFragA = findViewById(R.id.DynamicFragA);
        Button btnFragB = findViewById(R.id.DynamicFragB);


        btnFragA.setOnClickListener(v -> loadFrag(new FragmentC(),true));


        btnFragB.setOnClickListener(v -> loadFrag(new FragmentD(),true));
    }


    private void loadFrag(Fragment fragment, Boolean replace){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (!replace){
            ft.add(R.id.container, fragment);
            ft.commit();
        }else {
            ft.replace(R.id.container, fragment);
            ft.commit();

        }
    }
}