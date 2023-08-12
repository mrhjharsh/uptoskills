package com.example.uptoskills.ui.signout;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentSlideshowBinding;
import com.example.uptoskills.login;

public class signout extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.signout, container, false);
        SharedPreferences s;
        getActivity().finish();


        startActivity(new Intent(getActivity(), login.class));
        s = getActivity().getSharedPreferences("db1", MODE_PRIVATE);
        SharedPreferences.Editor edit = s.edit();
        edit.putString("login", "0");
        edit.apply();
        Toast.makeText(getActivity(), "Logout Successfully", Toast.LENGTH_SHORT).show();

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}