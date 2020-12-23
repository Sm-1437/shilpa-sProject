package com.example.newproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.newproject.AdapterClasses.Alf_Adapter;
import com.example.newproject.AdapterClasses.ImageAdapter;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.ImageList;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Medcount.MedcountDATA;
import com.example.newproject.pojoClasses.Medcount.Medcountlist;
import com.example.newproject.pojoClasses.Paitent_List.Patientdata;
import com.example.newproject.pojoClasses.Paitent_List.paitentlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassMedsActivity extends AppCompatActivity {
    ArrayList<paitentlist> imageLists;
    ArrayList<Medcountlist> countlist;
    private RecyclerView rv;
    private Apiinterface apiInterface;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_meds);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        imageLists = new ArrayList<paitentlist>();
        countlist = new ArrayList<Medcountlist>();

        rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter mAdapter = new ImageAdapter(imageLists, this);
        rv.setAdapter(mAdapter);

        apiInterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);
        SharedPreferences preferences = getSharedPreferences("Mypref", MODE_PRIVATE);
        String Alf_ID = preferences.getString("Id", "0");
        String TIME = preferences.getString("time", "0");
        Log.d("#@#@$@##", "onCreate: " + Alf_ID);
        Log.d("#@#@$@##", "onCreate: " + TIME);
        Call<Patientdata> call = apiInterface.list(Alf_ID, TIME);
        call.enqueue(new Callback<Patientdata>() {
            @Override
            public void onResponse(Call<Patientdata> call, Response<Patientdata> response) {
                if (response.body().getListdata() != null) {
                    if (response.body().getListdata().size() > 0) {
                        for (int i = 0; i < response.body().getListdata().size(); i++) {
                            if (response.body().getListdata() != null) {
                                imageLists.addAll(Arrays.asList(response.body().getListdata().get(i)));
                            } else {

                            }

                        }

                        mAdapter.notifyDataSetChanged();

                    }
                } else {

                }


            }

            @Override
            public void onFailure(Call<Patientdata> call, Throwable t) {

            }

        });
    }


}
