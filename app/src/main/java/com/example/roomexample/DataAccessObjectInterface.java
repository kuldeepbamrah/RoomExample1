package com.example.roomexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DataAccessObjectInterface
{
    @Insert
   void insert(UserDetails userDetails);

   @Delete
    void delete(UserDetails userDetails);

   @Update
    void update(UserDetails userDetails);

   @Query("Select * from userdetails")
    List<UserDetails> getUserDetails();
}
