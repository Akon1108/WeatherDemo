package com.example.weatherdemo.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Wangdk on 2017/10/24.
 * 数组，未来几天的预报
 */

public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{
        public String max;
        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String info;
    }
}
