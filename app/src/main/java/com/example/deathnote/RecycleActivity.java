package com.example.deathnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {
    RecyclerView cycle;
    ArrayList<CourseModel> arrayCourse = new ArrayList<>();
    FloatingActionButton floatbtn;
    RecyclerCourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        cycle = findViewById(R.id.RecycleView);
        floatbtn = findViewById(R.id.btnOpenDialog);

        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(RecycleActivity.this);
                dialog.setContentView(R.layout.dailog_laytout);

                EditText edititle = dialog.findViewById(R.id.editTitle);
                EditText editdescription = dialog.findViewById(R.id.editDescription);
                Button Actbut = dialog.findViewById(R.id.btnAction);

                Actbut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = "",des = "";
                        if(!edititle.getText().toString().equals("")){
                            title = edititle.getText().toString();
                        }else{
                            Toast.makeText(RecycleActivity.this, "Enter Course Title.", Toast.LENGTH_SHORT).show();
                        }
                        if(!editdescription.getText().toString().equals("")){
                            des = editdescription.getText().toString();
                        }else{
                            Toast.makeText(RecycleActivity.this, "Enter Course Description.", Toast.LENGTH_SHORT).show();
                        }

                        //add item in arraylist
                        arrayCourse.add(new CourseModel(R.drawable.course,title,des));

                        //using adpater class add item in arraylist at last position.
                        adapter.notifyItemChanged(arrayCourse.size()-1);

                        //after adding item automatic view scroll to at end position.
                        cycle.scrollToPosition(arrayCourse.size()-1);

                        //after performing operation dailog box will automatic close;
                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });

        cycle.setLayoutManager(new LinearLayoutManager(this));

        arrayCourse.add(new CourseModel(R.drawable.course,"Java Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"React.js Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"Spring Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"Angular Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"Node.js Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"software Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"Database Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"AWD Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"MAD Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"Accouting Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"E-Commerce Course","It's is free for begineers.."));
        arrayCourse.add(new CourseModel(R.drawable.course,"C++ Course","It's is free for begineers.."));

        adapter = new RecyclerCourseAdapter(this,arrayCourse);
        cycle.setAdapter(adapter);


    }
}