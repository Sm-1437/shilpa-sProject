package com.example.newproject.AdapterClasses;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Activity.AssitedLivingFacilityActivity;
import com.example.newproject.Activity.PaitentDetails;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.TablePOjo.TableList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {
    ArrayList<TableList> demo;
    Context context;


    public TableAdapter(ArrayList<TableList> demo,Context context) {
        this.demo = demo;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.layouttable, parent, false);
        TableAdapter.ViewHolder viewHolder = new TableAdapter.ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(TableAdapter.ViewHolder holder, int position) {
        holder.text2.setText(demo.get(position).getNursingHomeName());
        holder.text1.setText(demo.get(position).getFacilitiescode());

        holder.table_details0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("Id",demo.get(position).getId());
                Log.d("$$$$$", "onResponse: "+demo.get(position).getId());
                editor.commit();
                editor.apply();
                Intent i= new Intent(context, AssitedLivingFacilityActivity.class);
                context.startActivity(i);
            }
        });
//        Picasso.with(context)
//                .load(TableList.getImageurl())
//                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return demo.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text1,text2;
        private TableRow table_details0;
        public ViewHolder(View itemView) {
            super(itemView);
            text1=(TextView)itemView.findViewById(R.id.text1);
            text2=(TextView)itemView.findViewById(R.id.text2);
            table_details0=itemView.findViewById(R.id.table_details0);
        }
    }
}

