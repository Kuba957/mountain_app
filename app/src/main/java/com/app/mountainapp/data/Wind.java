package com.app.mountainapp.data;

import org.json.JSONObject;

public class Wind implements JSONPopulator{
    private String speed;

    public String getSpeed() {
        return speed;
    }

    @Override
    public void populate(JSONObject data) {
        speed = data.optString("speed");
    }
}
