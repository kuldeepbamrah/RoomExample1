package com.example.roomexample;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomDatabase;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "employee")
public class Employee  {


    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("vehicle")
    @Expose
    private Vehicle vehicle;

    /**
     * No args constructor for use in serialization
     *
     */

    @Ignore
    public Employee() {
    }

    /**
     *
     * @param name

     * @param id
     * @param age
     * @param vehicle
     */
    public Employee( Integer id, String name, Integer age, Vehicle vehicle) {
        super();

        this.id = id;
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}