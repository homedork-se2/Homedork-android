package com.example.homedork.Calendar;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.homedork.R;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.O)

public class EventAdapter extends ArrayAdapter<Events> {

    public EventAdapter(@NonNull Context context, List<Events> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Events event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);

        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);

        String eventTitle = event.getEventName() + " " + event.getEventTime();
        eventCellTV.setText(eventTitle);
        return convertView;
    }
}
