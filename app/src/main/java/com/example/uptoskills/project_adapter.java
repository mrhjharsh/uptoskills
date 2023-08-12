package com.example.uptoskills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uptoskills.ui.signout.resume_data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class project_adapter extends RecyclerView.Adapter<project_adapter.ViewHolder> {
    List<String>name;
    List<String>link;
    List<String>description;

    public project_adapter() {
        name = new ArrayList<>(resume_data.namess);
        link = new ArrayList<>(resume_data.linkss);
        description = new ArrayList<>(resume_data.descriptionss);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_project, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(name.get(position));
        holder.link.setText(link.get(position));
        holder.desc.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView link;
        TextView desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.n1);
            desc = itemView.findViewById(R.id.n3);
            link = itemView.findViewById(R.id.n2);
        }
    }
}
