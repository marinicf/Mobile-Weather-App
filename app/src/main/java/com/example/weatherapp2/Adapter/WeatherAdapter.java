package com.example.weatherapp2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp2.Models.CityData;
import com.example.weatherapp2.R;

import java.util.ArrayList;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {

    Context context;
    RecyclerViewClickListener listener;
    ArrayList<CityData> forecastWeatherResponseList;

    public WeatherAdapter(Context context, ArrayList<CityData> forecastWeatherResponseList, RecyclerViewClickListener listener) {
        this.context = context;
        this.forecastWeatherResponseList = forecastWeatherResponseList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.MyViewHolder holder, int position) {
        final CityData item = forecastWeatherResponseList.get(position);

        holder.txt_city.setText(item.getName());
        holder.txt_temp.setText(item.getTemp());
        holder.txt_desc.setText(item.getDesc());
        //item.getImg().into(holder.img_icon);
        holder.img_icon.setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return forecastWeatherResponseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt_city, txt_desc, txt_temp;
        ImageView img_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_icon = itemView.findViewById(R.id.icon_iv);
            txt_city = itemView.findViewById(R.id.city_tv);
            txt_desc = itemView.findViewById(R.id.desc_tv);
            txt_temp = itemView.findViewById(R.id.temp_tv);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
