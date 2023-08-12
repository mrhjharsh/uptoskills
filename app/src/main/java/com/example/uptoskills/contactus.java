package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class contactus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(contactus.this , Main2Activity.class));

            }
        });
        ImageView phoneus = findViewById(R.id.phoneus);
        phoneus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+919319772294"; // Replace with the desired phone number
                Uri uri = Uri.parse("tel:" + phoneNumber);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);


            }
        });
        ImageView mailus = findViewById(R.id.mailus);
        mailus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = "info@uptoskills.com"; // Replace with the desired email address



                String uriString = "mailto:" + emailAddress;
                Uri uri = Uri.parse(uriString);

                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

                startActivity(Intent.createChooser(intent, "Send email"));


            }
        });
        ImageView visitus = findViewById(R.id.visitus);
        visitus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 28.5709891; // Replace with the desired latitude
                double longitude = 77.0692787; // Replace with the desired longitude

                String uri = "geo:" + latitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);



            }
        });
    }
}