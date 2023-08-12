package com.example.uptoskills.ui.trainer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;

public class trainer extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_becometrainer, container, false);
        ArrayList<SlideModel> imageList2 = new ArrayList<>(); // Create image list
        imageList2.add(new SlideModel(R.drawable.x1, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x2, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x3, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x4, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x5, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x6, ScaleTypes.FIT));
        imageList2.add(new SlideModel(R.drawable.x7, ScaleTypes.FIT));
        ImageSlider imageSlider2 = v.findViewById(R.id.image_slider2);
        imageSlider2.setImageList(imageList2);
        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Main2Activity.class));

            }
        });


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}