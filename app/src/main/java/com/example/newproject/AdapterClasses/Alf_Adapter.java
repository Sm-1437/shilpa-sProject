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
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Activity.AssitedLivingFacilityActivity;
import com.example.newproject.Activity.PassMedsActivity;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.R;

import com.example.newproject.pojoClasses.Alfpojo.AlfList;
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

public class Alf_Adapter extends RecyclerView.Adapter<Alf_Adapter.ViewHolder>{
    public Alf_Adapter(ArrayList<AlfList> datalist) {
        this.datalist = datalist;
    }
    private ArrayList<AlfList> datalist;
    Context context;
    String proID;
    ArrayList<TableList> demo;

    // RecyclerView recyclerView;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.alf_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        context=parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.pharmacy1.setText(datalist.get(position).getMenu());
        SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
        String Userfor=preferences.getString("User_for","0");
        String Organisation_id=preferences.getString("Org_id","0");
        Picasso.get().load("http://xxx.xxx.com/images/New%20folder/Desert.jpg.").placeholder(R.drawable.ss).into(holder.pharmacy);
        holder.Linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datalist.get(position).getMenu().equals("Pass Meds")&& datalist.get(position).getID().equals("4")) {
                    showAlertDialog();
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
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        View dialogView= inflater.inflate(R.layout.showstiming, null);
        builder.setView(dialogView);
        TextView time = dialogView.findViewById(R.id.time);
        TextView time1 = dialogView.findViewById(R.id.time1);
        TextView time2 = dialogView.findViewById(R.id.time2);
        TextView time3 = dialogView.findViewById(R.id.time3);
        TextView time4 = dialogView.findViewById(R.id.time4);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("time","AM");
                editor.commit();
                editor.apply();

                Intent intent = new Intent(context, PassMedsActivity.class);

                Log.i("@@##@$", "onClick: "+time.getText().toString());
               context.startActivity(intent);
            }
        });time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("time","Noon");
                editor.commit();
                editor.apply();
                Intent intent = new Intent(context, PassMedsActivity.class);

                Log.i("@@##@$", "onClick: "+time.getText().toString());
                               context.startActivity(intent);

            }
        });time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("time","PM");
                editor.commit();
                editor.apply();
                Intent intent = new Intent(context, PassMedsActivity.class);

                Log.i("@@##@$", "onClick: "+time.getText().toString());

                               context.startActivity(intent);

            }
        });time3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("time","NIGHT");
                editor.commit();
                editor.apply();
                Intent intent = new Intent(context, PassMedsActivity.class);

                Log.i("@@##@$", "onClick: "+time.getText().toString());
                               context.startActivity(intent);

            }
        });time4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PassMedsActivity.class);
                Log.i("@@##@$", "onClick: "+time.getText().toString());
                               context.startActivity(intent);

            }
        });

        builder.create();
        builder.show();
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
