package com.example.homedork.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.homedork.R;
import com.example.homedork.api.fan.api.FanRequests;
import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.api.model.device.Lamp;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class DashboardService {
    private LampRequests lampRequests = new LampRequests();
    private FanRequests fanRequests = new FanRequests();
    public void addDynamicSwitchButton(LinearLayout layout,  Context context, int id, String userId, Lamp lamp) {
        //Five switchMaterial
        //View view = View.inflate(context, "", false);
        RelativeLayout l = new RelativeLayout(context);

        ImageView imageView = new ImageView(context);
        //Button switchMaterial = new Button(context);
        SwitchMaterial switchMaterial = new SwitchMaterial(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.dashboard,"", false);

        switchMaterial.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        l.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) switchMaterial.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 200;
        l.setBackgroundColor(context.getColor(R.color.browser_actions_bg_grey));
        //params.addRule(RelativeLayout.ALIGN_RIGHT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.topMargin = 30;
        params.setMarginEnd(20);
        params.rightMargin = 20;
        switchMaterial.setLayoutParams(params);
        params.width = 550;
        imageView.setImageResource(R.drawable.lamp);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(21, 35, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(switchMaterial, imageView.getId());
        layout.addView(l);


        //rangeSliderToServerLight(switchMaterial, String.valueOf(lamp.id));
        switchButton(switchMaterial, String.valueOf(lamp.id));
    }
    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Fan fan){
        //Five switchMaterial
        //View view = View.inflate(context, "", false);
        RelativeLayout l = new RelativeLayout(context);

        ImageView imageView = new ImageView(context);
        //Button switchMaterial = new Button(context);
        RangeSlider rangeSlider = new RangeSlider(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.dashboard,"", false);

        rangeSlider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        l.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
       imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

        RelativeLayout.LayoutParams params =  (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
            params1.height = 200;
        l.setBackgroundColor(context.getColor(R.color.browser_actions_bg_grey));
        //params.addRule(RelativeLayout.ALIGN_RIGHT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.topMargin = 30;
        params.setMarginEnd(20);
        params.rightMargin = 20;
        rangeSlider.setLayoutParams(params);
        params.width = 550;
        imageView.setImageResource(R.drawable.ac);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(21, 35, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(rangeSlider, imageView.getId());
        layout.addView(l);



        rangeSliderToServerLight(rangeSlider, String.valueOf(fan.id));
    }


    public void rangeSliderToServerLight(RangeSlider switchMaterial, String fanId){
        switchMaterial.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                FanRequests fanRequests = new FanRequests();
                List<Float> slideValues =  slider.getValues();
                fanRequests.slideFanValue("123", fanId, String.valueOf(slideValues.get(0)));
            }
        });
    }

    public void switchButton(SwitchMaterial switchMaterial, String buttonId){


        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LampRequests lampRequests = new LampRequests();
                if (isChecked) {
                    lampRequests.turnLampOn("123", buttonId);
                }

                if (!isChecked){
                    lampRequests.turnLampOff("123", buttonId);
                }
            }
        });

    }
}
