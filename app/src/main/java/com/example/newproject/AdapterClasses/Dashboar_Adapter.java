package com.example.newproject.AdapterClasses;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Dashboardpojo.DashboardList;
import com.example.newproject.pojoClasses.TablePOjo.TAblepojo;
import com.example.newproject.pojoClasses.TablePOjo.TableList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class Dashboar_Adapter extends RecyclerView.Adapter<Dashboar_Adapter.ViewHolder>{
    public Dashboar_Adapter(ArrayList<DashboardList> datalist) {
        this.datalist = datalist;
    }
    private ArrayList<DashboardList> datalist;
    Context context;
    String proID;
    ArrayList<TableList> demo;

    // RecyclerView recyclerView;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.dashboard_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        context=parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.pharmacy1.setText(datalist.get(position).getFName());
        SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
        String Userfor=preferences.getString("User_for","0");
        String Organisation_id=preferences.getString("Org_id","0");
        Picasso.get().load("http://xxx.xxx.com/images/New%20folder/Desert.jpg.").placeholder(R.drawable.ss).into(holder.pharmacy);
        holder.Linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Userfor.equals("P,A")){
                    if(datalist.get(position).getFName().equals("Assisted Living")&& datalist.get(position).getFId().equals("2")){
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                        View dialogView= inflater.inflate(R.layout.activity_s_ample_t_able, null);
                        builder.setView(dialogView);
                        RecyclerView recyclerview=dialogView.findViewById(R.id.recycler);
                         demo=new ArrayList<TableList>();

                        recyclerview.setHasFixedSize(true);
                        recyclerview.setLayoutManager(new LinearLayoutManager(context));


                     Apiinterface   apiInterface= RetrofitInstance.getRetrofit().create(Apiinterface.class);
                        Call<TAblepojo> call=apiInterface.showalf(Organisation_id);
                        call.enqueue(new Callback<TAblepojo>() {
                            @Override
                            public void onResponse(Call<TAblepojo> call, Response<TAblepojo> response) {
                                recyclerview.setHasFixedSize(true);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
                                recyclerview.setLayoutManager(layoutManager);
                                TableAdapter mAdapter = new TableAdapter(demo,context);
                                recyclerview.setAdapter(mAdapter);

                                if(response.body().getListdata().size()>0) {

                                    for (int i = 0; i < response.body().getListdata().size(); i++) {
                                        demo.addAll(Arrays.asList(response.body().getListdata().get(i)));

                                    }
                                    mAdapter.notifyDataSetChanged();
                                }
                            }

                            @Override
                            public void onFailure(Call<TAblepojo> call, Throwable t) {

                            }
                        });


                        builder.create();
                        builder.show();
                    }
                    else{

                    }
                }

              else{

                }
            }
        });



//
    }


    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView pharmacy1;
        CircleImageView pharmacy;
        LinearLayout Linear_layout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.pharmacy1=itemView.findViewById(R.id.pharmacy1);
            this.pharmacy= itemView.findViewById(R.id.pharmacy);
            this.Linear_layout= itemView.findViewById(R.id.Linear_layout);


        }
    }

    public void fragment_transaction1(FragmentTransaction fragmentTransactionChange, Fragment changeFragment)
    {

        Bundle arguments = new Bundle();
        arguments.putString("proID", proID);
        changeFragment.setArguments(arguments);
        fragmentTransactionChange =  ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
//        fragmentTransactionChange.replace(R.id.frame,changeFragment);
        fragmentTransactionChange.addToBackStack(null);
        fragmentTransactionChange.commit();


    }

}
