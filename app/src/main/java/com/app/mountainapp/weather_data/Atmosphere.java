package com.app.mountainapp.weather_data;

import org.json.JSONObject;

public class Atmosphere implements JSONPopulator {

    private String humidity;

    public String getHumidity() {
        return humidity;
    }

    @Override
    public void populate(JSONObject data) {
        humidity = data.optString("humidity");
    }
}
