package com.example.newproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newproject.AdapterClasses.Alf_Adapter;
import com.example.newproject.AdapterClasses.Dashboar_Adapter;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Alfpojo.AlfList;
import com.example.newproject.pojoClasses.Alfpojo.Alfmain;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssitedLivingFacilityActivity extends AppCompatActivity {
    LinearLayout passmeds,log_out;
    RecyclerView recycler_view;
    String category;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AlfList> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assited_living_facility);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        recycler_view=findViewById(R.id.recycler_view);
        datalist=new ArrayList<AlfList>();
        Dashboard_api();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {

        case R.id.exit:
            int s=0;
            SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            editor.putString("log_out", String.valueOf(s));
            editor.commit();
            editor.apply();
            finishAffinity();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }










    private void Dashboard_api(){
        Apiinterface apiinterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);

        SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
        String Alfrole=preferences.getString("Alf_role","0");
        Log.d("@@#@#@#", "Dashboard_api: "+Alfrole);
        Call<Alfmain> call = apiinterface.Alficon(Alfrole);
        call.enqueue(new Callback<Alfmain>() {
            @Override
            public void onResponse(Call<Alfmain> call, Response<Alfmain> response) {

                    recycler_view.setHasFixedSize(true);
                    layoutManager = new LinearLayoutManager(AssitedLivingFacilityActivity.this);
                    recycler_view.setLayoutManager(layoutManager);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(AssitedLivingFacilityActivity.this, 3);
                    recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                    Alf_Adapter mAdapter = new Alf_Adapter(datalist);
                    recycler_view.setAdapter(mAdapter);
                if(response.body().getListdata()!=null) {

                    if (response.body().getListdata().size() > 0) {
                        if (response.body().getListdata() != null && !(response.body().getListdata().isEmpty())) {
                            if (response.body().getStatus() == true) {
                                for (int i = 1; i < response.body().getListdata().size(); i++) {
                                    if (response.body().getListdata().get(i) != null) {
                                        datalist.addAll(Arrays.asList(response.body().getListdata().get(i)));
                                    } else {

                                    }

                                }
                                mAdapter.notifyDataSetChanged();
                            } else if (response.body().getStatus() == false) {
                                Toast.makeText(AssitedLivingFacilityActivity.this, "Their is no Data of Resident", Toast.LENGTH_SHORT).show();
                            }
                        } else {

                        }
                    } else {

                    }
                }
                }




            @Override
            public void onFailure(Call<Alfmain> call, Throwable t) {

                Toast.makeText(AssitedLivingFacilityActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
