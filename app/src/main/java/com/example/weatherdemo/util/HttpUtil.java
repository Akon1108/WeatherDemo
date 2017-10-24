package com.example.weatherdemo.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Wangdk on 2017/10/11.
 * 注册一个回调来处理服务器的响应
 */

public class HttpUtil {

    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


}
