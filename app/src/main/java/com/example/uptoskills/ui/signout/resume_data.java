package com.example.uptoskills.ui.signout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uptoskills.Aboutus;
import com.example.uptoskills.Main2Activity;
import com.example.uptoskills.MainActivity;
import com.example.uptoskills.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class resume_data extends AppCompatActivity {


    static public String name = "";
    final Calendar myCalendar = Calendar.getInstance();
    int s = -1;
    // SimpleDateFormat dateFormat;

    private static final int REQUEST_IMAGE_PICK = 1;
    String selectedDate = "";
    static public Bitmap bitmap;
    EditText startexp;


    static public String profession = "";
    static public String phone = "";
    EditText endexp;

    static public String email = "";
    EditText startdate;
    EditText enddate;


    static public List<String> skillss = new ArrayList<>();
    static public List<String> archievement_titless = new ArrayList<>();
    static public List<String> archievement_descriptionss = new ArrayList<>();

    static public List<String> schoolss = new ArrayList<>();
    static public List<String> educationdetailss = new ArrayList<>();
    static public List<String> namess = new ArrayList<>();
    static public List<String> linkss = new ArrayList<>();
    static public List<String> descriptionss = new ArrayList<>();
    static public List<String> exptitle = new ArrayList<>();
    static public List<String> expcompany = new ArrayList<>();
    static public List<String> expdescription = new ArrayList<>();


    static public CircleImageView imageView;


    static public String address = "";
    static public String about = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_data);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(resume_data.this, Main2Activity.class));

            }
        });
        TextInputEditText xname = findViewById(R.id.name);
        TextInputEditText xprofesstion = findViewById(R.id.profession);
        TextInputEditText xphone = findViewById(R.id.phone);
        TextInputEditText xemail = findViewById(R.id.email);
        TextInputEditText xaddress = findViewById(R.id.address);
        androidx.cardview.widget.CardView preview = findViewById(R.id.preview);
        TextInputEditText xabout = findViewById(R.id.about);
        TextInputEditText skill = findViewById(R.id.skill);
        TextInputEditText xarchievement_title = findViewById(R.id.title);
        TextInputEditText xarchievement_description = findViewById(R.id.archievement_description);
        TextView addskill = findViewById(R.id.addskill);
        TextView addarchievementt = findViewById(R.id.addarchievementt);
        TextView addeducation = findViewById(R.id.addeducation);
        TextView addexp = findViewById(R.id.addexp);
        TextView addproject = findViewById(R.id.addproject);
        imageView = findViewById(R.id.profile_image);
        TextInputEditText school = findViewById(R.id.school);
        TextInputEditText degree = findViewById(R.id.degree);
        enddate = findViewById(R.id.enddate_education);
        TextInputEditText city = findViewById(R.id.city);
        startdate = findViewById(R.id.startdate_eductaion);

        TextInputEditText projectname = findViewById(R.id.projectname);
        TextInputEditText projectlink = findViewById(R.id.projectlink);
        TextInputEditText projectdescription = findViewById(R.id.description_project);


        TextInputEditText title = findViewById(R.id.title_experience);
        TextInputEditText company = findViewById(R.id.company);
        TextInputEditText location = findViewById(R.id.location);
        startexp = findViewById(R.id.startdate_experience);
        endexp = findViewById(R.id.enddate_experience);
        TextInputEditText description = findViewById(R.id.description_experience);
        DatePickerDialog.OnDateSetListener date3 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel3();
            }
        };
        DatePickerDialog.OnDateSetListener date4 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel4();
            }
        };
        startexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(resume_data.this, date3, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        endexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(resume_data.this, date4, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        addexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.getText().toString().isEmpty() || company.getText().toString().isEmpty() || location.getText().toString().isEmpty() ||
                        startexp.getText().toString().isEmpty() || endexp.getText().toString().isEmpty() || description.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(resume_data.this, "Experience added in portfolio", Toast.LENGTH_SHORT).show();
                    exptitle.add(title.getText().toString());
                    expdescription.add(description.getText().toString());
                    expcompany.add(company.getText().toString() + " " + location.getText().toString() + " (" + startexp.getText().toString() + " to " + endexp.getText().toString() + ")");
                    title.setText("");
                    company.setText("");
                    location.setText("");
                    startexp.setText("");
                    description.setText("");
                    endexp.setText("");

                }
            }
        });
        addproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (projectname.getText().toString().isEmpty() || projectlink.getText().toString().isEmpty() || projectdescription.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    namess.add(projectname.getText().toString());
                    linkss.add(projectlink.getText().toString());
                    descriptionss.add(projectdescription.getText().toString());
                    projectlink.setText("");
                    projectname.setText("");
                    projectdescription.setText("");
                    Toast.makeText(resume_data.this, "Project added in portfolio", Toast.LENGTH_SHORT).show();
                }

            }
        });


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel2();
            }
        };

        startdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(resume_data.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        enddate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(resume_data.this, date2, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        addeducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (school.getText().toString().isEmpty() || degree.getText().toString().isEmpty() || city.getText().toString().isEmpty() ||
                        startdate.getText().toString().isEmpty() || enddate.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    schoolss.add(school.getText().toString());
                    educationdetailss.add(degree.getText().toString() + " " + city.getText().toString() + " (" + startdate.getText().toString() + " to " + enddate.getText().toString() + ")");
                    degree.setText("");
                    school.setText("");
                    city.setText("");
                    startdate.setText("");
                    enddate.setText("");
                    Toast.makeText(resume_data.this, "Education added in portfolio", Toast.LENGTH_SHORT).show();

                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromGallery();

            }
        });
        addskill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (skill.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Enter Skill", Toast.LENGTH_SHORT).show();
                } else {
                    skillss.add(skill.getText().toString());
                    skill.setText("");
                    Toast.makeText(resume_data.this, "Skill added in portfolio", Toast.LENGTH_SHORT).show();
                }

            }
        });
        addarchievementt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (xarchievement_title.getText().toString().isEmpty() || xarchievement_description.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Enter both Title and Description", Toast.LENGTH_SHORT).show();
                } else {
                    archievement_titless.add(xarchievement_title.getText().toString());
                    archievement_descriptionss.add(xarchievement_description.getText().toString());
                    xarchievement_title.setText("");
                    xarchievement_description.setText("");
                    Toast.makeText(resume_data.this, "Achievement added in portfolio", Toast.LENGTH_SHORT).show();
                }

            }
        });


        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!skill.getText().toString().isEmpty() || !xarchievement_title.getText().toString().isEmpty() || !school.getText().toString().isEmpty() ||
                        !title.getText().toString().isEmpty() || !projectname.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Please click on add button !", Toast.LENGTH_SHORT).show();
                } else if (xabout.getText().toString().isEmpty() || xname.getText().toString().isEmpty() || xprofesstion.getText().toString().isEmpty() ||
                        xphone.getText().toString().isEmpty() || xemail.getText().toString().isEmpty() || xaddress.getText().toString().isEmpty()) {
                    Toast.makeText(resume_data.this, "Please fill basic details", Toast.LENGTH_SHORT).show();
                } else {
                    name = xname.getText().toString() + "";
                    profession = xprofesstion.getText().toString() + "";
                    phone = "Phone - " + xphone.getText().toString() + "";
                    email = "Email - " + xemail.getText().toString() + "";
                    address = "Location - " + xaddress.getText().toString() + "";
                    about = xabout.getText().toString() + "";
                    if (s == -1) {
                        Toast.makeText(resume_data.this, "Please upload profile picture", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(resume_data.this, templates.class));
                    }
                }


            }
        });

    }


    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            try {
                // Get the image URI from the intent
                imageView = findViewById(R.id.profile_image);
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                imageView.setImageBitmap(bitmap);
                s = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        startdate.setText(dateFormat.format(myCalendar.getTime()));

    }

    private void updateLabel2() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        enddate.setText(dateFormat.format(myCalendar.getTime()));

    }

    private void updateLabel3() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        startexp.setText(dateFormat.format(myCalendar.getTime()));

    }

    private void updateLabel4() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        endexp.setText(dateFormat.format(myCalendar.getTime()));

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(resume_data.this, Main2Activity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}