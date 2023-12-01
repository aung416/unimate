package com.example.unimate;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    String[] categories;
    int[] imgs;
     public MyAdapter(String[] categories, int[] imgs)
     {
         this.categories = categories;
         this.imgs = imgs;
     }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.single_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
         holder.category_name.setText(categories[position]);
         holder.imageView.setImageResource(imgs[position]);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (position == 0)
                 {
                     Intent intent = new Intent(view.getContext(), Attendence.class);
                     view.getContext().startActivity(intent);
                 }
             }
         });

    }

    @Override
    public int getItemCount() {
         return categories.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView category_name;
        private ImageView imageView;


        public MyViewHolder (@NonNull View itemView) {
            super(itemView);

            category_name =itemView.findViewById(R.id.card_name);
            imageView = itemView.findViewById(R.id.card_img);
        }
    }
}
