package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDatabase uData = UserDatabase.getInstance(this);

        UserDetails u1 = new UserDetails(1,"Kuldeep","Singh");
        uData.daoObjct().insert(u1);
        uData.daoObjct().getUserDetails();
        //System.out.println(uData.daoObjct().getUserDetails());
    }
}
