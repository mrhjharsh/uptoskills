package com.example.uptoskills;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uptoskills.ui.signout.resume_data;
import com.example.uptoskills.ui.signout.templates;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;

public class jobview extends AppCompatActivity {
    Dialog customDialog;
    Button btnChooseFile ;
    TextView tvSelectedFile;
    private static final int REQUEST_CODE_FILE_PICKER = 1;
    EditText editName, editEmail, editPassingYear, editCity, editMobileNumber, editQualification, editCollegeName, editDOB, editAadharNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobview);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(jobview.this , resume_data.class));

            }
        });
        TextView location = findViewById(R.id.loca);
        TextView post = findViewById(R.id.post);
        TextView salary = findViewById(R.id.sala);
        TextView jobname = findViewById(R.id.jobname);
        TextView main = findViewById(R.id.maintext);
        Button apply = findViewById(R.id.app);
        customDialog = new Dialog(jobview.this);
        tvSelectedFile = customDialog.findViewById(R.id.tvSelectedFile);


        location.setText(jobdatabase.location.get(job.vlog_position));
        post.setText(jobdatabase.date.get(job.vlog_position).substring(0,10));
        salary.setText(jobdatabase.salary.get(job.vlog_position)+" INR / Month");
        jobname.setText(jobdatabase.title.get(job.vlog_position));


        String htmlCode = jobdatabase.innerdata.get(job.vlog_position);
        main.setText(Html.fromHtml(htmlCode)+"\n\n\n\n");
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Set the custom layout to the dialog
                customDialog.setContentView(R.layout.dialogbox);

                // Find the views in the custom layout
                editName = customDialog.findViewById(R.id.editName);
                editEmail = customDialog.findViewById(R.id.editEmail);
                editPassingYear = customDialog.findViewById(R.id.editPassingYear);
                editCity = customDialog.findViewById(R.id.editCity);
                editMobileNumber = customDialog.findViewById(R.id.editMobileNumber);
                editQualification = customDialog.findViewById(R.id.editQualification);
                editCollegeName = customDialog.findViewById(R.id.editCollegeName);
                editDOB = customDialog.findViewById(R.id.editDOB);
                editAadharNumber = customDialog.findViewById(R.id.editAadharNumber);
                btnChooseFile = customDialog.findViewById(R.id.btnChooseFile);

                btnChooseFile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Open the file picker
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("application/*");  // Set the file type filter, you can modify it based on your desired file types
                        startActivityForResult(intent, REQUEST_CODE_FILE_PICKER);




                    }
                });


                Button btnSubmit = customDialog.findViewById(R.id.btnSubmit);
                btnSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Retrieve the values entered in the EditText fields
                        String name = editName.getText().toString();
                        String email = editEmail.getText().toString();
                        String passingYear = editPassingYear.getText().toString();
                        String city = editCity.getText().toString();
                        String mobileNumber = editMobileNumber.getText().toString();
                        String qualification = editQualification.getText().toString();
                        String collegeName = editCollegeName.getText().toString();
                        String dob = editDOB.getText().toString();
                        String aadharNumber = editAadharNumber.getText().toString();

                        // Perform any necessary actions with the entered data

                        // Dismiss the dialog
                        customDialog.dismiss();
                    }
                });

                // Show the dialog
                customDialog.show();
            }
        });

    }
        // Create a dialog instance
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_CODE_FILE_PICKER && resultCode == RESULT_OK) {
                if (data != null) {
                    // Retrieve the selected file URI
                    Uri fileUri = data.getData();
                    String fileName = getFileName(fileUri);
                    TextView tf = customDialog.findViewById(R.id.tvSelectedFile);
                    tf.setText("File Chosen");




                    // Perform any necessary actions with the selected file
                    // For example, you can get the file path using fileUri.getPath()
                }
            }
        }

    private String getFileName(Uri uri) {
        String fileName = null;
        if (uri != null) {
            // Get the file path from the URI
            String path = uri.getPath();
            File file = new File(path);
            fileName = file.getName();
        }
        return fileName;
    }
}