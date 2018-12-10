package com.app.mountainapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class TrailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.trail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onMapOpen(View view) {
        int choose = view.getId();
        Intent intent;
        switch(choose){
            case R.id.trail_card:
                intent = new Intent(this,TrailMapActivity.class);
                startActivity(intent);
                break;
            case R.id.cycle_card:
                intent = new Intent(this,CycleMapActivity.class);
                startActivity(intent);
                break;
        }

    }
}
