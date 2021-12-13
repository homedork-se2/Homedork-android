package com.example.homedork.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homedork.Mood.EditMoodActivity;
import com.example.homedork.R;
import com.example.homedork.models.Mood;

import java.util.List;

public class MoodsAdapter extends RecyclerView.Adapter<MoodsAdapter.MoodsHolder> {

    private final String TAG = MoodsAdapter.class.getSimpleName();
    private Activity mContext;
    private List<Mood> moodList;

    public MoodsAdapter(Activity mContext, List<Mood> moodList) {
        this.mContext = mContext;
        this.moodList = moodList;
    }

    @NonNull
    @Override
    public MoodsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layout_mood_item, parent, false);
        return new MoodsHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodsHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.tvMoodTitle.setText(moodList.get(position).getTitle());
        holder.tvMoodStatus.setText(moodList.get(position).getStatus()? "On" : "Off");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moodList.get(position).setStatus(!moodList.get(position).getStatus());
                notifyDataSetChanged();
            }
        });

        holder.ibEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditMoodActivity.class);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return moodList.size();
    }

    public static class MoodsHolder extends RecyclerView.ViewHolder{

        TextView tvMoodTitle;
        TextView tvMoodStatus;
        ImageButton ibEdit;

        public MoodsHolder(View itemView) {
            super(itemView);
            tvMoodTitle = itemView.findViewById(R.id.tvMoodTitle);
            tvMoodStatus = itemView.findViewById(R.id.tvStatus);
            ibEdit = itemView.findViewById(R.id.ibEdit);
        }
    }
}
