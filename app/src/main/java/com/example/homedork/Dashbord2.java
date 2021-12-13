package com.example.homedork;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.homedork.Calendar.CalendarMain;
import com.example.homedork.Mood.MoodsActivity;
import com.example.homedork.Settings.MainVibrate;
import com.example.homedork.api.fan.api.FanRequests;
import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.dashboard.DashboardService;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

public class Dashbord2 extends AppCompatActivity {
    private Button logout;
    FloatingActionButton Personalized;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.drawable.newback); // Default app theme
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        populateDeviceScroller();



        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_dashboard);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_game:
                        startActivity(new Intent(getApplicationContext(), Game.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_dashboard:

                        return true;
                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarMain.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navigation_settings:
                        startActivity(new Intent(getApplicationContext(), MainVibrate.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


        Personalized = findViewById(R.id.Personalized);
        Personalized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashbord2.this, MoodsActivity.class);
                startActivity(intent);
            }
        });


    }


    public void populateDeviceScroller() {
        DashboardService dashboardService = new DashboardService();
        String uid = FirebaseAuth.getInstance().getUid();
        LampRequests lampRequests = new LampRequests();
        FanRequests fanRequests = new FanRequests();
        lampRequests.getUserLamps(this.findViewById(R.id.c), new ImageView(this), this, "123");
        fanRequests.getFans(this.findViewById(R.id.c), new ImageView(this), this, "123");



/*
        for (int i = 0; i < lamp.size(); i++) {         //TODO: find a way to change lamp id to be int, you cant use UUID to generate that for you. 
            dashboardService.addDynamicRangeSlide(this.findViewById(R.id.c), new ImageView(this), this, Integer.parseInt(lamp.get(i).getId()), uid);
        }

 */
        //dashboardService.addDynamicSwitchButton(this.findViewById(R.id.c), new ImageView(this), this, R.drawable.ic_baseline_highlight_24);
    }
}