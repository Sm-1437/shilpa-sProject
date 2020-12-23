package com.example.newproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newproject.AdapterClasses.Dashboar_Adapter;
import com.example.newproject.AdapterClasses.ImageAdapter;
import com.example.newproject.AdapterClasses.TableAdapter;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.ImageList;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.SAmpleTAbleActivity;
import com.example.newproject.pojoClasses.Dashboardpojo.DashboardList;
import com.example.newproject.pojoClasses.Dashboardpojo.Dashboardpojo;
import com.example.newproject.tableview.tableactivity.MainTableActivity;
import com.example.newproject.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {
          RecyclerView recycler_view;
    String category;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DashboardList> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        recycler_view=findViewById(R.id.recycler_view);
        datalist=new ArrayList<DashboardList>();
       Dashboard_api();

    }
    private void Dashboard_api(){
        Apiinterface apiinterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);

        SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
        String Pharma_role=preferences.getString("Pharma_role","0");
        Call<Dashboardpojo> call = apiinterface.dashboard(Pharma_role);
        call.enqueue(new Callback<Dashboardpojo>() {
            @Override
            public void onResponse(Call<Dashboardpojo> call, Response<Dashboardpojo> response) {

                
                recycler_view.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(DashboardActivity.this);
                recycler_view.setLayoutManager(layoutManager);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(DashboardActivity.this,3);
                recycler_view.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
                Dashboar_Adapter mAdapter = new Dashboar_Adapter(datalist);
                recycler_view.setAdapter(mAdapter);
                if(response.body().getListdata()!=null) {

                    if (response.body().getListdata().size() > 0) {
                        for (int i = 1; i < response.body().getListdata().size(); i++) {
                            datalist.addAll(Arrays.asList(response.body().getListdata().get(i)));

                        }

                        mAdapter.notifyDataSetChanged();
                    } else {

                    }
                }
            }




            @Override
            public void onFailure(Call<Dashboardpojo> call, Throwable t) {
                
                Toast.makeText(DashboardActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}