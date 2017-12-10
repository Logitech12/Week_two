package com.bwie.qiaoxiaohui20171209.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 乔晓慧 on 2017/12/9.
 */

public class RetrofitHelper {
    private static OkHttpClient client;
    private static ServerApi serverApi;
    static {
        getClient();
    }

    public static OkHttpClient getClient() {
        if (client == null){
            synchronized (OkHttpClient.class){
                if (client == null){
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }

    public static ServerApi getServerApi1() {
        if (serverApi == null){
            synchronized (ServerApi.class){
                if (serverApi == null){
                    serverApi = onCreate(ServerApi.class,Api.HOST1);
                }
            }
        }
        return serverApi;
    }
    public static ServerApi getServerApi() {
        if (serverApi == null){
            synchronized (ServerApi.class){
                if (serverApi == null){
                    serverApi = onCreate(ServerApi.class,Api.HOST2);
                }
            }
        }
        return serverApi;
    }
    public static <T> T onCreate(Class<T> tClass,String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(tClass);
    }
}
