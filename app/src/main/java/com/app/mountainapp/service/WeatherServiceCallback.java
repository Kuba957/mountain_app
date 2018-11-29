package com.app.mountainapp.service;

import com.app.mountainapp.weather_data.Channel;

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
