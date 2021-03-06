package com.example.homedork.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.homedork.R;
import com.example.homedork.api.alarm.api.AlarmRequests;
import com.example.homedork.api.curtain.api.CurtainRequests;
import com.example.homedork.api.fan.api.FanRequests;
import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.api.model.device.Alarm;
import com.example.homedork.api.model.device.Curtain;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.api.model.device.Thermometer;
import com.example.homedork.api.model.device.Window;
import com.example.homedork.api.thermometer.api.ThermometerRequests;
import com.example.homedork.api.window.api.WindowRequest;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DashboardService {
    private LampRequests lampRequests = new LampRequests();
    private FanRequests fanRequests = new FanRequests();
    private ThermometerRequests thermometerRequests = new ThermometerRequests();

    @SuppressLint({"WrongConstant", "ResourceAsColor"})
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



        l.setBackground(context.getDrawable(R.drawable.fan_back));
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
        lp.setMargins(20, 35, lp.leftMargin, lp.bottomMargin);
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

        rangeSliderToServerLight(rangeSlider, lamp.getId(),"Lamp");
       // rangeSliderToServerLight(rangeSlider, String.valueOf(lamp.id));
       // switchButton(switchMaterial, String.valueOf(lamp.id));
        switchButton(switchMaterial, lamp.id, "Lamp");
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
        l.setBackground(context.getDrawable(R.drawable.fan_back));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);

     /*   if (context.equals(true)){

            rangeSlider.setVisibility(View.VISIBLE);

            params.topMargin = 30;
            params.setMarginEnd(190);
            params.rightMargin = 20;
            params.leftMargin = 160;
            rangeSlider.setLayoutParams(params);
            params.width = 550;
        }else {
            rangeSlider.setVisibility(View.GONE);
        }

      */


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
        lp.setMargins(55, 60, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);

        rangeSliderToServerLight(rangeSlider, fan.getId(),"Fan");
      //  rangeSliderToServerLight(rangeSlider, String.valueOf(fan.id));
        //switchButton(switchMaterial, String.valueOf(fan.id));
        switchButton(switchMaterial, fan.id, "Fan");
    }


    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Thermometer thermometer) {
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


        textView2.setText("Control the Tempreture " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView2.setTextSize(17);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 400;
        params1.width = 1000;
        l.setBackground(context.getDrawable(R.drawable.fan_back));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);

     /*   if (context.equals(true)){

            rangeSlider.setVisibility(View.VISIBLE);

            params.topMargin = 30;
            params.setMarginEnd(190);
            params.rightMargin = 20;
            params.leftMargin = 160;
            rangeSlider.setLayoutParams(params);
            params.width = 550;
        }else {
            rangeSlider.setVisibility(View.GONE);
        }

      */


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


        imageView.setImageResource(R.drawable.thermo);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(55, 60, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);

        rangeSliderToServerLight(rangeSlider, thermometer.getId(),"Thermometer");
       // rangeSliderToServerLight(rangeSlider, String.valueOf(thermometer.id));
        //switchButton(switchMaterial, String.valueOf(thermometer.id));
        switchButton(switchMaterial, thermometer.id, "Thermometer");
    }

    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Curtain curtain) {
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


        textView2.setText("Control the curtain " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView2.setTextSize(17);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 400;
        params1.width = 1000;
        l.setBackground(context.getDrawable(R.drawable.fan_back));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);

     /*   if (context.equals(true)){

            rangeSlider.setVisibility(View.VISIBLE);

            params.topMargin = 30;
            params.setMarginEnd(190);
            params.rightMargin = 20;
            params.leftMargin = 160;
            rangeSlider.setLayoutParams(params);
            params.width = 550;
        }else {
            rangeSlider.setVisibility(View.GONE);
        }

      */


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


        imageView.setImageResource(R.drawable.curtain);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(55, 60, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);


       rangeSliderToServerLight(rangeSlider, curtain.getId(),"Curtain");
       // switchButton(switchMaterial, String.valueOf(curtain.id));
        switchButton(switchMaterial, curtain.id, "Curtain");
    }


    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Alarm alarm) {
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


        textView2.setText("Control the alarm " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView2.setTextSize(17);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 400;
        params1.width = 1000;
        l.setBackground(context.getDrawable(R.drawable.fan_back));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);

     /*   if (context.equals(true)){

            rangeSlider.setVisibility(View.VISIBLE);

            params.topMargin = 30;
            params.setMarginEnd(190);
            params.rightMargin = 20;
            params.leftMargin = 160;
            rangeSlider.setLayoutParams(params);
            params.width = 550;
        }else {
            rangeSlider.setVisibility(View.GONE);
        }

      */


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


        imageView.setImageResource(R.drawable.alarm);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(55, 60, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);


        rangeSliderToServerLight(rangeSlider, alarm.getId(), "Alarm");
        //switchButton(switchMaterial, String.valueOf(alarm.id));
        switchButton(switchMaterial, alarm.id, "Alarm");
    }



    public void addDynamicRangeSlide(LinearLayout layout, Context context, int id, String userId, Window window) {
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


        textView2.setText("Control the window " + String.valueOf(id));
        paramsText.topMargin = 70;
        paramsText.rightMargin = 20;
        paramsText.leftMargin = 280;
        textView2.setTextSize(17);


        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) l.getLayoutParams();
        params1.height = 400;
        params1.width = 1000;
        l.setBackground(context.getDrawable(R.drawable.fan_back));
        params1.leftMargin = 25;
        // params.addRule(RelativeLayout.ALIGN_RIGHT);

     /*   if (context.equals(true)){

            rangeSlider.setVisibility(View.VISIBLE);

            params.topMargin = 30;
            params.setMarginEnd(190);
            params.rightMargin = 20;
            params.leftMargin = 160;
            rangeSlider.setLayoutParams(params);
            params.width = 550;
        }else {
            rangeSlider.setVisibility(View.GONE);
        }

      */


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


        imageView.setImageResource(R.drawable.window);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(55, 60, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 100;
        imageView.getLayoutParams().width = 100;

        l.addView(imageView);
        l.addView(textView2);
        l.addView(rangeSlider, imageView.getId());
        l.addView(switchMaterial);
        layout.addView(l);


        rangeSliderToServerLight(rangeSlider, window.getId(), "Window");
        //switchButton(switchMaterial, String.valueOf(alarm.id));
        switchButton(switchMaterial, window.id, "Window");
    }




    public void rangeSliderToServerLight(RangeSlider switchMaterial, String deviceId, String nameOfDevice) {
        switchMaterial.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {

                if (nameOfDevice.equals("Fan")) {
                    FanRequests fanRequests = new FanRequests();
                    List<Float> slideValues = slider.getValues();
                    fanRequests.slideFanValue("123", deviceId, String.valueOf(slideValues.get(0)));
                }
                if (nameOfDevice.equals("Alarm")) {
                    AlarmRequests alarmRequests = new AlarmRequests();
                    List<Float> slideAlarmValue = slider.getValues();
                    alarmRequests.slideAlarmValue("123", deviceId, String.valueOf(slideAlarmValue.get(0)));
                }

                if (nameOfDevice.equals("Lamp")) {
                    LampRequests lampRequests = new LampRequests();
                    List<Float> slideLampValue = slider.getValues();
                    lampRequests.slideLampValue("123", deviceId, Float.valueOf(String.valueOf(slideLampValue.get(0))));
                }

                if (nameOfDevice.equals("Window")) {
                    WindowRequest windowRequest = new WindowRequest();
                    List<Float> slideWindowValue = slider.getValues();
                    windowRequest.slideWindowValue("123", deviceId, Float.valueOf(String.valueOf(slideWindowValue.get(0))));
                }




                if (nameOfDevice.equals("Curtain")) {
                    CurtainRequests curtainRequests = new CurtainRequests();
                    List<Float> slideCurtainValue = slider.getValues();
                    curtainRequests.slideCurtainValue("123", deviceId, String.valueOf(slideCurtainValue.get(0)));
                }
                if (nameOfDevice.equals("Thermometer")) {
                    ThermometerRequests thermometerRequests = new ThermometerRequests();
                    List<Float> slideThermValue = slider.getValues();
                    thermometerRequests.slideThermValue("123", deviceId, String.valueOf(slideThermValue.get(0)));
                }
            }
        });
    }

    public void switchButton(SwitchMaterial switchMaterial, String buttonId,String nameOfDevice) {


        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (nameOfDevice.equals("Lamp")) {
                    LampRequests lampRequests = new LampRequests();
                    if (isChecked) {
                        lampRequests.turnLampOn("123", buttonId);
                    }

                    if (!isChecked) {
                        lampRequests.turnLampOff("123", buttonId);
                    }
                }
                if (nameOfDevice.equals("Fan")) {
                    FanRequests fanRequests = new FanRequests();
                    if (isChecked) {
                        fanRequests.turnFanOn("123", buttonId);
                    }

                    if (!isChecked) {
                        fanRequests.turnFanOff("123", buttonId);
                    }
                }

                if (nameOfDevice.equals("Window")) {
                    WindowRequest windowRequest = new WindowRequest();
                    if (isChecked) {
                        windowRequest.turnWindowOn("123", buttonId);
                    }

                    if (!isChecked) {
                        windowRequest.turnWindowOff("123", buttonId);
                    }
                }


                if (nameOfDevice.equals("Curtain")) {
                    CurtainRequests curtainRequests = new CurtainRequests();
                    if (isChecked) {
                        curtainRequests.turnCurtainOn("123", buttonId);
                    }

                    if (!isChecked) {
                        curtainRequests.turnCurtainOff("123", buttonId);
                    }
                }


                if (nameOfDevice.equals("Alarm")) {
                    AlarmRequests alarmRequests = new AlarmRequests();
                    if (isChecked) {
                        alarmRequests.turnAlarmOn("123", buttonId);
                    }

                    if (!isChecked) {
                        alarmRequests.turnAlarmOff("123", buttonId);
                    }
                }
                if (nameOfDevice.equals("Thermometer")) {
                    ThermometerRequests thermometerRequests = new ThermometerRequests();
                    if (isChecked) {
                        thermometerRequests.turnThermOn("123", buttonId);
                    }

                    if (!isChecked) {
                        thermometerRequests.turnThermOff("123", buttonId);
                    }
                }
            }
        });


    }
}
