package com.example.weatherapp2.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp2.Database.City;
import com.example.weatherapp2.Database.RoomDB;
import com.example.weatherapp2.Models.ForecastWeatherResponse;
import com.example.weatherapp2.Network.ApiManager;
import com.example.weatherapp2.R;
import com.example.weatherapp2.Shared.Shared;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewCityActivity extends AppCompatActivity {

    EditText selectedCityEditText;
    Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_city);
        selectedCityEditText = findViewById(R.id.cityEditText);
        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String city = selectedCityEditText.getText().toString();
                if(city.isEmpty()){
                    Toast.makeText(NewCityActivity.this, "Unesite ime grada", Toast.LENGTH_SHORT).show();
                }
                else {
                    saveNewCity(city);
                }
            }
        });
    }

    private void saveNewCity(String cityName){
        ApiManager.getInstance().service().getForecastWeather(cityName, Shared.AppID, Shared.units).enqueue(new Callback<ForecastWeatherResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                if(response.isSuccessful() && response.body() != null){

                    saveCity(cityName);

                }
                else {
                    Toast.makeText(NewCityActivity.this, "Podaci o navedenom gradu ne postoje ili grad ne postoji", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                Toast.makeText(NewCityActivity.this, "Podaci o navedenom gradu ne postoje ili grad ne postoji", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveCity(String city_name){
        RoomDB db = RoomDB.getInstance(this.getApplicationContext());

        City city = new City();
        city.setCity_Name(city_name);
        db.mainDoa().insert(city);

        finish();
    }
}