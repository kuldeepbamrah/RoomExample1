package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView temp;
    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        temp = findViewById(R.id.temp);
        final UserDatabase uData = UserDatabase.getInstance(this);

        List<Employee> usr1 = uData.daoObjct().getUserDetails();

        if(usr1.size() != 0)
        {
            uData.clearAllTables();
        }
        String temp1 = loadJSONFromAsset();
        Gson gson = new Gson();

        try {
            JSONArray jsonarray = new JSONArray(temp1);

            for(int i =0 ; i<=jsonarray.length();i++)
            {
                String temps = jsonarray.get(i).toString();
                Employee emp = gson.fromJson(temps,Employee.class);
                uData.daoObjct().insert(emp);
            }
        }catch (JSONException e)
        {
            e.printStackTrace();
        }


        List<Employee> usr = uData.daoObjct().getUserDetails();

        String info = "";
        for(Employee user : usr)
        {
            Vehicle vtemp = user.getVehicle();
            if(vtemp == null)
            {
                info = info + user.getId() + "," + user.getName()+ "," + "Eror" +"\n";
            }else
            info = info + user.getId() + "," + user.getName()+ "," + vtemp.getPlate()  +"\n";
        }
        temp.setText(info);


        //uData.clearAllTables();





        //JSONObject jsonobj = new JSONObject(temp1);

       //JSONArray jarray = jsonobj.getJSONArray(temp1);

       // Employee emp = gson.fromJson(temp1,Employee.class);

       // Vehicle v = emp.getVehicle();

        //uData.daoObjct().insert(emp);

        //temp.setText(emp.getId().toString() + v.getPlate());

        //List<Employee> emplist = uData.daoObjct().getUserDetails();

        //for(Employee emp1 : emplist)
        //{
            //info = emp1.getId() + emp1.getName() + "\n";
       // }

        //temp.setText(info);


        //UserDetails user1 = gson.fromJson(temp1,UserDetails.class);

        //uData.daoObjct().insert(user1);



        /*List<UserDetails> x1 = uData.daoObjct().getUserDetails();
        for(UserDetails user : x1)
        {
            x = user.getId();
        }
        final UserDetails u1 = new UserDetails((x+1),"Kuldeep","Singh");
        uData.daoObjct().insert(u1);

        List<UserDetails> usr = uData.daoObjct().getUserDetails();

        String info = "";
        for(UserDetails user : usr)
        {
            info = info + user.getId() + "," + user.getFName()+"\n";
        }
        //temp.setText(info);*/




    }

    public String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = MainActivity.this.getAssets().open("sample.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
