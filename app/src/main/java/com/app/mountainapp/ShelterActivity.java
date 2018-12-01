package com.app.mountainapp;


import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.app.mountainapp.database.DatabaseHelper;
import com.app.mountainapp.database.Shelter;

import java.util.ArrayList;

public class ShelterActivity extends AppCompatActivity {

    DatabaseHelper db;
    private RecyclerView recyclerView;
    private RViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.shelter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        db = new DatabaseHelper(this);

        this.recyclerView = findViewById(R.id.recycler_view);
        this.layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        this.adapter = new RViewAdapter(getBaseContext(),getShelterName());
        recyclerView.setAdapter(adapter);


    }

    private ArrayList<Shelter> getShelterName() {
        ArrayList<Shelter> listName = new ArrayList<Shelter>();
        Bitmap bt = null;
        Cursor cursor = db.viewName();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data to show",Toast.LENGTH_SHORT).show();
            return null;
        }
        else{
            while(cursor.moveToNext()){
                String name = cursor.getString(0);
                byte[] image = cursor.getBlob(1);
                bt = BitmapFactory.decodeByteArray(image,0,image.length);
                Shelter shelter = new Shelter(name,bt);
                listName.add(shelter);
            }
            cursor.close();
            return listName;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
