package com.app.mountainapp.service;

import com.app.mountainapp.data.Channel;

public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
