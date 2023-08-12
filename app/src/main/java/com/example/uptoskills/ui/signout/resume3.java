package com.example.uptoskills.ui.signout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uptoskills.R;
import com.example.uptoskills.archievements_adapter;
import com.example.uptoskills.education_adapter;
import com.example.uptoskills.experience_adapter;
import com.example.uptoskills.project_adapter;
import com.example.uptoskills.skills_adapter;
import com.example.uptoskills.skills_adapter_t2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class resume3 extends AppCompatActivity {
    static RecyclerView rv;
    static RecyclerView education;
    static RecyclerView archievements;

    static RecyclerView project;

    static RecyclerView experience;
    ScrollView scrollView;

    skills_adapter cax;
    archievements_adapter arc;
    education_adapter edu;
    experience_adapter exp;
    project_adapter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume3);
        TextView xname = findViewById(R.id.name);
        TextView xprofesstion = findViewById(R.id.profession);
        TextView xphone = findViewById(R.id.phone);
        TextView xemail = findViewById(R.id.email);
        TextView xaddress = findViewById(R.id.address);
        TextView xabout = findViewById(R.id.about);
        CircleImageView imageView = findViewById(R.id.profile_image);
        imageView.setImageBitmap(resume_data.bitmap);
        xname.setText(resume_data.name);
        xprofesstion.setText(resume_data.profession);
        xphone.setText(resume_data.phone);
        xemail.setText(resume_data.email);
        xaddress.setText(resume_data.address);
        xabout.setText(resume_data.about);
        rv = findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(resume3.this));


        cax = new skills_adapter();
        rv.setAdapter(cax);


        archievements = findViewById(R.id.archivement_list);
        archievements.setLayoutManager(new LinearLayoutManager(resume3.this));

        arc = new archievements_adapter();
        archievements.setAdapter(arc);

        education = findViewById(R.id.education_list);
        education.setLayoutManager(new LinearLayoutManager(resume3.this));

        edu = new education_adapter();
        education.setAdapter(edu);


        experience = findViewById(R.id.experience_list);
        experience.setLayoutManager(new LinearLayoutManager(resume3.this));

        exp = new experience_adapter();
        experience.setAdapter(exp);


        project = findViewById(R.id.project_list);
        project.setLayoutManager(new LinearLayoutManager(resume3.this));

        p = new project_adapter();
        project.setAdapter(p);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                convertScrollViewToPdf();
            }
        }, 1000);
    }

    private void convertScrollViewToPdf() {
        String pdfFileName = resume_data.name + "_resume.pdf";
        String pdfFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath() + File.separator + pdfFileName;

        ScrollView scrollView = findViewById(R.id.scroll);

        // Get the height of the entire ScrollView content
        int totalHeight = scrollView.getChildAt(0).getHeight();

        // Create a PDF document
        PdfDocument document = new PdfDocument();
        int pageHeight = scrollView.getHeight();
        int totalPages = (int) Math.ceil((double) totalHeight / pageHeight);

        for (int pageNumber = 0; pageNumber < totalPages; pageNumber++) {
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(scrollView.getWidth(), pageHeight, pageNumber).create();
            PdfDocument.Page page = document.startPage(pageInfo);

            // Create a canvas for the PDF page
            Canvas canvas = page.getCanvas();
            canvas.drawColor(Color.WHITE);

            // Move the content to the correct position on the canvas
            int contentTop = -pageHeight * pageNumber;
            canvas.translate(0, contentTop);

            // Draw the content of the ScrollView on the canvas
            scrollView.draw(canvas);

            document.finishPage(page);
        }

        // Save the PDF to a file
        try {
            File file = new File(pdfFilePath);
            FileOutputStream outputStream = new FileOutputStream(file);
            document.writeTo(outputStream);
            outputStream.flush();
            outputStream.close();
            document.close();
            Toast.makeText(this, "PDF saved successfully at " + pdfFilePath, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error while saving PDF", Toast.LENGTH_SHORT).show();
        }
    }

}