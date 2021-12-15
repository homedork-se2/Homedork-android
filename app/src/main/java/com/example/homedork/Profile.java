package com.example.homedork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.homedork.Calendar.CalendarMain;
import com.example.homedork.Fun.FunMenu;
import com.example.homedork.Settings.MainVibrate;
import com.example.homedork.Settings.SettingsActivity;
import com.example.homedork.signup.LoginActivity;
import com.example.homedork.signup.ResetPasswordActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    Button changePass, settings, signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_Homedork); // Default app theme
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        changePass = findViewById(R.id.changePass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, ResetPasswordActivity.class);
                startActivity(intent);
            }
        });

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        signout = findViewById(R.id.signout);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Profile.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        Toolbar toolbar= findViewById(R.id.nav_viewside);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_game:
                        startActivity(new Intent(getApplicationContext(), FunMenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_voice:
                        startActivity(new Intent(getApplicationContext(), voice_command.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(), Dashbord2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarMain.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_settings:
                        return true;
                }
                return false;
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_settings);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_game:
                        startActivity(new Intent(getApplicationContext(), FunMenu.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(), Dashbord2.class));
                        overridePendingTransition(0,0);
                        return  true;
                    case R.id.navigation_voice:
                        startActivity(new Intent(getApplicationContext(), voice_command.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarMain.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_settings:

                        return true;
                }
                return false;
            }
        });
    }
}