package com.example.homedork.Calendar;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalenderApi {

    public static ArrayList<Events> eventList = new ArrayList<>();


    public void read() {
        FirebaseDatabase.getInstance().getReference("Events")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    Events events = snapshot1.getValue(Events.class);
                    events.setEventID(snapshot1.getKey());
                    String[] array = events.getEventDate().split(" ");
                    String eventt = array[1] + " " + array[2] + " " + array[3];
                    events.setEventDate(eventt);
                    eventList.add(events);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("datosdb", "loadPost:onCancelled");

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static ArrayList<Events> eventsForDate(LocalDate date) {
        ArrayList<Events> events = new ArrayList<>();

        for (Events event : eventList) {
            String[] array = event.getEventDate().split(" ");
            String eventt = array[0] + " " + array[1] + " " + array[2];
            event.setEventDate(eventt);
            int year = Integer.parseInt(array[2]);
            String month = array[1];
            int day = Integer.parseInt(array[0]);
            LocalDate date1 = LocalDate.of(year, monthInNumber(month), day);
            if (date1.equals(date))
                events.add(event);
        }

        return events;
    }

    public static int monthInNumber(String month) {
        if (month.equalsIgnoreCase("January")) {
            return 1;
        }
        if (month.equalsIgnoreCase("February")) {
            return 2;
        }
        if (month.equalsIgnoreCase("March")) {
            return 3;
        }
        if (month.equalsIgnoreCase("April")) {
            return 4;
        }
        if (month.equalsIgnoreCase("May")) {
            return 5;
        }
        if (month.equalsIgnoreCase("June")) {
            return 6;
        }
        if (month.equalsIgnoreCase("July")) {
            return 7;
        }
        if (month.equalsIgnoreCase("August")) {
            return 8;
        }
        if (month.equalsIgnoreCase("September")) {
            return 9;
        }
        if (month.equalsIgnoreCase("October")) {
            return 10;
        }
        if (month.equalsIgnoreCase("November")) {
            return 11;
        }
        if (month.equalsIgnoreCase("December")) {
            return 12;
        }
        return 0;

    }

}
