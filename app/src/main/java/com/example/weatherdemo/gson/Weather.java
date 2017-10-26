package com.example.weatherdemo.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Wangdk on 2017/10/24.
 * 引用所有数据
 */

public class Weather {
    //引用
    public  String status;//反映返回数据的正确与否
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    //用数据List集合引用Forecast类
    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
