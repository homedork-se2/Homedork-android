package com.example.homedork.Fun;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

import android.annotation.SuppressLint;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.homedork.R;


public class DiscoMoodActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private Button blink;



    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.drawable.glass); // Default app theme
        }
        setContentView(R.layout.activity_disco_mood);



        textView1= (TextView) findViewById(R.id.textView1);
        textView2 =(TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);
        textView4 =(TextView) findViewById(R.id.textView4);
        textView5= (TextView) findViewById(R.id.textView5);
        textView6 =(TextView) findViewById(R.id.textView6);
        blink =(Button) findViewById(R.id.button);
        blink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manageBlinkEffect();
            }
        });
    }

    private void manageBlinkEffect() {
        ObjectAnimator animator1= ObjectAnimator.ofInt(textView1,"backgroundColor", Color.WHITE,Color.GREEN,Color.WHITE);

        animator1.setDuration(800);

        animator1.setEvaluator(new ArgbEvaluator());
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        animator1.setRepeatCount(Animation.INFINITE);
        animator1.start();

        ObjectAnimator animator2= ObjectAnimator.ofInt(textView2,"backgroundColor", Color.WHITE,Color.RED,Color.WHITE);

        animator2.setDuration(700);

        animator2.setEvaluator(new ArgbEvaluator());
        animator2.setRepeatMode(ValueAnimator.REVERSE);
        animator2.setRepeatCount(Animation.INFINITE);
        animator2.start();

        ObjectAnimator animator3= ObjectAnimator.ofInt(textView3,"backgroundColor", Color.WHITE,Color.MAGENTA,Color.WHITE);

        animator3.setDuration(600);

        animator3.setEvaluator(new ArgbEvaluator());
        animator3.setRepeatMode(ValueAnimator.REVERSE);
        animator3.setRepeatCount(Animation.INFINITE);
        animator3.start();

        ObjectAnimator animator4= ObjectAnimator.ofInt(textView4,"backgroundColor", Color.WHITE,Color.GREEN,Color.WHITE);

        animator4.setDuration(720);

        animator4.setEvaluator(new ArgbEvaluator());
        animator4.setRepeatMode(ValueAnimator.REVERSE);
        animator4.setRepeatCount(Animation.INFINITE);
        animator4.start();

        ObjectAnimator animator5= ObjectAnimator.ofInt(textView5,"backgroundColor", Color.WHITE,Color.BLUE,Color.WHITE);

        animator5.setDuration(650);

        animator5.setEvaluator(new ArgbEvaluator());
        animator5.setRepeatMode(ValueAnimator.REVERSE);
        animator5.setRepeatCount(Animation.INFINITE);
        animator5.start();

        ObjectAnimator animator6= ObjectAnimator.ofInt(textView6,"backgroundColor", Color.WHITE,Color.RED,Color.WHITE);

        animator6.setDuration(580);

        animator6.setEvaluator(new ArgbEvaluator());
        animator6.setRepeatMode(ValueAnimator.REVERSE);
        animator6.setRepeatCount(Animation.INFINITE);
        animator6.start();
    }
}