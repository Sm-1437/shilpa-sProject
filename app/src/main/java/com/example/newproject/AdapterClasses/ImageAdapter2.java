package com.example.newproject.AdapterClasses;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Activity.PaitentDetails;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.ImageList;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.Interface.CustomItemClickListener;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Givenmediciene.GivenmedicieneData;
import com.example.newproject.pojoClasses.MedicationPOjo.MedicationData;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

import static android.content.Context.MODE_PRIVATE;

public class ImageAdapter2 extends RecyclerView.Adapter<ImageAdapter2.ViewHolder> {
    ArrayList<MedicationData> imageLists;
    ArrayList<String> jsom;
    Context context;
    boolean clicked = false;
    JSONArray jarry ;
    CustomItemClickListener listner;
    public ImageAdapter2(ArrayList<MedicationData> imageLists, Context context, CustomItemClickListener listner) {
        this.imageLists = imageLists;
        this.context = context;
        this.listner = listner;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.image_listc, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Date date1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss a");
        df.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        String strDate = df.format(date1);
        Log.d("!@#$%z67", "onBindViewHolder: "+strDate);
        SharedPreferences preferences = context.getSharedPreferences("Mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("mediciene_name", imageLists.get(position).getMedication());
        editor.commit();
        editor.apply();
        String medname = preferences.getString("mediciene_name", "0");
        jsom=new ArrayList<>();
//                        jsom.add(medname);
        jsom.addAll(Arrays.asList(medname));
        Log.d("1234567", "onClick: "+jsom);
        MedicationData imageList=imageLists.get(position);
        holder.tvname.setText(imageList.getMedication());
        holder.txt_roomno.setText(imageList.getInstruction());
        holder.diagnosis.setText("Diagnosis:-"+imageList.getDiagnosis());
        holder.time.setText("Last Given:-"+imageList.getDoseTime());
        Picasso.get().load(imageList.getImgURL()).placeholder(R.drawable.pass_meds).into(holder.img);
//        if (!(strDate.equals(imageList.getDoseTime()))){
//             holder.tick.setVisibility(View.VISIBLE);
//        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    if (!clicked) {
                        holder.tick.setVisibility(View.VISIBLE);
                        SharedPreferences preferences = context.getSharedPreferences("Mypref", MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("Med_ID", imageList.getOredrID());
                        editor.putString("mediciene_name", imageList.getMedication());
                Log.d("mediciene_name", "onClick: "+imageList.getMedication());
                        editor.commit();
                        editor.apply();

                        String TIME = preferences.getString("time", "0");
                        String Psrno = preferences.getString("Psr_no", "0");
                        String MedID = preferences.getString("Med_ID", "0");
                        String Caregiver = preferences.getString("name", "0");


                        List<String> myJSONObjects = new ArrayList<String>();
                        JSONObject post = new JSONObject();

                        try {
                            post.put("MedID", MedID);
                            post.put("PsrNo", Psrno);
                            post.put("DoseShift", TIME);
                            post.put("Caregiver", Caregiver);
                            myJSONObjects.add(post.toString());
                            Log.d("@#$", "onClick: " + myJSONObjects);
                            Log.d("@#$!!", "onClick: " + myJSONObjects.toString());
                            editor.putString("med", myJSONObjects.toString());

                            editor.commit();
                            editor.apply();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        clicked = true;

//                    } else {
//
//
//                        holder.tick.setVisibility(View.GONE);
//                        clicked = false;
//                    }
                }
//            }
        });
//        Picasso.with(context)
//                .load(imageList.getImageurl())
//                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imageLists.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname,txt_roomno,diagnosis,time;
        private ImageView img,tick;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvname=(TextView)itemView.findViewById(R.id.txt_name);
            txt_roomno=(TextView)itemView.findViewById(R.id.txt_roomno);
            tick=itemView.findViewById(R.id.tick);
            time=itemView.findViewById(R.id.time);
            diagnosis=itemView.findViewById(R.id.diagnosis);
            img=(ImageView)itemView.findViewById(R.id.image_view);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }


}

