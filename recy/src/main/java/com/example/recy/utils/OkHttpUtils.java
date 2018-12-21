package com.example.recy.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttpUtils {
    private OkHttpClient okHttpClient;

    private OkHttpUtils(){
        okHttpClient=new OkHttpClient();
    }
    private static class OkHolder{
        private static final OkHttpUtils okHttpUtils=new OkHttpUtils();
    }
    public OkHttpUtils getInstence(){
        return OkHolder.okHttpUtils;
    }
    public void AsyncGet(String url, Callback callback){
        RequestBody requestBody= new FormBody.Builder().add("ky","value").add("ky","value").build();
        Request request=new Request.Builder().url(url).build();
        Call call=okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public void AsyncPost(String url, Callback Callback, RequestBody requestBody){

    }


}
