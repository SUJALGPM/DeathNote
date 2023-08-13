package com.example.deathnote;

public class CourseModel {
    int img;
    String title;
    String description;

    public CourseModel(int img,String title ,String description) {
        this.img = img;
        this.title=title;
        this.description=description;
    }

    public CourseModel(String title,String description){
        this.title=title;
        this.description=description;
    }
}
