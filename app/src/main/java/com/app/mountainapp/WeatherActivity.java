package com.app.mountainapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.mountainapp.weather_data.Astronomy;
import com.app.mountainapp.weather_data.Atmosphere;
import com.app.mountainapp.weather_data.Channel;
import com.app.mountainapp.weather_data.Condition;
import com.app.mountainapp.weather_data.Units;
import com.app.mountainapp.weather_data.Wind;
import com.app.mountainapp.service.WeatherServiceCallback;
import com.app.mountainapp.service.YahooWeatherService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeatherActivity extends BaseActivity implements WeatherServiceCallback {

    private ImageView weatherIcon;
    private TextView temperatureText;
    private TextView sunriseText;
    private TextView sunsetText;
    private TextView locationText;
    private TextView date;
    private TextView windText;
    private TextView humidityText;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.weather);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        weatherIcon = (ImageView)findViewById(R.id.weather_icon);
        temperatureText = (TextView)findViewById(R.id.temperature);
        locationText = (TextView)findViewById(R.id.location);
        date = (TextView)findViewById(R.id.date);
        sunriseText = (TextView)findViewById(R.id.sunrise);
        sunsetText = (TextView)findViewById(R.id.sunset);
        windText = (TextView)findViewById(R.id.wind);
        humidityText = (TextView)findViewById(R.id.humidity);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        service.refreshWeather("Zakopane,PL");

        getCurrentDate(date);

    }

    @Override
    public void serviceSuccess(Channel channel){
        dialog.hide();
        Condition condition = channel.getItem().getCondition();
        Units units = channel.getUnits();
        Astronomy astronomy = channel.getAstronomy();
        Wind wind = channel.getWind();
        Atmosphere atmosphere = channel.getAtmosphere();
        int resourceId = getResources().getIdentifier("icon_" + condition.getCode(),"drawable",getPackageName());
        weatherIcon.setImageResource(resourceId);
        temperatureText.setText(getString(R.string.temperature_output,condition.getTemperature(),units.getTemperature()));
        sunriseText.setText(astronomy.getSunrise());
        sunsetText.setText(astronomy.getSunset());
        windText.setText(wind.getSpeed()+"km/h");
        humidityText.setText(atmosphere.getHumidity()+"%");
        locationText.setText(service.getLocation());
    }

    @Override
    public void serviceFailure(Exception exception){
        dialog.hide();
        Toast.makeText(this,exception.getMessage(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        dialog.dismiss();
    }

    public void getCurrentDate(View view) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd.MM.yyyy");
        String strDate = mdformat.format(calendar.getTime());
        displayDate(strDate);
    }

    private void displayDate(String num) {
        TextView textView = (TextView) findViewById(R.id.date);
        textView.setText(num);
    }

}
