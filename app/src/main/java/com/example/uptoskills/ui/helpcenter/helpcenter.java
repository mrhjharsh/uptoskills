package com.example.uptoskills.ui.helpcenter;

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

import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentSlideshowBinding;

public class helpcenter extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.helpcenter, container, false);

        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Main2Activity.class));

            }
        });
        TextView textView = v.findViewById(R.id.address);

        SpannableStringBuilder builder = new SpannableStringBuilder();

        String fullText = "Address: Palam, New Delhi, Delhi 110077";

// Set "Phone:" in orange color
        String orangeText = "Address:";
        SpannableString orangeSpannable = new SpannableString(orangeText);
        orangeSpannable.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA500")), 0, orangeText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(orangeSpannable);

// Set the remaining text in white color
        String remainingText = fullText.substring(orangeText.length());
        SpannableString whiteSpannable = new SpannableString(remainingText);
        whiteSpannable.setSpan(new ForegroundColorSpan(Color.WHITE), 0, remainingText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(whiteSpannable);

        textView.setText(builder, TextView.BufferType.SPANNABLE);


        TextView e1 = v.findViewById(R.id.email);

        SpannableStringBuilder e2 = new SpannableStringBuilder();

        String e3 = "Email: info@uptoskills.com";

// Set "Phone:" in orange color
        String mm = "Email:";
        SpannableString po = new SpannableString(mm);
        po.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA500")), 0, mm.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        e2.append(po);

// Set the remaining text in white color
        String e4 = e3.substring(mm.length());
        SpannableString ijk = new SpannableString(e4);
        ijk.setSpan(new ForegroundColorSpan(Color.WHITE), 0, e4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        e2.append(ijk);

        e1.setText(e2, TextView.BufferType.SPANNABLE);
        ImageView v6 = v.findViewById(R.id.v6);
        ImageView v2 = v.findViewById(R.id.v2);
        ImageView v3 = v.findViewById(R.id.v3);
        ImageView v4 = v.findViewById(R.id.v4);
        ImageView v5 = v.findViewById(R.id.v5);
        ImageView v1 = v.findViewById(R.id.v1);
        v6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telegramLink = "https://t.me/uptoskills";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(telegramLink));
                startActivity(intent);
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookPage = "https://www.facebook.com/Uptoskills/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPage));
                startActivity(intent);
            }
        });
        v3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linkedInPage = "https://www.linkedin.com/company/uptoskills/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInPage));
                startActivity(intent);
            }
        });
        v4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String instagramPage = "https://www.instagram.com/uptoskills/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramPage));
                startActivity(intent);
            }
        });
        v5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookPage = "https://www.youtube.com/channel/UCJzITNWKW5njk0AWkEZxSrw";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPage));
                startActivity(intent);
            }
        });
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookPage = "https://twitter.com/i/flow/login?redirect_after_login=%2FSkillsUpto%3Fs%3D08";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(facebookPage));
                startActivity(intent);
            }
        });

        TextView q1 = v.findViewById(R.id.phone);

        SpannableStringBuilder q2 = new SpannableStringBuilder();

        String q3 = "Phone: +91-9319772294";

// Set "Phone:" in orange color
        String mnnn = "Phone:";
        SpannableString nbjj = new SpannableString(mnnn);
        nbjj.setSpan(new ForegroundColorSpan(Color.parseColor("#FFA500")), 0, mnnn.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        q2.append(nbjj);

// Set the remaining text in white color
        String a4 = q3.substring(mnnn.length());
        SpannableString lklkm = new SpannableString(a4);
        lklkm.setSpan(new ForegroundColorSpan(Color.WHITE), 0, a4.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        q2.append(lklkm);

        q1.setText(q2, TextView.BufferType.SPANNABLE);


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}