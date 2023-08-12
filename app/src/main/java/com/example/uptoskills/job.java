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

public class job extends AppCompatActivity {
    static RecyclerView rv ;
    CustomAdapter3 nnn;

    public static int vlog_position = -1;
    String jobtype = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        rv = findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(job.this));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(job.this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        vlog_position = position;
                        startActivity(new Intent(job.this , jobview.class));
                        // do whatever
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );


        nnn = new CustomAdapter3(job.this);
        rv.setAdapter(nnn);


        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(job.this , Main2Activity.class));

            }
        });

    }
}