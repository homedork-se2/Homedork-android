package com.example.homedork.Fun;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.example.homedork.Calendar.CalendarMain;
import com.example.homedork.Dashbord2;
import com.example.homedork.Profile;
import com.example.homedork.R;
import com.example.homedork.Settings.MainVibrate;
import com.example.homedork.Settings.SettingsActivity;
import com.example.homedork.voice_command;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FunMenu extends AppCompatActivity {

    private ImageButton tictac,disco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_Homedork); // Default app theme
        }
        setContentView(R.layout.activity_fun_menu);

        tictac=findViewById(R.id.tictac);
        tictac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunMenu.this,Game.class);
                startActivity(intent);
            }
        });

        disco=findViewById(R.id.disco);
        disco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FunMenu.this,DiscoMoodActivity.class);
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
        bottomNavigationView.setSelectedItemId(R.id.navigation_game);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_game:
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
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}