package com.example.uptoskills.ui.termandcondition;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.uptoskills.BlankFragment;
import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.R;
import com.example.uptoskills.databinding.FragmentSlideshowBinding;
import com.example.uptoskills.ui.home.HomeFragment;

public class termandcondition extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.termandcondition, container, false);
        TextView tf = v.findViewById(R.id.policy);
        ImageView back = v.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Main2Activity.class));

            }
        });

        tf.setText("Acceptance of Terms: By accessing and using the UptoSkills website, you agree to comply with these Terms & Conditions. If you do not agree with any part of these terms, please refrain from using the website.\n" +
                "\n" +
                "Intellectual Property: All content on the UptoSkills website, including text, graphics, logos, images, videos, and software, is the property of UptoSkills and protected by intellectual property laws. You may not modify, reproduce, distribute, or exploit any content without prior written permission.\n" +
                "\n" +
                "Use of the Website: You may use the UptoSkills website for personal, non-commercial purposes. You agree not to engage in any activities that may disrupt or interfere with the proper functioning of the website or violate any applicable laws or regulations.\n" +
                "\n" +
                "User-generated Content: Users may have the opportunity to submit or share content on the website, such as comments or reviews. By doing so, you grant UptoSkills a non-exclusive, worldwide, royalty-free license to use, modify, reproduce, and distribute the content for promotional or informational purposes.\n" +
                "\n" +
                "Privacy Policy: Your privacy is important to us. Please refer to our Privacy Policy, which outlines how we collect, use, and protect your personal information when you use our website.\n" +
                "\n" +
                "Third-party Websites and Content: The UptoSkills website may contain links to third-party websites or display content from third-party sources. We are not responsible for the accuracy, legality, or content of these external sources. Use them at your own risk.\n" +
                "\n" +
                "Disclaimer of Warranties: The UptoSkills website is provided on an “as is” and “as available” basis. We do not make any warranties or representations regarding the accuracy, completeness, or reliability of the content. Your use of the website is at your own risk.\n" +
                "\n" +
                "Limitation of Liability: UptoSkills and its affiliates shall not be liable for any direct, indirect, incidental, consequential, or punitive damages arising from your use of the website or any content therein.\n" +
                "\n" +
                "Changes to Terms & Conditions: UptoSkills reserves the right to modify or update these Terms & Conditions at any time without prior notice. It is your responsibility to review them periodically for any changes.\n" +
                "\n" +
                "Governing Law: These Terms & Conditions shall be governed by and construed in accordance with the laws of Delhi Jurisdiction. Any disputes arising out of or related to these terms shall be subject to the exclusive jurisdiction of the courts in Delhi Jurisdiction.\n" +
                "\n" +
                "By using the UptoSkills website, you agree to abide by these Terms & Conditions. If you have any questions or concerns, please contact us at info@uptoskills.com");

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}