package com.example.deathnote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ViewFragment extends Fragment {
    MainActivity mainActivity;
    Button but8;

    public ViewFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view, container, false);

        but8 = view.findViewById(R.id.button8);
        mainActivity=(MainActivity)getActivity();
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pac9 = new Intent(getActivity(),RecycleActivity.class);
                startActivity(pac9);
            }
        });

        return view;
    }
}