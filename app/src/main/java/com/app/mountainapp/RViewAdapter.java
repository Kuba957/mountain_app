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
        dataObjectHolder.shelter_phone.setText(list_shelter.get(position).getPhoneNumber());
        Shelter shelter = list_shelter.get(position);
        dataObjectHolder.bind(shelter);

        dataObjectHolder.shelter_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                boolean expanded = shelter.isExpanded();
                shelter.setExpanded(!expanded);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_shelter.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder{
        private TextView shelter_name;
        private ImageView shelter_image;
        private TextView shelter_phone;
        private View shelter_detail;

        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);
            this.shelter_name = itemView.findViewById(R.id.shelter_name);
            this.shelter_image = itemView.findViewById(R.id.shelter_image);
            this.shelter_phone = itemView.findViewById(R.id.shelter_detail_phone);
            this.shelter_detail = itemView.findViewById(R.id.shelter_detail);
        }

        private void bind(Shelter shelter){
            boolean expanded = shelter.isExpanded();
            shelter_detail.setVisibility(expanded ? View.VISIBLE : View.GONE);
        }
    }
}
