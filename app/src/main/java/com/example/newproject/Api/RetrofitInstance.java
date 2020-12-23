package com.example.newproject.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit=null;
    private static Retrofit retrofitpharma=null;
    private static Retrofit retrofitDemo=null;
    private static final String BASE_URL = "http://steerpos.com/api/";
    private static final String BASEURL = "https://uniqueandrocode.000webhostapp.com/hiren/retrofit/";
    private static final String BASE__URL = "http://pharmacy.steerpos.com/";
    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
    public static Retrofit getRetrofitInstanc(){
        if (retrofitDemo == null) {
            retrofitDemo = new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitDemo;

    }
    public static Retrofit getRetrofit(){
        if (retrofitpharma == null) {
            retrofitpharma = new Retrofit.Builder()
                    .baseUrl(BASE__URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitpharma;

    }
}
