package com.example.weatherapp2.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {
    @Insert(onConflict = REPLACE)
    void insert(City city);

    @Query("SELECT * FROM city_table")
    List<City> getAll();

    @Delete
    void delete(City city);
}
