package com.example.uptoskills;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.HalfFloat;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class NewService extends Service {
    String urls = "";

    String jobtype = "";

    public static String urli;
    private BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
                boolean isConnected = isNetworkConnected(context);
                if (!isConnected) {
                    SharedPreferences s;
                    s = getSharedPreferences("db1", MODE_PRIVATE);
                    SharedPreferences.Editor edit = s.edit();
                    edit.putString("login", "-1");
                    edit.apply();
                    Toast.makeText(context, "Check Your Internet Connectivity !", Toast.LENGTH_SHORT).show();
                    Intent newActivityIntent = new Intent(getApplicationContext(), login.class);
                    newActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(newActivityIntent);
                }
                else if( splash.nothavedata == 0){
                    Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();
                    vlogs();
                    job();
                    rest();
                    course();
                    splash.nothavedata = 1;
                }
            }
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(connectivityReceiver);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean isNetworkConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    void vlogs() {
        RequestQueue queue = Volley.newRequestQueue(this);
        for (int i = 1; i <= 27; i++) {
            String url = "https://uptoskills.com/wp-json/wp/v2/posts?page=" + i;
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
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
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
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
        RequestQueue queue1 = Volley.newRequestQueue(getApplicationContext());
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
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

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
