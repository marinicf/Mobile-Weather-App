package com.example.weatherapp2.Models;

import java.util.List;

public class MyList {
    private int dt;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private int visibility;
    private double pop;
    private Sys sys;
    private String dt_txt;

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public double getPop() {
        return pop;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }
}
