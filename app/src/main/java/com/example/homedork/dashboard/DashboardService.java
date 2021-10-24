package com.example.homedork.dashboard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.homedork.R;
import com.example.homedork.api.lamp.api.LampRequests;
import com.example.homedork.api.model.device.Lamp;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class DashboardService {
    private LampRequests lampRequests = new LampRequests();
    public void addDynamicSwitchButton(LinearLayout layout, ImageView imageView, Context context, int id){
        //Five button
        //View view = View.inflate(context, "", false);
        RelativeLayout l = new RelativeLayout(context);
        SwitchMaterial button = new SwitchMaterial(context);
        button.setText("Button");
        button.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params =  (RelativeLayout.LayoutParams) button.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        button.setLayoutParams(params);
        imageView.setImageResource(R.drawable.ic_baseline_highlight_24);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(21, 17, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 64;
        imageView.getLayoutParams().width = 64;
        l.addView(imageView);
        l.addView(button);

        layout.addView(l);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void addDynamicRangeSlide(LinearLayout layout, ImageView imageView, Context context, int id, String userId, Lamp lamp){
        //Five button
        //View view = View.inflate(context, "", false);
        RelativeLayout l = new RelativeLayout(context);


        //Button button = new Button(context);
        RangeSlider rangeSlider = new RangeSlider(context);

        rangeSlider.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        l.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params =  (RelativeLayout.LayoutParams) rangeSlider.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_RIGHT);
        rangeSlider.setLayoutParams(params);
        imageView.setImageResource(R.drawable.ic_baseline_highlight_24);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(21, 17, lp.leftMargin, lp.bottomMargin);
        imageView.setLayoutParams(lp);
        imageView.getLayoutParams().height = 64;
        imageView.getLayoutParams().width = 64;
        //l.addView(imageView);
        l.addView(rangeSlider);

        layout.addView(l);


        rangeSliderToServer(rangeSlider, String.valueOf(lamp.id));
    }


    public void rangeSliderToServer(RangeSlider rangeSlider, String lampId){
        rangeSlider.addOnChangeListener(new RangeSlider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull RangeSlider slider, float value, boolean fromUser) {
                LampRequests lampRequests = new LampRequests();
                List<Float> slideValues =  slider.getValues();
                lampRequests.slideLampValue("123", lampId, slideValues.get(0));
            }
        });
    }
}
