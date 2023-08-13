package com.example.deathnote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AboutFragment extends Fragment {
    MainActivity mainActivity;
    Button but10;

    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_about, container, false);

        but10 = view.findViewById(R.id.button10);
        mainActivity=(MainActivity)getActivity();
        but10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pac10 = new Intent(getActivity(),RecycleActivity.class);
                startActivity(pac10);
            }
        });

        return view;
    }
}