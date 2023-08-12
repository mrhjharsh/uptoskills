package com.example.uptoskills;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class clickvlogviewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickvlogviewer);

        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView date = findViewById(R.id.date);
        ImageView image = findViewById(R.id.image);
        ProgressBar p1 = findViewById(R.id.progressBar);
        if (blog_view.vlog_position == -99) {
            Glide.with(clickvlogviewer.this).load(blogdatabase.url1.get(0)).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    p1.setVisibility(View.INVISIBLE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    p1.setVisibility(View.INVISIBLE);
                    return false;
                }
            }).into(image);
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            title.setText(blogdatabase.title1.get(0));
            date.setText("( Created at : " + blogdatabase.date1.get(0) + " )");
            String a = blogdatabase.description1.get(0);
            String htmlText = "";
            int k = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '[') {
                    k = 1;
                    continue;
                }
                if (a.charAt(i) == ']') {
                    k = 0;
                    continue;
                }
                if (k == 0) {
                    htmlText = htmlText + a.charAt(i);
                }
            }

            String htmlCode = htmlText;
            Document document = Jsoup.parse(htmlCode);
            String plainText = document.text();

            description.setText(plainText);
        } else {
            title.setText(blogdatabase.title1.get(blog_view.vlog_position + blog_view.s));
            date.setText("( Created at : " + blogdatabase.date1.get(blog_view.vlog_position + blog_view.s) + " )");
            String a = blogdatabase.description1.get(blog_view.vlog_position + blog_view.s);
            String htmlText = "";
            int k = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '[') {
                    k = 1;
                    continue;
                }
                if (a.charAt(i) == ']') {
                    k = 0;
                    continue;
                }
                if (k == 0) {
                    htmlText = htmlText + a.charAt(i);
                }
            }
            String htmlCode = htmlText;
            Document document = Jsoup.parse(htmlCode);
            String plainText = document.text();
            Log.d("kkkk", plainText);
            description.setText(plainText);
            Glide.with(clickvlogviewer.this).load(blogdatabase.url1.get(blog_view.vlog_position + blog_view.s)).listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    p1.setVisibility(View.INVISIBLE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    p1.setVisibility(View.INVISIBLE);
                    return false;
                }
            }).into(image);


        }
    }
}