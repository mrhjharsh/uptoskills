package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blog_view extends AppCompatActivity {
    static RecyclerView rv ;
    CustomAdapter ca;
    public static int s= 0;
    public static  int e = 10;
    public static int vlog_position = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_view);
        TextView prev = findViewById(R.id.prev);
        TextView next = findViewById(R.id.next);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(blog_view.this , Main2Activity.class));
            }
        });
        rv = findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(blog_view.this));
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(blog_view.this, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        vlog_position = position;
                        // do whatever
                        startActivity(new Intent(blog_view.this , clickvlogviewer.class));
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );



        ca = new CustomAdapter(blog_view.this ,  s ,  e);
        rv.setAdapter(ca);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e<blogdatabase.url1.size()){
                    s = e;
                    e = e+10;
                    ca = new CustomAdapter(blog_view.this ,  s ,  e);
                    rv.setAdapter(ca);
                    RecyclerView recyclerView = findViewById(R.id.list);
                    recyclerView.scrollToPosition(0);
                }
                else {
                    Toast.makeText(blog_view.this, "Reached At Last Page", Toast.LENGTH_SHORT).show();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s > 0){
                    e = s;
                    s = s-10;
                    ca = new CustomAdapter(blog_view.this ,  s ,  e);
                    rv.setAdapter(ca);
                    ScrollView scrollView = findViewById(R.id.scroll);
                    scrollView.smoothScrollTo(0, 0); // Scroll to the top
                }
                else {
                    Toast.makeText(blog_view.this, "Reached At First Page", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }

}