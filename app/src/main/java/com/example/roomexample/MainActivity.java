package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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



        List<UserDetails> x1 = uData.daoObjct().getUserDetails();
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
        temp.setText(info);

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                UserDetails u2 = new UserDetails((x-1),"kul","si");
                uData.daoObjct().delete(u2);
                Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
