package com.example.uptoskills;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uptoskills.ui.signout.resume_data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class certificate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificate);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                convertScrollViewToPdf();
            }
        },1000);

    }
    private void convertScrollViewToPdf() {
        String pdfFileName = resume_data.name + "_certificate.pdf";
        String pdfFilePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).getPath() + File.separator + pdfFileName;

        RelativeLayout scrollView = findViewById(R.id.cd);

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