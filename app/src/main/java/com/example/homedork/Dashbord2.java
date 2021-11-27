package com.example.homedork;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.Calendar.CalendarMain;
import com.example.homedork.Settings.MainVibrate;
import com.example.homedork.api.fan.api.FanRequests;
import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.dashboard.DashboardService;
import com.google.firebase.auth.FirebaseAuth;

public class Dashbord2 extends AppCompatActivity  {
    private Button logout, btn, cal, settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        populateDeviceScroller();

        btn = findViewById(R.id.btnn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashbord2.this, Game.class);
                startActivity(intent);
            }
        });

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Dashbord2.this, MainVibrate.class);
                startActivity(intent);
            }
        });


        cal = findViewById(R.id.calendar);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashbord2.this, CalendarMain.class);
                startActivity(intent);
            }
        });

    }


    public void populateDeviceScroller(){
        DashboardService dashboardService = new DashboardService();
        String uid = FirebaseAuth.getInstance().getUid();
        LampRequests lampRequests = new LampRequests();
        FanRequests fanRequests = new FanRequests();
        lampRequests.getUserLamps(this.findViewById(R.id.c), new ImageView(this), this,  "123");
        fanRequests.getFans(this.findViewById(R.id.c), new ImageView(this), this,  "123");



/*
        for (int i = 0; i < lamp.size(); i++) {         //TODO: find a way to change lamp id to be int, you cant use UUID to generate that for you. 
            dashboardService.addDynamicRangeSlide(this.findViewById(R.id.c), new ImageView(this), this, Integer.parseInt(lamp.get(i).getId()), uid);
        }

 */
        //dashboardService.addDynamicSwitchButton(this.findViewById(R.id.c), new ImageView(this), this, R.drawable.ic_baseline_highlight_24);
    }
}