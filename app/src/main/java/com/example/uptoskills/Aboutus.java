package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        ImageSlider imageSlider2 = findViewById(R.id.imageSlider);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(Aboutus.this, Main2Activity.class));

            }
        });

        ArrayList<SlideModel> imageList2 = new ArrayList<>(); // Create image list
        imageList2.add(new SlideModel(R.drawable.d10, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d11, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d12, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d13, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d14, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d15, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d16, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d17, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.d18, ScaleTypes.FIT));
        imageSlider2.setImageList(imageList2);
    }
}