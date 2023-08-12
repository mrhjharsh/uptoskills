package com.example.uptoskills.ui.signout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.uptoskills.Aboutus;
import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;

public class templates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);
        ImageView t1 = findViewById(R.id.t1);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(templates.this, resume_data.class));

            }
        });
        ImageView t2 = findViewById(R.id.t2);
        ImageView t3 = findViewById(R.id.t3);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(templates.this, resume.class));
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(templates.this, resume2.class));
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(templates.this, resume3.class));
            }
        });
    }
}