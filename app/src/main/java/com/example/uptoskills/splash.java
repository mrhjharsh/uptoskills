package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class splash extends AppCompatActivity {
    public static String title;
    public static String content;
    public static String date;
    String urls = "";
    static public int nothavedata = 0;
    SharedPreferences s;

    String jobtype = "";

    public static String urli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        if (CheckNetwork.isInternetAvailable(splash.this)) {
            nothavedata = 1;
            vlogs();
            job();
            rest();
            course();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    String check = "0";
                    s = getSharedPreferences("db1", MODE_PRIVATE);
                    check = s.getString("login", "");
                    if (check.equals("1")) {
                        finish();
                        startActivity(new Intent(splash.this, Main2Activity.class));
                    } else if (check.equals("-1")) {
                        finish();
                        startActivity(new Intent(splash.this, login.class));
                        Toast.makeText(splash.this, "Session Timeout , Please Login Again", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(splash.this, login.class));
                    }
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 3000);

        }
        Intent serviceIntent = new Intent(splash.this, NewService.class);
        startService(serviceIntent);
   }


    void vlogs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        for (int i = 1; i <= 27; i++) {
            String url = "https://uptoskills.com/wp-json/wp/v2/posts?page=" + i;

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            try {
                                JSONArray data = new JSONArray(response);
                                for (int i = 0; i < data.length(); i++) {
                                    JSONObject obj = data.getJSONObject(i);
                                    JSONObject obj2 = obj.getJSONObject("yoast_head_json");
                                    JSONObject cont = obj.getJSONObject("content");
                                    JSONArray image = obj2.getJSONArray("og_image");
                                    JSONObject imagedata = image.getJSONObject(0);
                                    String title = obj2.getString("title");
                                    String date = obj.getString("date");
                                    String content = cont.getString("rendered");
                                    String url = imagedata.getString("url");
                                    blogdatabase.title1.add(title);
                                    blogdatabase.url1.add(url);
                                    blogdatabase.description1.add(content);
                                    blogdatabase.date1.add(date);
                                    Log.d("hty", response);
                                }

                            } catch (Exception e) {
                                Log.d("yyyy", "not work" + e);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);
        }

    }

    void course() {
        String url = "https://uptoskills.com/wp-json/learnpress/v1/courses";
        RequestQueue queue = Volley.newRequestQueue(splash.this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray data = new JSONArray(response);
                            Log.d("aaa", data + "");
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject obj = data.getJSONObject(i);
                                String name = obj.getString("name");
                                String imageurl = obj.getString("image");
                                String content = obj.getString("content");
                                String duration = obj.getString("duration");
                                String count_students = obj.getString("count_students");
                                String rating = obj.getString("rating");
                                String price_rendered = obj.getString("price_rendered");
                                String origin_price_rendered = obj.getString("origin_price_rendered");
                                JSONArray cat = obj.getJSONArray("categories");
                                String typeofprograme = cat.getJSONObject(0).getString("name");

                                coursedatabase.name.add(name);
                                coursedatabase.image_url.add(imageurl);
                                coursedatabase.content.add(content);
                                coursedatabase.duration.add(duration);
                                coursedatabase.count_students.add(count_students);
                                coursedatabase.rating.add(rating);
                                coursedatabase.price_rendered.add(price_rendered);
                                coursedatabase.origin_price_rendered.add(origin_price_rendered);
                                coursedatabase.typeofprograme.add(typeofprograme);
                                coursedatabase.count_students.add(count_students);
                                coursedatabase.rating.add(rating);
                                coursedatabase.price_rendered.add(price_rendered);
                                coursedatabase.origin_price_rendered.add(origin_price_rendered);
                                coursedatabase.typeofprograme.add(typeofprograme);
                            }

                        } catch (Exception e) {
                            Log.d("llll", "not work" + e);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // textView.setText("That didn't work!");
                Log.d("llll", "not work" + error);


            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    void rest() {
        String url1 = urls;
        RequestQueue queue1 = Volley.newRequestQueue(splash.this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.GET, url1,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray data = new JSONArray(response);
                            JSONObject obj = data.getJSONObject(0);
                            jobtype = obj.getString("name");
                            jobdatabase.jobtype.add(jobtype);
                            Log.d("cccc", jobtype + "");

                        } catch (Exception e) {
                            Log.d("llll", "not work" + e);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // textView.setText("That didn't work!");
                Log.d("llll", "not work" + error);


            }
        });

// Add the request to the RequestQueue.
        queue1.add(stringRequest1);
    }

    void job() {
        String url = "https://uptoskills.com/wp-json/wp/v2/job-listings";
        RequestQueue queue = Volley.newRequestQueue(splash.this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray data = new JSONArray(response);
                            for (int i = 0; i < data.length(); i++) {
                                JSONObject obj = data.getJSONObject(i);
                                JSONObject obj2 = obj.getJSONObject("title");
                                JSONObject obj3 = obj.getJSONObject("content");
                                JSONObject obj4 = obj.getJSONObject("meta");
                                JSONObject links = obj.getJSONObject("_links");
                                JSONArray term = links.getJSONArray("wp:term");
                                JSONObject link = term.getJSONObject(0);
                                String date = obj.getString("date");
                                String title = obj2.getString("rendered");
                                String innerdata = obj3.getString("rendered");
                                String outerdata = obj4.getString("_company_tagline");
                                String location = obj4.getString("_job_location");
                                String salary = obj4.getString("_job_salary");


                                jobdatabase.date.add(date);
                                jobdatabase.title.add(title);
                                jobdatabase.innerdata.add(innerdata);
                                jobdatabase.outerdata.add(outerdata);
                                jobdatabase.location.add(location);
                                jobdatabase.salary.add(salary);
                                urls = link.getString("href");
                                rest();

                            }


                        } catch (Exception e) {


                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // textView.setText("That didn't work!");
                Log.d("llll", "not work" + error);
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}