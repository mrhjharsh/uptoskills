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

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
     List<String>date1;
     List<String>url1 ;
     List<String>description1;
     List<String>title1;
Context context;
int ss =0;
    CustomAdapter(Context context,int s, int e) {
        this.context = context;
        this.date1 = new ArrayList<>();
        ss = s;
        this.url1 = new ArrayList<>();
        this.description1 = new ArrayList<>();
        this.title1 = new ArrayList<>();
        for (int i = s; i < e; i++) {
            date1.add(blogdatabase.date1.get(i));
            url1.add(blogdatabase.url1.get(i));
            description1.add(blogdatabase.description1.get(i));
            title1.add(blogdatabase.title1.get(i));
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_design, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(title1.get(position));
        Glide.with(context).load(url1.get(position)).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.p1.setVisibility(View.INVISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.p1.setVisibility(View.INVISIBLE);
                return false;
            }
        }).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return date1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        ImageView img;
        ProgressBar p1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.image);
            p1 = itemView.findViewById(R.id.progressBar);

        }
    }
}
