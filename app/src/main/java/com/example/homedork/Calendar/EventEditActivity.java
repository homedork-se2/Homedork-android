package com.example.homedork.Calendar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homedork.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalTime;
@RequiresApi(api = Build.VERSION_CODES.O)
public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET,timee;
    private TextView eventDateTV, eventTimeTV, eventIDd;
    private FirebaseAuth mAuth;
    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        timee = findViewById(R.id.timee);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);

    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString().trim();
        String eventDate = eventDateTV.getText().toString().trim();
        String eventTime = eventTimeTV.getText().toString().trim();

        Event newEvent = new Event(eventName, CalendarUtils.selectedDate, time);
        Event.eventsList.add(newEvent);



        System.out.println(mAuth);


        Events event = new Events(eventName,eventDate,eventTime);
        System.out.println(FirebaseDatabase.getInstance());
        System.out.println(FirebaseDatabase.getInstance().getReference("Events")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()));
        System.out.println(FirebaseAuth.getInstance().getCurrentUser().getUid());

        System.out.println("HANI HANI HANI HANI HANI HANI");


        FirebaseDatabase.getInstance().getReference("Events")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                FirebaseUser event = FirebaseAuth.getInstance().getCurrentUser();
                if (task.isSuccessful()) {
                    System.out.println(event.getUid());
                    System.out.println(event);
                    Toast.makeText(EventEditActivity.this, "Event has been added", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(EventEditActivity.this, CalendarMain.class));
                } else
                    Toast.makeText(EventEditActivity.this, "Failed to add event! Try again!", Toast.LENGTH_LONG).show();

            }
        });



        finish();
    }

}
