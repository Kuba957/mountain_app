package com.app.mountainapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;


public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onActivityChange(View view){
        int choose = view.getId();
        Intent intent;
        switch(choose){
            case R.id.map:
                intent = new Intent(this,MapActivity.class);
                startActivity(intent);
                break;
            case R.id.weather:
                intent = new Intent(this,WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.shelter:
                intent = new Intent(this,ShelterActivity.class);
                startActivity(intent);
                break;
            case R.id.info:
                intent = new Intent(this,InfoActivity.class);
                startActivity(intent);
                break;
            case R.id.trail:
                intent = new Intent(this,TrailActivity.class);
                startActivity(intent);
                break;
            case R.id.help:
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:"+getResources().getString(R.string.emergency_phone)));
                startActivity(phoneIntent);
                break;
        }

    }
}
