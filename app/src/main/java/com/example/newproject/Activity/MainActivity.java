package com.example.newproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.newproject.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().hide();
        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(1200);
                    SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
                    String Logout=preferences.getString("log_out","0");
                    if(!(Logout.equals("0"))){
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Intent intent = new Intent(getApplicationContext(),SliderActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}