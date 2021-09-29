package com.example.weatherapp2.Network;

import com.example.weatherapp2.Models.ForecastWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("data/2.5/forecast")
    Call<ForecastWeatherResponse> getForecastWeather(@Query("q") String cityName, @Query("appid") String appID, @Query("units") String sUnits);
}