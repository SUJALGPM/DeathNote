package com.example.deathnote;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AddCourseFragment extends Fragment {
    MainActivity mainActivity;
    Button but6;

    public AddCourseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_course, container, false);

        but6 = view.findViewById(R.id.button6);
        mainActivity=(MainActivity)getActivity();
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pac7 = new Intent(getActivity(),RecycleActivity.class);
                startActivity(pac7);
            }
        });


        return view;
    }
}