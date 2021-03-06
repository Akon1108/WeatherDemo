package com.example.weatherdemo.util;

import android.text.TextUtils;

import com.example.weatherdemo.db.City;
import com.example.weatherdemo.db.County;
import com.example.weatherdemo.db.Province;
import com.example.weatherdemo.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Wangdk on 2017/10/11.
 * 解析和处理服务器返回的省级数据，组装成实体类存入数据库
 */

public class Utility {

    /*解析和处理服务器返回的省级数据*/
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                //简单数据直接用JSONArray,JSONObject解析数据，组装成实体类对象，调用save存数到数据库
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++){
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();//组装成实体类
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();//存入数据库
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

     /*解析和处理服务器返回的市级数据*/
     public static boolean handleCityResponse(String response, int provinceId){
         if (!TextUtils.isEmpty(response)){
             try {
                 JSONArray allCities = new JSONArray(response);
                 for (int i = 0; i < allCities.length(); i++){
                     JSONObject cityObject = allCities.getJSONObject(i);
                     City city = new City();
                     city.setCityName(cityObject.getString("name"));
                     city.setCityCode(cityObject.getInt("id"));
                     city.setProvinceId(provinceId);
                     city.save();
                 }
                 return true;
             }catch (JSONException e){
                 e.printStackTrace();
             }
         }
         return false;
     }

    /*解析和处理服务器返回的县级数据*/
    public static boolean handleCountryResponse(String response, int cityId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /*JSON解析天气数据成实体类Weather*/
    public static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Weather.class);//通过fromJson把JSON转化为Weather实体类对象
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
