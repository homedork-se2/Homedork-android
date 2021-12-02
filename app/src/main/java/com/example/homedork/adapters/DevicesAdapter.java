package com.example.homedork.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedork.R;

import java.util.List;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.DevicesHolder> {

    private final String TAG = DevicesAdapter.class.getSimpleName();
    private Activity mContext;
    private List<String> deviceList;

    public DevicesAdapter(Activity mContext, List<String> deviceList) {
        this.mContext = mContext;
        this.deviceList = deviceList;
    }

    @NonNull
    @Override
    public DevicesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_device_item, parent, false);
        return new DevicesHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull DevicesHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvDevice.setText(deviceList.get(position));

        holder.ibDeleteDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deviceList.remove(position);
                notifyDataSetChanged();

            }
        });
    }


    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    public static class DevicesHolder extends RecyclerView.ViewHolder{

        TextView tvDevice;
        ImageButton ibDeleteDevice;

        public DevicesHolder(View itemView) {
            super(itemView);
            tvDevice = itemView.findViewById(R.id.tvDevice);
            ibDeleteDevice = itemView.findViewById(R.id.iBDeleteDevice);
        }
    }
}
