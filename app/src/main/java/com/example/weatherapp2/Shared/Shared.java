package com.example.weatherapp2.Shared;

import java.text.DateFormat;
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
        DateFormat dateFormat = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdfM = new SimpleDateFormat("mm");
        SimpleDateFormat sdfH = new SimpleDateFormat("H");
        String formatted = sdf.format(date);
        String formattedM = sdfM.format(date);
        String formattedH = sdfH.format(date);
        //String h = (String) dateFormat.format("HH");

        return  foramtedDate(formattedM,formattedH);
    }
    public static String convertUnixToDate2(long dt){
        Date date = new Date(dt*1000L);
        DateFormat dateFormat = new SimpleDateFormat();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formatted = sdf.format(date);

        //String h = (String) dateFormat.format("HH");

        return formatted;
    }

    private static String foramtedDate(String h, String m) {

        String result = h+" sati i ";
        if (m.contains("0")){
            result += m.replace("0","")+ " minuta";
        }
        else{
            result += m +" minuta";
        }
        return result;
    }
}
