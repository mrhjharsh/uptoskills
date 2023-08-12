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

public class experience_adapter extends RecyclerView.Adapter<experience_adapter.ViewHolder> {
    List<String>positions;
    List<String>location;
    List<String>description;

    public experience_adapter() {
//        positions = new ArrayList<>(Arrays.asList("ANDROID developer","ANDROID developer","ANDROID developer"));
//        location = new ArrayList<>(Arrays.asList("ducat noida","ducat noida","ducat noida"));
//        description = new ArrayList<>(Arrays.asList("i have worked as android developer","i have worked as android developer","i have worked as android developer"));
        positions = new ArrayList<>(resume_data.exptitle);
        location = new ArrayList<>(resume_data.expcompany);
        description = new ArrayList<>(resume_data.expdescription);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_experience, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(positions.get(position));
        holder.location.setText(location.get(position));
        holder.desc.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return positions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView location;
        TextView desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.n1);
            desc = itemView.findViewById(R.id.n3);
            location = itemView.findViewById(R.id.n2);
        }
    }
}
