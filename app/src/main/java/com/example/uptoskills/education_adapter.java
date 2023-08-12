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

public class education_adapter extends RecyclerView.Adapter<education_adapter.ViewHolder> {
    List<String>institute;
    List<String>description;

    public education_adapter() {
        institute = new ArrayList<>(resume_data.schoolss);
        description = new ArrayList<>(resume_data.educationdetailss);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_education, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(institute.get(position));
        holder.desc.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return institute.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.n1);
            desc = itemView.findViewById(R.id.n2);
        }
    }
}
