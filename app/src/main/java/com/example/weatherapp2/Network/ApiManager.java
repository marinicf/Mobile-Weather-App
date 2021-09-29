package com.example.weatherapp2.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static ApiManager instance;
    private WeatherService service;
    public static String baseUrl = "http://api.openweathermap.org/";

    private ApiManager() {
        Retrofit.Builder builder = new Retrofit.Builder();
        //postavljanje retrofira
        Retrofit retrofit = builder.baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WeatherService.class);
    }

    public static ApiManager getInstance(){
        if (instance == null){
            instance = new ApiManager();
        }
        return instance;
    }
    public WeatherService service(){
        return service;
    }
}
