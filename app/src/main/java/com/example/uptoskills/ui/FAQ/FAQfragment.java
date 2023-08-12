package com.example.uptoskills.ui.FAQ;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentGalleryBinding;

public class FAQfragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.faq_activity, container, false);
        return v;

    }


}