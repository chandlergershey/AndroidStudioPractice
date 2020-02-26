package com.chandlerg.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    // views
    EditText mEmailEt, mPasswordEt;
    Button mRegistrationBtn;

    // progressbar to display while registering user
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Actionbar and its title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Create Account");
        //enable back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init
        mEmailEt.findViewById(R.id.emailEt);
        mPasswordEt.findViewById(R.id.passwordEt);
        mRegistrationBtn.findViewById(R.id.registerBtn);

        // in the onCreate() method, initialize Firebase auth
        mAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering user...");

        mRegistrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input email, password
                String email = mEmailEt.getText().toString().trim();
                String password = mPasswordEt.getText().toString().trim();
                //validate
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    mEmailEt.setError("Invalid email");
                    mEmailEt.setFocusable(true);
                } else if (password.length() < 6){
                    mPasswordEt.setError("Password must be at least 6 characters");
                    mPasswordEt.setFocusable(true);
                } else {
                    registerUser(email, password); // register the user

                    //
                }
            }
        });
    }

    private void registerUser(String email, String password){

    }

    @Override
    public boolean  onSupportNavigateUp() {
        onBackPressed(); // go previous activity
        return super.onSupportNavigateUp();
    }
}
