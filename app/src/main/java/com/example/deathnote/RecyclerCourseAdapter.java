package com.example.deathnote;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCourseAdapter extends RecyclerView.Adapter<RecyclerCourseAdapter.ViewHolder> {

    Context context;
    ArrayList<CourseModel> arrmodel;

    RecyclerCourseAdapter(Context context, ArrayList<CourseModel> arrmodel){
        this.context=context;
        this.arrmodel=arrmodel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.course_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imgCourse.setImageResource(arrmodel.get(position).img);
        holder.title.setText(arrmodel.get(position).title);
        holder.description.setText(arrmodel.get(position).description);

        //UPDATE KARNE KE LIYA.
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dailog_laytout);

                EditText edititle = dialog.findViewById(R.id.editTitle);
                EditText editdescription = dialog.findViewById(R.id.editDescription);
                Button Actbut = dialog.findViewById(R.id.btnAction);
                TextView txt = dialog.findViewById(R.id.dailog_title);

                Actbut.setText("Update");
                txt.setText("Update Course");

                edititle.setText(arrmodel.get(position).title);
                editdescription.setText(arrmodel.get(position).description);

                Actbut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String title = "",des = "";
                        if(!edititle.getText().toString().equals("")){
                            title = edititle.getText().toString();
                        }else{
                            Toast.makeText(context, "Enter Course Title.", Toast.LENGTH_SHORT).show();
                        }
                        if(!editdescription.getText().toString().equals("")){
                            des = editdescription.getText().toString();
                        }else{
                            Toast.makeText(context, "Enter Course Description.", Toast.LENGTH_SHORT).show();
                        }

                        arrmodel.set(position,new CourseModel(arrmodel.get(position).img,title,des));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                        dialog.show();
            }
        });

        //DELETE KARN KE LIYA....
        holder.row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Course")
                        .setMessage("Are you sure want to delete.")
                        .setIcon(R.drawable.del)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrmodel.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrmodel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,description;
        ImageView imgCourse;
        LinearLayout row;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            imgCourse  = itemView.findViewById(R.id.image1);
            row = itemView.findViewById(R.id.row);
        }
    }
}
