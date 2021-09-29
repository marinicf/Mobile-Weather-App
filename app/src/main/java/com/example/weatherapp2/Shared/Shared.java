package com.example.weatherapp2.Shared;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Shared {
    public static final String AppID = "f5a3262a1fc06fb99ae51e494f7e08ba";
    public static String units = "metric";

    public static String UpdateIcon(int id){
        String icon = "na";
        if (id >= 0 && id <= 300){
            icon = "thunderstorm";
        }
        else if (id >= 300 && id <= 500){
            icon = "drizzl";
        }
        else if (id >= 500 && id <= 600){
            icon = "rain";
        }
        else if (id >= 600 && id <= 700){
            icon = "snow";
        }
        else if (id >= 701 && id <= 771){
            icon = "overcast";
        }
        else if (id >= 701 && id < 800){
            icon = "clouds";
        }
        else if (id == 800){
            icon = "clear_sky";
        }
        else if (id >= 801 && id <= 804){
            icon = "atmosphere";
        }
        return icon;
    }
    public static String convertUnixToDate(long dt){
        Date date = new Date(dt*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formatted = sdf.format(date);

        return formatted;
    }
}
