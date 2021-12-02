package com.example.homedork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.homedork.api.user.api.UserRequests;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Main Activity", Toast.LENGTH_SHORT).show();

    }
}