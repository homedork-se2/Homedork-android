package com.example.homedork.Mood;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedork.R;
import com.example.homedork.adapters.MoodsAdapter;
import com.example.homedork.models.Mood;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MoodsActivity extends AppCompatActivity {

    FloatingActionButton addMoodBtn;
    RecyclerView recyclerView;
    MoodsAdapter adapter;

    public static List<Mood> moodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_Homedork); // Default app theme
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods2);

        addMoodBtn = findViewById(R.id.addMoodBtn);
        addMoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoodsActivity.this, AddMoodActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.rvMoods);
        initRecyclerView();

    }

    private void initRecyclerView(){
        adapter = new MoodsAdapter(MoodsActivity.this, moodList);
        recyclerView.setLayoutManager(new GridLayoutManager(MoodsActivity.this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void initListeners(){

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}