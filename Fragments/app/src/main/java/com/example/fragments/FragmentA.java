package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentA extends Fragment {
    

    public FragmentA() {
        // Required empty public constructor
    }

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        TextView textView = view.findViewById(R.id.fragmentAtext);
        
        textView.setOnClickListener(v -> Toast.makeText(textView.getContext(), "clicked on fragment A", Toast.LENGTH_SHORT).show());
        return view;
    }
}