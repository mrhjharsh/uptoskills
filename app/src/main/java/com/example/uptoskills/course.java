package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class course extends AppCompatActivity {
    static RecyclerView rv ;
    CustomAdapter2 cax;
    public static int vlog_position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        rv = findViewById(R.id.list);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

                startActivity(new Intent(course.this , Main2Activity.class));

            }
        });
        rv.setLayoutManager(new LinearLayoutManager(course.this));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(course.this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        vlog_position = position;
                        // do whatever
                        startActivity(new Intent(course.this , courseview.class));
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );




        cax = new CustomAdapter2(course.this);
        rv.setAdapter(cax);

    }


}