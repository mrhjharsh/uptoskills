package com.example.uptoskills.ui.home;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.uptoskills.Aboutus;
import com.example.uptoskills.BlankFragment;
import com.example.uptoskills.CustomAdapter2;
import com.example.uptoskills.MainActivity;
import com.example.uptoskills.NewService;
import com.example.uptoskills.R;
import com.example.uptoskills.blog_view;
import com.example.uptoskills.blogdatabase;
import com.example.uptoskills.clickvlogviewer;
import com.example.uptoskills.contactus;
import com.example.uptoskills.course;
import com.example.uptoskills.databinding.FragmentHomeBinding;
import com.example.uptoskills.faq;
import com.example.uptoskills.job;
import com.example.uptoskills.jobdatabase;
import com.example.uptoskills.ui.signout.resume;
import com.example.uptoskills.ui.signout.resume_data;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private boolean doubleBackToExitPressedOnce = false;

    private FragmentHomeBinding binding;
    private static final String LOGIN_URL = "https://uptoskills.com/wp-login.php";
    static final String USERNAME = "harshjain123"; // Replace with your username
    private static final String PASSWORD = "harsain123"; // Replace with your password


    static RecyclerView rv;
    CustomAdapter2 cax;

    private void openNavigationDrawer() {
        DrawerLayout drawerLayout = getActivity().findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //  new LoginTask().execute();


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button training = root.findViewById(R.id.training);
        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), course.class));
            }
        });
        // Passing each menu ID as a set of Ids because each
        ImageView icc = root.findViewById(R.id.option);

        icc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNavigationDrawer();
            }
        });

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
        ImageView play = root.findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment b = new BlankFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame, b).addToBackStack(null).commit();
            }
        });
        ImageView imageView = root.findViewById(R.id.sc1);
        TextView textView1 = root.findViewById(R.id.sc2);
        TextView textView2 = root.findViewById(R.id.sc3);
        TextView textView3 = root.findViewById(R.id.sc4);


        final ScrollView scrollView = root.findViewById(R.id.scroll);
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
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top

            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.smoothScrollTo(0, 0); // Scroll to the top

            }
        });
        ImageView tarin = root.findViewById(R.id.t1);
        TextView tarin1 = root.findViewById(R.id.t2);
        TextView tarin2 = root.findViewById(R.id.t3);
        TextView tarin3 = root.findViewById(R.id.t4);
        Button blog_views = root.findViewById(R.id.blogview);
        blog_views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), com.example.uptoskills.blog_view.class));
            }
        });


        ArrayList<SlideModel> imageList4 = new ArrayList<>(); // Create image list
        if (blogdatabase.url1.size() >= 1)
            imageList4.add(new SlideModel(blogdatabase.url1.get(0), ScaleTypes.CENTER_CROP));
        if (blogdatabase.url1.size() >= 2)
            imageList4.add(new SlideModel(blogdatabase.url1.get(1), ScaleTypes.CENTER_CROP));
        if (blogdatabase.url1.size() >= 3)
            imageList4.add(new SlideModel(blogdatabase.url1.get(2), ScaleTypes.CENTER_CROP));
        if (blogdatabase.url1.size() >= 4)
            imageList4.add(new SlideModel(blogdatabase.url1.get(3), ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider5 = root.findViewById(R.id.image_slider4);
        imageSlider5.setImageList(imageList4);
        imageSlider5.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int i) {
                blog_view.vlog_position = i;
                startActivity(new Intent(getActivity(), clickvlogviewer.class));
            }

            @Override
            public void doubleClick(int i) {

            }
        });


        tarin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), course.class));
            }
        });
        tarin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), course.class));


            }
        });
        tarin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), course.class));


            }
        });
        tarin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), course.class));


            }
        });


        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/1.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/4.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/5.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/6.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/9.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/13.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/14.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/18.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/17.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/20.png", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://uptoskills.com/wp-content/uploads/2023/05/21-1.png", ScaleTypes.CENTER_CROP));


        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);


        ArrayList<SlideModel> imageList2 = new ArrayList<>(); // Create image list
        imageList2.add(new SlideModel(R.drawable.is1, ScaleTypes.CENTER_INSIDE));
        imageList2.add(new SlideModel(R.drawable.is2, ScaleTypes.CENTER_INSIDE));
        imageList2.add(new SlideModel(R.drawable.is3, ScaleTypes.CENTER_INSIDE));
        imageList2.add(new SlideModel(R.drawable.is4, ScaleTypes.CENTER_INSIDE));
        ImageSlider imageSlider2 = root.findViewById(R.id.image_slider2);

        imageSlider2.setImageList(imageList2);


        BottomNavigationView bn = root.findViewById(R.id.bottomNavigation);

        bn.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                if (item.getItemId() == R.id.Learn) {
                    // Handle item 2 click
                    startActivity(new Intent(getActivity(), course.class));
                }

                if (item.getItemId() == R.id.Job) {
                    startActivity(new Intent(getActivity(), job.class));
                }
                if (item.getItemId() == R.id.Discover) {
                    // Handle Discover item click
                    PopupMenu popupMenu = new PopupMenu(getActivity(), bn);
                    popupMenu.getMenuInflater().inflate(R.menu.discover_submenu, popupMenu.getMenu());

                    popupMenu.setGravity(Gravity.RIGHT);


                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            // Handle submenu item click
                            if (menuItem.getItemId() == R.id.submenu_item1) {
                                startActivity(new Intent(getActivity(), Aboutus.class));
                            }
                            if (menuItem.getItemId() == R.id.submenu_item2) {
                                startActivity(new Intent(getActivity(), com.example.uptoskills.blog_view.class));

                            }
                            if (menuItem.getItemId() == R.id.submenu_item3) {
                                startActivity(new Intent(getActivity(), faq.class));


                            }
                            if (menuItem.getItemId() == R.id.submenu_item4) {
                                startActivity(new Intent(getActivity(), contactus.class));
                            }

                            return true;
                        }
                    });

                    popupMenu.show();
                }

                return true;
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}