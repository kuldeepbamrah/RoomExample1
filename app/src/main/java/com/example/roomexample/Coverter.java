package com.example.roomexample;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class Coverter
{
    @TypeConverter
    public static Vehicle fromString(String value)
    {
        Type listType = new TypeToken<Vehicle>() {}.getType();
        return new Gson().fromJson(value,listType);
    }

    @TypeConverter
    public static  String fromVehicle(Vehicle vehicle)
    {
        Gson gson = new Gson();
        String json = gson.toJson(vehicle);
            return json;
    }

}
