package com.example.homedork;


import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText textEmail;
    private Button resetPassword;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        textEmail = (EditText) findViewById(R.id.email);
        resetPassword = (Button) findViewById(R.id.resetPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {

        String email = textEmail.getText().toString().trim();
        if (email.isEmpty()) {
            textEmail.setError("Email is required");
            textEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textEmail.setError("Please provide a valid email");
            textEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPassword.this, "Check your email to reset your password", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(ForgotPassword.this, "Try again! Something wrong happened", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}