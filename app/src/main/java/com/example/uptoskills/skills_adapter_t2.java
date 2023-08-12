package com.example.uptoskills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uptoskills.ui.signout.resume_data;

import java.util.ArrayList;
import java.util.List;

public class skills_adapter_t2 extends RecyclerView.Adapter<skills_adapter_t2.ViewHolder> {
    List<String>skills;

    public skills_adapter_t2() {
        skills = new ArrayList<>(resume_data.skillss);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_skills_adaptert2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(skills.get(position));
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.skill);


        }
    }
}
