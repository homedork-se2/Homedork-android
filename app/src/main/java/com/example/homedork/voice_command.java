package com.example.homedork;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.example.homedork.Calendar.CalendarMain;
import com.example.homedork.Fun.FunMenu;
import com.example.homedork.Fun.Game;
import com.example.homedork.Settings.MainVibrate;
import com.example.homedork.Settings.SettingsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class voice_command extends AppCompatActivity {

    private ImageButton btnSpeak;
    private TextView tvText;
    protected static final int RESULT_SPEECH= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_Homedork); // Default app theme
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_command);

        tvText = findViewById(R.id.tvText);
        btnSpeak = findViewById(R.id.btnSpeak);
        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                    tvText.setText("");
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), "Sorry current device doesn't support Speech to Text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
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
                        return true;
                    case R.id.navigation_voice:

                        return true;
                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarMain.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_settings:
                        startActivity(new Intent(getApplicationContext(), MainVibrate.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
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
                    case R.id.navigation_dashboard:
                        startActivity(new Intent(getApplicationContext(), Dashbord2.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_voice:

                        return true;
                    case R.id.navigation_calendar:
                        startActivity(new Intent(getApplicationContext(), CalendarMain.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.navigation_settings:
                        startActivity(new Intent(getApplicationContext(), MainVibrate.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    tvText.setText(text.get(0));
                }
                if (tvText.getText().toString().contains("settings")) {
                    Intent intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                }
                if (tvText.getText().toString().contains("game")) {
                    Intent intent = new Intent(this, Game.class);
                    startActivity(intent);
                }
                break;
        }
    }
}