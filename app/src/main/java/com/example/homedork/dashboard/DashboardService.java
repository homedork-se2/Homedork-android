package com.example.homedork.dashboard;

import static com.example.homedork.R.animator.mtrl_btn_state_list_anim;
import static com.example.homedork.R.animator.nav_default_exit_anim;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    @SuppressLint("WrongConstant")
    public void addDynamicSwitchButton(LinearLayout layout, Context context, int id, String userId, Lamp lamp) {
        //Five switchMaterial
        //View view = View.inflate(context, "", false);
        TextView textView = new TextView(context);
        RelativeLayout l = new RelativeLayout(context);
        RangeSlider rangeSlider = new RangeSlider(context);

        ImageView imageView = new ImageView(context);
        //Button switchMaterial = new Button(context);
        SwitchMaterial switchMaterial = new SwitchMaterial(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.dashboard,"", false);
        rangeSlider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        switchMaterial.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        l.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        textView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) switchMaterial.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        RelativeLayout.LayoutParams paramsText = (RelativeLayout.LayoutParams) textView.getLayoutParams();

        RelativeLayout.LayoutParams paramss = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();


        textView.setText("Control the lamp " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView.setTextSize(17);


        l.setBackground(context.getDrawable(R.drawable.dynamic_design));
        l.getLayoutParams().height = 400;
        params1.leftMargin = 25;

        params1.height = 400;
        params1.width = 1000;

        //params.addRule(RelativeLayout.ALIGN_RIGHT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.topMargin = 40;
        params.setMarginEnd(20);
        params.rightMargin = 20;
        switchMaterial.setLayoutParams(params);
        params.width = 550;
        imageView.setImageResource(R.drawable.lamp);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(1, 35, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 120;
        imageView.getLayoutParams().width = 170;

        l.addView(textView);
        l.addView(imageView);
        l.addView(switchMaterial, imageView.getId());
        l.addView(rangeSlider);
        layout.addView(l);


        paramss.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        paramss.addRule(RelativeLayout.ALIGN_PARENT_END);
        paramss.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        paramss.topMargin = 200;
        paramss.setMarginEnd(190);
        paramss.rightMargin = 20;
        paramss.leftMargin = 160;
        rangeSlider.setLayoutParams(paramss);
        paramss.width = 550;

        rangeSliderToServerLight(rangeSlider, String.valueOf(lamp.id));
        switchButton(switchMaterial, String.valueOf(lamp.id));

    }

    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Fan fan) {
        SwitchMaterial switchMaterial = new SwitchMaterial(context);

        TextView textView2 = new TextView(context);


        //Five switchMaterial
        //View view = View.inflate(context, "", false);
        RelativeLayout l = new RelativeLayout(context);

        ImageView imageView = new ImageView(context);
        //Button switchMaterial = new Button(context);
        RangeSlider rangeSlider = new RangeSlider(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.dashboard,"", false);
        textView2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        switchMaterial.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

        rangeSlider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

        l.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams paramsss = (RelativeLayout.LayoutParams) switchMaterial.getLayoutParams();

        RelativeLayout.LayoutParams paramsText = (RelativeLayout.LayoutParams) textView2.getLayoutParams();


        textView2.setText("Control the fan " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView2.setTextSize(17);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 400;
        params1.width = 1000;
        l.setBackground(context.getDrawable(R.drawable.dynamic_design));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);


        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        params.addRule(RelativeLayout.ALIGN_PARENT_END);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        params.topMargin = 200;
        params.setMarginEnd(190);
        params.rightMargin = 20;
        params.leftMargin = 160;
        rangeSlider.setLayoutParams(params);
        params.width = 550;


        paramsss.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        paramsss.addRule(RelativeLayout.ALIGN_PARENT_END);
        paramsss.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        paramsss.topMargin = 40;
        paramsss.setMarginEnd(20);
        paramsss.rightMargin = 20;
        switchMaterial.setLayoutParams(paramsss);
        paramsss.width = 550;


        imageView.setImageResource(R.drawable.ac);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(35, 35, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);


        rangeSliderToServerLight(rangeSlider, String.valueOf(fan.id));
        switchButton(switchMaterial, String.valueOf(fan.id));
    }


    public void rangeSliderToServerLight(RangeSlider switchMaterial, String fanId) {
        switchMaterial.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                FanRequests fanRequests = new FanRequests();
                List<Float> slideValues = slider.getValues();
                fanRequests.slideFanValue("123", fanId, String.valueOf(slideValues.get(0)));
            }
        });
    }

    public void switchButton(SwitchMaterial switchMaterial, String buttonId) {


        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LampRequests lampRequests = new LampRequests();
                if (isChecked) {
                    lampRequests.turnLampOn(FirebaseAuth.getInstance().getUid(), buttonId);
                }

                if (!isChecked) {
                    lampRequests.turnLampOff(FirebaseAuth.getInstance().getUid(), buttonId);
                }
            }
        });

    }
}
