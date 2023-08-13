package com.example.deathnote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ContactFragment extends Fragment {
    MainActivity mainActivity;
    Button but11;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contact, container, false);

        but11 = view.findViewById(R.id.button11);
        mainActivity=(MainActivity)getActivity();
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pac11 = new Intent(getActivity(),RecycleActivity.class);
                startActivity(pac11);
            }
        });

        return view;
    }
}