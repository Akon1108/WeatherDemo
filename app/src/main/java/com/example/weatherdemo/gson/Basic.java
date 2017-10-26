package com.example.weatherdemo.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wangdk on 2017/10/24.
 * 利用@SerializedName把JSON和Java字段之间建立映射关系
 * 比如JSON中daily_forecast字段用Java的forecastList字段映射
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
