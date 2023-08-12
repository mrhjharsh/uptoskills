package com.example.uptoskills;

import static com.example.uptoskills.blogdatabase.date1;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
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

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {
    static List<String> name;
    static List<String>image_url;
    static List<String>content;
    static List<String>duration;
    static List<String>count_students;
    static List<String>rating;
    static List<String>price_rendered;
    static List<String>origin_price_rendered;
    static List<String>typeofprograme;

    Context context;
    public CustomAdapter2(Context context ) {
        this.context = context;
        this.name = new ArrayList<>();
        this.image_url = new ArrayList<>();
        this.duration = new ArrayList<>();
        this.count_students = new ArrayList<>();
        this.rating = new ArrayList<>();
        this.content = new ArrayList<>();
        this.price_rendered = new ArrayList<>();
        this.origin_price_rendered = new ArrayList<>();
        this.typeofprograme = new ArrayList<>();
        for (int i = 0; i < coursedatabase.name.size(); i++) {
            name.add(coursedatabase.name.get(i));
            image_url.add(coursedatabase.image_url.get(i));
            duration.add(coursedatabase.duration.get(i));
            count_students.add(coursedatabase.count_students.get(i));
            rating.add(coursedatabase.rating.get(i));
            content.add(coursedatabase.content.get(i));
            price_rendered.add(coursedatabase.price_rendered.get(i));
            origin_price_rendered.add(coursedatabase.origin_price_rendered.get(i));
            typeofprograme.add(coursedatabase.typeofprograme.get(i));
        }




    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_desgin2, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.coursename.setText(name.get(position));
        holder.rating.setText(rating.get(position));
        holder.money.setText(price_rendered.get(position));


        Glide.with(context).load(image_url.get(position)).listener(new RequestListener<Drawable>() {
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
        return coursedatabase.name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView coursename;
        TextView rating;
        TextView money;
        TextView uptoskills;

        ImageView img;
        ProgressBar p1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coursename = itemView.findViewById(R.id.CourseName);
            rating = itemView.findViewById(R.id.rating);
            money = itemView.findViewById(R.id.money);
            uptoskills = itemView.findViewById(R.id.videoLessonsTag);
            img = itemView.findViewById(R.id.courseImage);
            p1 = itemView.findViewById(R.id.progressBar);

        }
    }
}
