package com.example.asus.myapplication.util;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil  {
    private OkHttpClient okHttpClient;
    private HttpUtil() {
        okHttpClient =new OkHttpClient();
    }
    private static class OkHolder{
        private static  HttpUtil httpUtil=new HttpUtil();
    }
    public static HttpUtil getInstence(){
        return OkHolder.httpUtil;
    }
    public void AsyncGet(String url, Callback callback){
        Request request=new Request.Builder().url(url).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);

    }
}
