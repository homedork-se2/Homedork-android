package com.example.homedork;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedork.adapters.DevicesAdapter;
import com.example.homedork.models.Mood;

import java.util.ArrayList;
import java.util.List;

public class EditMoodActivity extends AppCompatActivity {

    int position;

    List<String> devicesList = new ArrayList<>();
    List<String> selectedDevicesList = new ArrayList<>();

    DevicesAdapter adapter;

    Button btnSave;
    ImageButton btnAddNewDevice;
    RecyclerView rvDevices;
    EditText etMoodTitle;

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mood);

        initViews();
        initRecyclerView();
        getIntentData();
        setData();
        getDevicesFromServer();
    }

    private void getIntentData(){
        position = getIntent().getIntExtra("position", 0);
    }

    private void setData(){
        etMoodTitle.setText(MoodsActivity.moodList.get(position).getTitle());
        selectedDevicesList.addAll(MoodsActivity.moodList.get(position).getDevices());
    }

    private void initViews(){
        btnSave = findViewById(R.id.btnSave);
        btnAddNewDevice = findViewById(R.id.btnAddNewDevice);
        rvDevices = findViewById(R.id.rvDevices);
        etMoodTitle = findViewById(R.id.etMoodTitle);
    }

    private void initListeners(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etMoodTitle.getText().toString().isEmpty()){
                    Toast.makeText(EditMoodActivity.this, "Please enter mood title", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(selectedDevicesList.isEmpty()){
                    Toast.makeText(EditMoodActivity.this, "Please select at least one device", Toast.LENGTH_SHORT).show();
                    return;
                }

                updateMoodOnServer();
            }
        });

        btnAddNewDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.show();
            }
        });
    }

    private void getDevicesFromServer(){
        //Replace these dummy data with API call

        devicesList.add("Lamp");
        devicesList.add("Curtains");
        devicesList.add("Television");
        devicesList.add("Computer");
        devicesList.add("Mobile");

        initDevicesDialog();
        initListeners();
    }

    private void initDevicesDialog(){
        builder = new AlertDialog.Builder(EditMoodActivity.this);
        builder.setTitle("Select Device");

        builder.setItems(devicesList.toArray(new String[devicesList.size()]), (dialog, which) -> {
            selectedDevicesList.add(devicesList.get(which));
            adapter.notifyDataSetChanged();
        });
    }

    private void initRecyclerView(){
        adapter = new DevicesAdapter(this, selectedDevicesList);
        rvDevices.setLayoutManager(new LinearLayoutManager(this));
        rvDevices.setAdapter(adapter);
    }

    private void updateMoodOnServer(){
        // replace this code with saving mood on server
        MoodsActivity.moodList.set(position, new Mood(etMoodTitle.getText().toString(), selectedDevicesList));
        finish();
    }
}