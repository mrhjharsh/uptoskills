package com.example.uptoskills;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.ViewHolder> {

    public CustomAdapter3(Context context) {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_desgin3, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.job.setText(jobdatabase.title.get(position));
        holder.location.setText(jobdatabase.location.get(position));
        holder.decription.setText(jobdatabase.outerdata.get(position));
        holder.posted.setText(jobdatabase.date.get(position).substring(0,10));
    }

    @Override
    public int getItemCount() {
        return jobdatabase.date.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView job;
        TextView location;
        TextView decription;
        TextView posted;

        ImageView img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            job = itemView.findViewById(R.id.job);
            location = itemView.findViewById(R.id.location);
            decription = itemView.findViewById(R.id.description);
            posted = itemView.findViewById(R.id.posted);
            img = itemView.findViewById(R.id.img);
        }
    }
}
