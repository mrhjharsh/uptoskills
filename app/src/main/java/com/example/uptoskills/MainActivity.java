package com.example.uptoskills;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
        ImageView play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              BlankFragment b = new BlankFragment();
              MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame ,b).addToBackStack(null).commit();
            }
        });
        ImageView imageView = findViewById(R.id.sc1);
        TextView textView1 = findViewById(R.id.sc2);
        TextView textView2 = findViewById(R.id.sc3);
        TextView textView3 = findViewById(R.id.sc4);
        final ScrollView scrollView = findViewById(R.id.scroll);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top

            }
        });       textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top

            }
        });       textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top

            }
        });
        ImageView b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blog_view.vlog_position = -99;
                startActivity(new Intent(MainActivity.this , clickvlogviewer.class));
            }
        });

        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/1.png",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/4.png",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/5.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/6.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/9.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/13.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/14.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/18.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/17.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/20.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/21-1.png", ScaleTypes.CENTER_CROP));


        ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        Button blog_view = findViewById(R.id.blogview);
        blog_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , com.example.uptoskills.blog_view.class));
            }
        });
        ImageView option = findViewById(R.id.option);
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());

                // Set item click listener for the menu items
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item click event here
                        if(item.getItemId() == R.id.profile){
                            Toast.makeText(MainActivity.this, "profile", Toast.LENGTH_SHORT).show();
                        }

                        if(item.getItemId() == R.id.signout){
                            SharedPreferences s;
                            s  = getSharedPreferences("db1",MODE_PRIVATE);
                            SharedPreferences.Editor edit = s.edit();
                            edit.putString("login", "0");
                            edit.apply();
                            Log.d("kkkk" , "app opening"+s.getString("login","")+"");

                            finish();
                            startActivity(new Intent(MainActivity.this , login.class));

                        }
                        switch (item.getItemId()) {

                            case 1:
                                // Action for menu item 1
                                return true;
                            case 2:
                                // Action for menu item 2
                                return true;
                            // Add more cases for other menu items if needed
                            default:
                                return false;
                        }

                    }
                });

                // Show the popup menu
                popupMenu.show();
            }
        });



        ArrayList<SlideModel> imageList2 = new ArrayList<>(); // Create image list
        imageList2.add(new SlideModel(R.drawable.is1,ScaleTypes.CENTER_CROP));
        imageList2.add(new SlideModel(R.drawable.is2,ScaleTypes.CENTER_CROP));
        imageList2.add(new SlideModel(R.drawable.is3,ScaleTypes.CENTER_CROP));
        ImageSlider imageSlider2 = findViewById(R.id.image_slider2);
        imageSlider2.setImageList(imageList2);
        imageSlider2.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                // You can listen here.

            }

            @Override
            public void doubleClick(int position) {
                // Do not use onItemSelected if you are using a double click listener at the same time.
                // It's just added for specific cases.
                // Listen for clicks under 250 milliseconds.
            }
        });
        BottomNavigationView bn = findViewById(R.id.bottomNavigation);

        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (item.getItemId() == R.id.Learn) {
                    // Handle item 2 click
                    Toast.makeText(MainActivity.this, "Learn", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.Discover) {
                    // Handle Discover item click
                    PopupMenu popupMenu = new PopupMenu(MainActivity.this, bn);
                    popupMenu.getMenuInflater().inflate(R.menu.discover_submenu, popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            // Handle submenu item click
                            if(menuItem.getItemId() == R.id.submenu_item1){
                                startActivity(new Intent(MainActivity.this ,Aboutus.class));
                            }
                            if(menuItem.getItemId() == R.id.submenu_item2){
                                startActivity(new Intent(MainActivity.this , com.example.uptoskills.blog_view.class));

                            }
                            if(menuItem.getItemId() == R.id.submenu_item3){

                            }
                            if(menuItem.getItemId() == R.id.submenu_item4){
                                startActivity(new Intent(MainActivity.this , com.example.uptoskills.contactus.class));
                            }
                            return true;
                        }
                    });

                    popupMenu.show();
                }

                return true;
            }
        });


    }
}