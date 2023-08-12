package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;

public class courseview extends AppCompatActivity {
    String htmlText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseview);
        ImageView courseimage  = findViewById(R.id.courseImage);
        Glide.with(this).load(coursedatabase.image_url.get(course.vlog_position)).into(courseimage);
        TextView coursename = findViewById(R.id.courseName);
        coursename.setText(coursedatabase.name.get(course.vlog_position));
        TextView CourseCategory = findViewById(R.id.CourseCategory);
        CourseCategory.setText(coursedatabase.typeofprograme.get(course.vlog_position));
   TextView courseRatings = findViewById(R.id.courseRatings);
        courseRatings.setText("Rating: "+coursedatabase.rating.get(course.vlog_position)+" stars");
        TextView duration = findViewById(R.id.duration);
        duration.setText(coursedatabase.duration.get(course.vlog_position));
        TextView price = findViewById(R.id.price);
        price.setText(coursedatabase.price_rendered.get(course.vlog_position));
        TextView CourseDescription = findViewById(R.id.CourseDescription);
        String a  = coursedatabase.content.get(course.vlog_position);
        int k = 0;
        for (int i = 0; i <a.length(); i++) {
            if(a.charAt(i) =='['){
                k =1;
                continue;
            }
            if(a.charAt(i) == ']'){
                k = 0;
                continue;
            }
            if(k == 0){
                htmlText = htmlText + a.charAt(i);
            }
        }

        CourseDescription.setText(Html.fromHtml(htmlText));
        MaterialButton enroll  = findViewById(R.id.enroll);

        enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!coursedatabase.price_rendered.get(course.vlog_position).equals("Free")){
                    startActivity(new Intent(courseview.this , payment.class));
                }
                else {
                    Toast.makeText(courseview.this, "Course Enrolled", Toast.LENGTH_SHORT).show();
                }
            }
        });
        FrameLayout des = findViewById(R.id.des);
        LinearLayout cer = findViewById(R.id.cer);

        Button btnDescription = findViewById(R.id.btnDescription);
        Button btnCurriculum = findViewById(R.id.btnCurriculum);
        Button btnCertificate = findViewById(R.id.btnCertificate);
        Button btnReviews = findViewById(R.id.btnReviews);
        btnDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseDescription.setText(Html.fromHtml(htmlText));

                des.setVisibility(View.VISIBLE);
                cer.setVisibility(View.GONE);
                //CourseDescription.setText("Rating: "+coursedatabase.rating.get(course.vlog_position)+" stars");
            }
        });
        btnReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                des.setVisibility(View.VISIBLE);
                cer.setVisibility(View.GONE);
                CourseDescription.setText("Rating: "+coursedatabase.rating.get(course.vlog_position)+" stars");
            }
        });

        btnCurriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                des.setVisibility(View.VISIBLE);
                cer.setVisibility(View.GONE);
                CourseDescription.setText("No Curriculum found");
            }
        });

        btnCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                des.setVisibility(View.GONE);
                cer.setVisibility(View.VISIBLE);
            }
        });


    }
}