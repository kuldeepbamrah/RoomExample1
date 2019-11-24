package com.example.roomexample;

import android.content.Context;
import android.icu.lang.UScript;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = UserDetails.class , exportSchema = false , version = 1)
public abstract class UserDatabase extends RoomDatabase
{

    public static final String DB_NAME = "user_db";

    private static  UserDatabase uInstance;


    public static UserDatabase getInstance(Context context)
    {
        if(uInstance == null)
        {
            uInstance = Room.databaseBuilder(context.getApplicationContext(),UserDatabase.class,UserDatabase.DB_NAME).allowMainThreadQueries().build();
        }
        return uInstance;
    }


    public abstract DataAccessObjectInterface daoObjct();
}
