package com.example.weatherapp2.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastWeatherResponse {
    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private int message;
    @SerializedName("cnt")
    private int cnt;
    @SerializedName("list")
    private List<MyList> list;
    @SerializedName("city")
    private City city;

    public String getCod() {
        return cod;
    }

    public int getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public List<MyList> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }
}
