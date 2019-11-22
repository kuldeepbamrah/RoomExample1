package com.example.roomexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdetails")
public class UserDetails
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "fName")
    private String fName;
    @ColumnInfo(name = "lName")
    private  String lName;

    public UserDetails(int id, String fName, String lName)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
}
