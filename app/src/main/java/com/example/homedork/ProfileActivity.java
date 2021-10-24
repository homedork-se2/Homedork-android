package com.example.homedork;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.dashboard.DashboardService;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        populateDeviceScroller();

    }

    public void populateDeviceScroller(){
        DashboardService dashboardService = new DashboardService();
        String uid = FirebaseAuth.getInstance().getUid();
        LampRequests lampRequests = new LampRequests();
        lampRequests.getUserLamps(this.findViewById(R.id.c), new ImageView(this), this,  "123");


/*
        for (int i = 0; i < lamp.size(); i++) {         //TODO: find a way to change lamp id to be int, you cant use UUID to generate that for you. 
            dashboardService.addDynamicRangeSlide(this.findViewById(R.id.c), new ImageView(this), this, Integer.parseInt(lamp.get(i).getId()), uid);
        }

 */
        //dashboardService.addDynamicSwitchButton(this.findViewById(R.id.c), new ImageView(this), this, R.drawable.ic_baseline_highlight_24);
    }
}