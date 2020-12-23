package com.example.newproject.AdapterClasses;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.ImageList;
import com.example.newproject.Activity.PaitentDetails;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Givenmediciene.GivenmedicieneData;
import com.example.newproject.pojoClasses.Medcount.MedcountDATA;
import com.example.newproject.pojoClasses.Medcount.Medcountlist;
import com.example.newproject.pojoClasses.Paitent_List.paitentlist;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    ArrayList<paitentlist> paitentlists;
    Context context;

    public ImageAdapter(ArrayList<paitentlist> paitentlists, Context context) {
        this.paitentlists = paitentlists;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.image_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        paitentlist imageList=paitentlists.get(position);
        holder.txt_roomno.setText(imageList.getRoomNo());
        holder.allergies.setText("Allergies:-"+imageList.getAlergies());
        holder.tvname.setText(imageList.getFirstName()+imageList.getLastName());
        holder.Diagonisis.setText("Diagonisis:-"+imageList.getDiagnoses());
        holder.imformationalorders.setText("Informationalorders:-");
        Count();
        SharedPreferences preferences=context.getSharedPreferences("Mypref",MODE_PRIVATE);
         String medcount=preferences.getString("Medcount","0");
         holder.medicens.setText(medcount);
        Picasso.get().load(imageList.getImgProfile()).placeholder(R.drawable.download).into(holder.img);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(medcount.equals("0")){

                }
                else {
                    SharedPreferences preferences = context.getSharedPreferences("Mypref", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Psr_no", imageList.getPsrno());
                    editor.putString("Paitient_name", imageList.getFirstName() + imageList.getLastName());
                    editor.putString("Allergies", imageList.getAlergies());
                    editor.putString("Diagonisis", imageList.getDiagnoses());
                    editor.putString("Image", imageList.getImgProfile());
                    editor.putString("room", imageList.getRoomNo());
                    editor.commit();
                    editor.apply();
                    Intent i = new Intent(context, PaitentDetails.class);
                    context.startActivity(i);
                }
            }
        });
//        Picasso.with(context)
//                .load(imageList.getImageurl())
//                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return paitentlists.size() ;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname,txt_roomno,allergies,Diagonisis,imformationalorders,medicens;
        private ImageView img;
        private CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            tvname=(TextView)itemView.findViewById(R.id.txt_name);
            txt_roomno=(TextView)itemView.findViewById(R.id.txt_roomno);
            medicens=(TextView)itemView.findViewById(R.id.medicens);
            allergies=(TextView)itemView.findViewById(R.id.allergies);
            Diagonisis=(TextView)itemView.findViewById(R.id.Diagonisis);
            imformationalorders=(TextView)itemView.findViewById(R.id.imformationalorders);
            img=(ImageView)itemView.findViewById(R.id.image_view);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
    private void Count(){
        Apiinterface apiinterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);
        SharedPreferences preferences = context.getSharedPreferences("Mypref", MODE_PRIVATE);
        String count=preferences.getString("Id","0");
        String count1=preferences.getString("time","0");
        Call<MedcountDATA> call = apiinterface.COUNT(count,count1);
        call.enqueue(new Callback<MedcountDATA>() {
            @Override
            public void onResponse(Call<MedcountDATA> call, Response<MedcountDATA> response) {
                if(response.body().getListdata()!=null){
                         if(response.body().getListdata().get(0).getMEDCOUNT()==null){

                         }

                        if (response.body().getListdata() != null) {
                            for (int i = 0; i < response.body().getListdata().size(); i++) {
                                SharedPreferences preferences = context.getSharedPreferences("Mypref", MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("Medcount", response.body().getListdata().get(0).getMEDCOUNT());
                                Log.d("jdwhjd", "onResponse: " + response.body().getListdata().get(0).getMEDCOUNT());
                                editor.commit();
                                editor.apply();
                            }
                        } else {

                        }

                   }
                else {

                }
            }

            @Override
            public void onFailure(Call<MedcountDATA> call, Throwable t) {

            }



        });
    }
}

