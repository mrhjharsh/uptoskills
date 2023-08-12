package com.example.uptoskills.ui.resumeui;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentSlideshowBinding;
import com.example.uptoskills.ui.signout.resume_data;

public class resumebuilder extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_resumebuilder, container, false);

// Inside your fragment class
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

// Replace "YourFragment" with the actual class name of the fragment you want to remove
        Fragment fragmentToRemove = fragmentManager.findFragmentByTag("resumebuilder");
        if (fragmentToRemove != null) {
            fragmentTransaction.remove(fragmentToRemove);
        }

        fragmentTransaction.commit();
        Intent intent = new Intent(getActivity(), resume_data.class);
        startActivity(intent);
        requireActivity().finish();


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}