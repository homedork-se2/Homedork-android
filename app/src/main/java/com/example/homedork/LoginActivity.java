package com.example.homedork;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.ProfileActivity;
import com.example.homedork.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView register, forgotPassword;
    private EditText textEmail, textPassword;
    private Button signIn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        register = (TextView) findViewById(R.id.register);

        register.setOnClickListener(this);
        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())) {
            case R.id.register:
                startActivity(new Intent(this, RegisterUser.class));
                break;

            case R.id.signIn:
                userLogin();
                break;

            case R.id.forgotPassword:
                startActivity(new Intent(LoginActivity.this, ForgotPassword.class));
                break;
        }

    }

    private void userLogin() {
        String email = textEmail.getText().toString().trim();
        String password = this.textPassword.getText().toString().trim();

        if (email.isEmpty()) {
            textEmail.setError("Email is required");
            textEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textEmail.setError("Please enter a valid email!");
            textEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            this.textPassword.setError("Password is required");
            this.textPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            this.textPassword.setError("Password should be at least 6 characters");
            this.textPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()) {
                        startActivity(new Intent(LoginActivity.this, ProfileActivity.class));
                    } else {
                        // user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this, "Please verify your email first before logging in", Toast.LENGTH_LONG).show();
                    }


                } else {
                    Toast.makeText(LoginActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}