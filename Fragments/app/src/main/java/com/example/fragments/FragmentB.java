package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class FragmentB extends Fragment {


    public FragmentB() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_b, container, false);
        Button dynamicbtn = view.findViewById(R.id.dynamicBtn);
        dynamicbtn.setOnClickListener(v ->{
            Intent nextIntent = new Intent(view.getContext(),Dynamic.class);
            startActivity(nextIntent);
        });


        return view;
    }
}