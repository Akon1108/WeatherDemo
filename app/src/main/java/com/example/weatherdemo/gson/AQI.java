package com.example.weatherdemo.gson;

/**
 * Created by Wangdk on 2017/10/24.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String aqi;
        public String pm25;
    }
}
