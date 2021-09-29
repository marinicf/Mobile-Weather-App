package com.example.weatherapp2.Models;

import com.squareup.picasso.RequestCreator;

public class CityData {
    private int id;
    private String name;
    private String temp;
    private String desc;
    private String lat;
    private String lon;
    private String humidity;
    private String sunrise;
    private String sunset;
    private String pressure;
    private String wind_speed;
    private RequestCreator img;
    private int icon;

    public CityData(String name, String temp, String desc, String lat, String lon, String humidity, String sunrise, String sunset, String pressure, String wind_speed, int icon) {
        this.name = name;
        this.temp = temp;
        this.desc = desc;
        this.lat = lat;
        this.lon = lon;
        this.humidity = humidity;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.pressure = pressure;
        this.wind_speed = wind_speed;
        this.icon = icon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public RequestCreator getImg() {
        return img;
    }

    public void setImg(RequestCreator img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
