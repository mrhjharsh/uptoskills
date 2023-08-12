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

public class archievements_adapter extends RecyclerView.Adapter<archievements_adapter.ViewHolder> {
    List<String> namesss;
    List<String> descriptionsss;

    public archievements_adapter() {
        namesss = new ArrayList<>(resume_data.archievement_titless);
        descriptionsss = new ArrayList<>(resume_data.archievement_descriptionss);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_archievement, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(namesss.get(position));
        holder.desc.setText(descriptionsss.get(position));
    }

    @Override
    public int getItemCount() {
        return namesss.size();
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
