package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class faq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        // Assuming you have a LinearLayout container in your activity or fragment
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(faq.this , Main2Activity.class));

            }
        });

// Retrieve the question and answer TextViews from the inflated view
        TextView questionTextView = findViewById(R.id.questionTextView);
        TextView answerTextView = findViewById(R.id.answerTextView);

        TextView questionTextView2 = findViewById(R.id.questionTextView2);
        TextView answerTextView2 = findViewById(R.id.answerTextView2);

        TextView questionTextView3 = findViewById(R.id.questionTextView3);
        TextView answerTextView3 = findViewById(R.id.answerTextView3);

        TextView questionTextView4 = findViewById(R.id.questionTextView4);
        TextView answerTextView4 = findViewById(R.id.answerTextView4);

        TextView questionTextView5 = findViewById(R.id.questionTextView5);
        TextView answerTextView5 = findViewById(R.id.answerTextView5);

        TextView questionTextView6 = findViewById(R.id.questionTextView6);
        TextView answerTextView6 = findViewById(R.id.answerTextView6);

        TextView questionTextView7 = findViewById(R.id.questionTextView7);
        TextView answerTextView7 = findViewById(R.id.answerTextView7);

        TextView questionTextView8 = findViewById(R.id.questionTextView8);
        TextView answerTextView8 = findViewById(R.id.answerTextView8);

// Set the question text
        questionTextView.setText("What if I did not recieve a password reset message? +");

        answerTextView.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");

        questionTextView2.setText("Where can I find my programe certificate? +");

        answerTextView2.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");
        questionTextView3.setText("When does my course start and end? +");

        answerTextView3.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");

        questionTextView4.setText("Can you help me select an enrollment my path? +");

        answerTextView4.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");
        questionTextView5.setText("Can you help me select an enrollment my path? +");

        answerTextView5.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");

        questionTextView6.setText("Can you help me select an enrollment my path? +");

        answerTextView6.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");
        questionTextView7.setText("Can you help me select an enrollment my path? +");

        answerTextView7.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");

        questionTextView8.setText("Can you help me select an enrollment my path? +");

        answerTextView8.setText("Whether you want to develop as a professional or discover a new hobby, there’s an online course for that.");

// Set a click listener on the question TextView to toggle visibility of the answer
        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView.getVisibility() == View.VISIBLE) {
                    answerTextView.setVisibility(View.GONE);
                } else {
                    answerTextView.setVisibility(View.VISIBLE);
                }
            }
        });
        questionTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView2.getVisibility() == View.VISIBLE) {
                    answerTextView2.setVisibility(View.GONE);
                } else {
                    answerTextView2.setVisibility(View.VISIBLE);
                }
            }
        });
        questionTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView3.getVisibility() == View.VISIBLE) {
                    answerTextView3.setVisibility(View.GONE);
                } else {
                    answerTextView3.setVisibility(View.VISIBLE);
                }
            }
        });
    questionTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView4.getVisibility() == View.VISIBLE) {
                    answerTextView4.setVisibility(View.GONE);
                } else {
                    answerTextView4.setVisibility(View.VISIBLE);
                }
            }
        });
   questionTextView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView5.getVisibility() == View.VISIBLE) {
                    answerTextView5.setVisibility(View.GONE);
                } else {
                    answerTextView5.setVisibility(View.VISIBLE);
                }
            }
        });   questionTextView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView6.getVisibility() == View.VISIBLE) {
                    answerTextView6.setVisibility(View.GONE);
                } else {
                    answerTextView6.setVisibility(View.VISIBLE);
                }
            }
        });   questionTextView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView7.getVisibility() == View.VISIBLE) {
                    answerTextView7.setVisibility(View.GONE);
                } else {
                    answerTextView7.setVisibility(View.VISIBLE);
                }
            }
        });   questionTextView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answerTextView8.getVisibility() == View.VISIBLE) {
                    answerTextView8.setVisibility(View.GONE);
                } else {
                    answerTextView8.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}