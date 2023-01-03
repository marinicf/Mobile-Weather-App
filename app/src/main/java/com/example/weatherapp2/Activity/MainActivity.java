package com.example.weatherapp2.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp2.Adapter.WeatherAdapter;
import com.example.weatherapp2.Database.City;
import com.example.weatherapp2.Database.RoomDB;
import com.example.weatherapp2.Models.CityData;
import com.example.weatherapp2.Models.ForecastWeatherResponse;
import com.example.weatherapp2.Network.ApiManager;
import com.example.weatherapp2.R;
import com.example.weatherapp2.Shared.Shared;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button newCityBtn;
    TextView tvNotice;
    WeatherAdapter adapter;
    List<City> cityList;
    private WeatherAdapter.RecyclerViewClickListener listener;
    public ArrayList<CityData> dataForRecycler = new ArrayList<>();
    String cityName, temp, desc, lat, lon, humidity, pressure, sunrise, sunset, windSpeed;
    int icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newCityBtn = findViewById(R.id.noviGradBtn);
        newCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, NewCityActivity.class), 100);
                /*Intent newCityIntent = new Intent(getApplicationContext(), SelectCityActivity.class);
                startActivity(newCityIntent);*/
            }
        });
        loadCities();
    }
    private void loadCities() {
        RoomDB db = RoomDB.getInstance(this.getApplicationContext());
        cityList = db.mainDoa().getAll();

        for (int i = 0; i < cityList.size(); i++) {
            int finalI = i;

            ApiManager.getInstance().service().getForecastWeather(cityList.get(i).getCity_Name(), Shared.AppID, Shared.units).enqueue(new Callback<ForecastWeatherResponse>() {
                @Override
                public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                    if(response.isSuccessful() && response.body() != null){
                        final ForecastWeatherResponse weatherResponse = response.body();
                        cityName = weatherResponse.getCity().getName();
                        desc = weatherResponse.getList().get(0).getWeather().get(0).getDescription();
                        temp = weatherResponse.getList().get(0).getMain().getTemp() + "°C";
                        lat = String.valueOf(weatherResponse.getCity().getCoord().getLat());
                        lon = String.valueOf(weatherResponse.getCity().getCoord().getLon());
                        humidity = weatherResponse.getList().get(0).getMain().getHumidity()+" %";
                        pressure = weatherResponse.getList().get(0).getMain().getPressure()+" hPa";
                        sunrise = Shared.convertUnixToDate(weatherResponse.getCity().getSunrise());
                        sunset = Shared.convertUnixToDate2(weatherResponse.getCity().getSunset());
                        windSpeed = weatherResponse.getList().get(0).getWind().getSpeed()+" mps";
                        icon = getResources().getIdentifier(Shared.UpdateIcon(weatherResponse.getList().get(0).getWeather().get(0).getId()),"drawable",getPackageName());
                        CityData newCity = new CityData(cityName, temp, desc,lat, lon, humidity, sunrise, sunset,pressure, windSpeed,icon);
                        dataForRecycler.add(newCity);

                        if (finalI == cityList.size() - 1) {
                            Log.d("DATA SIZE", String.valueOf(dataForRecycler.size()));
                            setUpLayout(dataForRecycler);
                        }
                    }
                    else {
                        Log.e(MainActivity.class.getSimpleName(), "Ne uspjesna konekcija " + response.code() + ": " + response.errorBody());

                    }
                }
                @Override
                public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Grad nije dostupan", Toast.LENGTH_SHORT).show();
                    Log.d("ERROR", "Error" + t);
                }
            });
        }
    }
    private void setUpLayout(ArrayList<CityData> dataForRecycler) {
        setOnClickListener();
        RecyclerView recyclerView = findViewById(R.id.recycler_forecast);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter = new WeatherAdapter(this, dataForRecycler, listener));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            dataForRecycler.clear();
            loadCities();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    private void setOnClickListener() {
        listener = new WeatherAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                intent.putExtra("name", dataForRecycler.get(position).getName());
                intent.putExtra("lat", dataForRecycler.get(position).getLat());
                intent.putExtra("lon", dataForRecycler.get(position).getLon());
                intent.putExtra("humidity", dataForRecycler.get(position).getHumidity());
                intent.putExtra("pressure", dataForRecycler.get(position).getPressure());
                intent.putExtra("sunset", dataForRecycler.get(position).getSunset());
                intent.putExtra("sunrise", dataForRecycler.get(position).getSunrise());
                intent.putExtra("wind", dataForRecycler.get(position).getWind_speed());
                startActivity(intent);
            }
        };
    }
}