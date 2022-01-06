package com.example.homedork.Mood;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedork.R;
import com.example.homedork.adapters.DevicesAdapter;
import com.example.homedork.api.PersonlizedCommandsAPI;
import com.example.homedork.api.model.device.Alarm;
import com.example.homedork.api.model.device.Curtain;
import com.example.homedork.api.model.device.Fan;
import com.example.homedork.api.model.device.Lamp;
import com.example.homedork.api.model.device.Thermometer;
import com.example.homedork.api.model.device.Window;
import com.example.homedork.models.Mood;

import java.util.ArrayList;
import java.util.List;

public class AddMoodActivity extends AppCompatActivity {

    List<String> devicesList = new ArrayList<>();
    List<String> selectedDevicesList = new ArrayList<>();

    DevicesAdapter adapter;
PersonlizedCommandsAPI personlizedCommandsAPI = new PersonlizedCommandsAPI();
    Button btnSave;
    ImageButton btnAddNewDevice;
    RecyclerView rvDevices;
    EditText etMoodTitle;
   /*      List<Alarm> alarms = personlizedCommandsAPI.getAlarms("123");
    List<Curtain> curtains = personlizedCommandsAPI.getCurtains("123");
    List<Lamp> lamps = personlizedCommandsAPI.getLamp("123");
    List<Thermometer> thermometers = personlizedCommandsAPI.getThermometer("123");
    List<Window> windows= personlizedCommandsAPI.getWindow("123");
    List<Fan> fans=personlizedCommandsAPI.getFan("123");
    */
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.HighContrast); // When dark mode is enabled, we use the contrast theme
        } else {
            setTheme(R.style.Theme_Homedork); // Default app theme
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood2);

        initViews();
        initRecyclerView();
        getDevicesFromServer();
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
                    Toast.makeText(AddMoodActivity.this, "Please enter mood title", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(selectedDevicesList.isEmpty()){
                    Toast.makeText(AddMoodActivity.this, "Please select at least one device", Toast.LENGTH_SHORT).show();
                    return;
                }

                saveMoodOnServer();
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
        devicesList.add("Fan");
        devicesList.add("Curtains");
        devicesList.add("Alarm");
        devicesList.add("Thermometer");
        devicesList.add("Window");

        initDevicesDialog();
        initListeners();
    }

    private void initDevicesDialog(){
        builder = new AlertDialog.Builder(AddMoodActivity.this);
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

    private void saveMoodOnServer(){
        // replace this code with saving mood on server
        MoodsActivity.moodList.add(new Mood(etMoodTitle.getText().toString(), selectedDevicesList));
        finish();
    }

}