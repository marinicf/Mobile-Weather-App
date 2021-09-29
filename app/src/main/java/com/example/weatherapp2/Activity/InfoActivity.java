package com.example.weatherapp2.Activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp2.R;

public class InfoActivity extends AppCompatActivity {

    TextView info, LatTextView, LonTextView, HumidityTextView, SunriseTextView, SunsetTextView, PressureTextView, WindSpeedTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info = findViewById(R.id.tv_cityNameInfo);
        LatTextView = findViewById(R.id.latTextView);
        LonTextView = findViewById(R.id.longitudeTextView);
        HumidityTextView = findViewById(R.id.humidityTextView);
        SunriseTextView = findViewById(R.id.sunriseTextView);
        SunsetTextView = findViewById(R.id.sunsetTextView);
        PressureTextView = findViewById(R.id.pressureTextView);
        WindSpeedTextView = findViewById(R.id.windTextView);
        String name, lat, lon, pressure, humidity, sunrise, sunset, wind;

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name = extras.getString("name");
            lat = extras.getString("lat");
            lon = extras.getString("lon");
            humidity = extras.getString("humidity");
            pressure = extras.getString("pressure");
            sunrise = extras.getString("sunrise");
            sunset = extras.getString("sunset");
            wind = extras.getString("wind");
            info.setText(name);
            LatTextView.setText(lat);
            LonTextView.setText(lon);
            HumidityTextView.setText(humidity);
            SunriseTextView.setText(sunrise);
            SunsetTextView.setText(sunset);
            PressureTextView.setText(pressure);
            WindSpeedTextView.setText(wind);
        }
    }
}