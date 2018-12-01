package com.app.mountainapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.mountainapp.database.Shelter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.DataObjectHolder>{
    private Context context;
    private ArrayList<Shelter>  list_shelter;

    public RViewAdapter(Context context, ArrayList<Shelter> list_shelter) {
        this.context = context;
        this.list_shelter = list_shelter;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.shelter_view,viewGroup,false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataObjectHolder dataObjectHolder, int position) {
        dataObjectHolder.shelter_name.setText(list_shelter.get(position).getShelter_name());
        Glide.with(context).load(list_shelter.get(position).getShelter_image()).into(dataObjectHolder.shelter_image);
    }

    @Override
    public int getItemCount() {
        return list_shelter.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder{
        private TextView shelter_name;
        private ImageView shelter_image;

        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);
            this.shelter_name = itemView.findViewById(R.id.shelter_name);
            this.shelter_image = itemView.findViewById(R.id.shelter_image);
        }
    }
}
