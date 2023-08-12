package com.example.uptoskills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.uptoskills.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class login extends AppCompatActivity {
    String urls = "";


    String jobtype = "";

    public static String urli;
    private static FirebaseAuth mAuth;
    SharedPreferences s;
    private static final String LOGIN_URL = "https://uptoskills.com/wp-login.php";
    static String USERNAME = ""; // Replace with your username
    private static String PASSWORD = ""; // Replace with your password

    FirebaseUser user;
    static public String email = "0";
    private static final String TAG = "PhoneAuthActivity";
    static String check = "0";
    int password = 0;
    static String global = "";
    private static final int RC_SIGN_IN = 9001;

    private static PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();
        ImageButton google = findViewById(R.id.google);
        Button log = findViewById(R.id.log);
        Button reg = findViewById(R.id.reg);
        RelativeLayout loginpage = findViewById(R.id.layoutlog);
        FrameLayout registerpage = findViewById(R.id.layoutreg);
        ImageView back = findViewById(R.id.back);
        ImageView glogo = findViewById(R.id.glogo);
        TextInputEditText e = findViewById(R.id.email);
        TextInputEditText p = findViewById(R.id.password);

        TextInputEditText crtUsername = findViewById(R.id.crtUsername);
        TextInputEditText crtemail = findViewById(R.id.crtemail);
        TextInputEditText crtpass = findViewById(R.id.crtpass);
        TextInputEditText mobileNo = findViewById(R.id.mobileNo);
        CardView sign = findViewById(R.id.SignU);
        s = getSharedPreferences("db1", MODE_PRIVATE);
        check = s.getString("login", "");
        if (check.equals("1")) {
            finish();
            startActivity(new Intent(login.this, Main2Activity.class));
        }
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crtUsername.getText().toString().isEmpty() || crtemail.getText().toString().isEmpty() ||
                        crtpass.getText().toString().isEmpty() || mobileNo.getText().toString().isEmpty()) {
                    Toast.makeText(login.this, "Fill all columns", Toast.LENGTH_SHORT).show();
                } else {
                    s = getSharedPreferences("db1", MODE_PRIVATE);
                    SharedPreferences.Editor edit = s.edit();
                    edit.putString("login", "1");
                    edit.apply();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                            startActivity(new Intent(login.this, Main2Activity.class));

                        }
                    }, 2000);
                    Toast.makeText(login.this, "Signup Successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
        CardView lo = findViewById(R.id.SignInWithEmail);


        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ii = 0;
                if (e.getText().toString().isEmpty() || p.getText().toString().isEmpty()) {
                    Toast.makeText(login.this, "Fill Both Column", Toast.LENGTH_SHORT).show();
                } else {
                    USERNAME = e.getText().toString();
                    PASSWORD = p.getText().toString();
                    new LoginTask().execute();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerpage.setVisibility(View.INVISIBLE);
                loginpage.setVisibility(View.VISIBLE);
            }
        });
        glogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();
                mGoogleSignInClient = GoogleSignIn.getClient(login.this, gso);
                signIn();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerpage.setVisibility(View.VISIBLE);
                loginpage.setVisibility(View.INVISIBLE);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getString(R.string.default_web_client_id))
                        .requestEmail()
                        .build();
                mGoogleSignInClient = GoogleSignIn.getClient(login.this, gso);
                signIn();
            }
        });
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                global = verificationId;
            }
        };

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                        } else {

                        }
                    }
                });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {

            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            user = mAuth.getCurrentUser();
                            s = getSharedPreferences("db1", MODE_PRIVATE);
                            SharedPreferences.Editor edit = s.edit();
                            edit.putString("login", "1");
                            edit.putString("androidname", user.getDisplayName());
                            edit.putString("androidemail", user.getEmail());

                            edit.apply();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    finish();
                                    startActivity(new Intent(login.this, Main2Activity.class));

                                }
                            }, 2000);
                            Log.d("kkkk", "google sign" + check + "");

                            Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                        }
                    }
                });
    }

    class LoginTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                // Connect to the login page
                Connection.Response loginForm = Jsoup.connect(LOGIN_URL)
                        .method(Connection.Method.GET)
                        .execute();

                // Extract the login form data (e.g., nonce, action, etc.) to submit with credentials
                Document loginDoc = loginForm.parse();
                String loginAction = loginDoc.select("#loginform").attr("action");
                String loginNonce = loginDoc.select("#loginform input[name=log]").attr("value");

                // Send login POST request with credentials
                Connection.Response loginResponse = Jsoup.connect(LOGIN_URL)
                        .data("log", USERNAME)
                        .data("pwd", PASSWORD)
                        .data("wp-submit", "Log In")
                        .data("redirect_to", "https://uptoskills.com") // Replace with your desired redirect URL
                        .data("testcookie", "1")
                        .data("action", loginAction)
                        .data("security-check", loginNonce)
                        .cookies(loginForm.cookies()) // Use cookies from the initial connection
                        .method(Connection.Method.POST)
                        .execute();

                // Check if the login was successful by examining the response URL
                String responseUrl = loginResponse.url().toString();
                return !responseUrl.contains("wp-login.php"); // If login was successful, the URL would not contain wp-login.php

            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean loginSuccessful) {
            if (loginSuccessful) {
                // Login successful
                s = getSharedPreferences("db1", MODE_PRIVATE);
                SharedPreferences.Editor edit = s.edit();
                edit.putString("login", "1");
                edit.putString("androidemail", USERNAME);
                edit.apply();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        startActivity(new Intent(login.this, Main2Activity.class));

                    }
                }, 2000);
                Toast.makeText(login.this, "Login Successfully", Toast.LENGTH_SHORT).show();


            } else {
                // Login failed
                Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }


}


