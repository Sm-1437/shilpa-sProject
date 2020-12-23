package com.example.newproject.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.newproject.AdapterClasses.ImageAdapter2;
import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.Interface.CustomItemClickListener;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.Givenmediciene.GivenmedicieneData;
import com.example.newproject.pojoClasses.MedicationPOjo.MedicationData;
import com.example.newproject.pojoClasses.MedicationPOjo.MedicationList;
import com.squareup.picasso.Picasso;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaitentDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CustomItemClickListener {
    private RecyclerView rv;
    ArrayList<MedicationData> imageLists;
    private Apiinterface apiInterface;
    private ImageAdapter2 adapter;
    Button btn_next;
    CircleImageView image_view;
    TextView txt_name,txt_roomno,allergies,Diagonisis,medicens;
    JSONObject jsonobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paitent_details);


        rv=(RecyclerView)findViewById(R.id.recyclerview);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        imageLists=new ArrayList<MedicationData> ();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ImageAdapter2 mAdapter= new ImageAdapter2(imageLists,this,this::onItemClick);
        rv.setAdapter(mAdapter);
        btn_next=findViewById(R.id.btn_next);

        image_view=findViewById(R.id.image_view);
        Diagonisis=findViewById(R.id.Diagonisis);
        allergies=findViewById(R.id.allergies);
        txt_roomno=findViewById(R.id.txt_roomno);
        txt_name=findViewById(R.id.txt_name);
        medicens=findViewById(R.id.medicens);
        SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
       String Image_url=preferences.getString("Image","0");
       String room_no=preferences.getString("room","0");
       String name=preferences.getString("Paitient_name","0");
       String Diagnosis=preferences.getString("Diagonisis","0");
       String Allergies=preferences.getString("Allergies","0");
        String Alf_ID=preferences.getString("Id","0");
        String TIME=preferences.getString("time","0");
        String Psrno=preferences.getString("Psr_no","0");
        String MedID=preferences.getString("Med_ID","0");
        String Caregiver=preferences.getString("name","0");
        String medcount=preferences.getString("Medcount","0");
        String  medname = preferences.getString("mediciene_name","0");
       ArrayList<String> arrayList = new ArrayList<String>();
      arrayList.addAll(Arrays.asList(medname));
        Log.d("medicienename_1234", "onCreate: "+arrayList);
        txt_name.setText(name);
        medicens.setText(medcount);
       txt_roomno.setText(room_no);
      allergies.setText("Allergies:-"+Allergies);
        Diagonisis.setText("Diagonisis:-"+Diagnosis);
        Picasso.get().load(Image_url).placeholder(R.drawable.download).into(image_view);


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Given_mediciene();
                AlertDialog.Builder builder = new AlertDialog.Builder(PaitentDetails.this);
                LayoutInflater inflater = (PaitentDetails.this).getLayoutInflater();

                View dialogView= inflater.inflate(R.layout.instructionnotes, null);
                builder.setView(dialogView);

                Spinner spinner=dialogView.findViewById(R.id.spinner);
                TextView erer=dialogView.findViewById(R.id.erer);
                Button continu=dialogView.findViewById(R.id.continu);
                Button cancel=dialogView.findViewById(R.id.cancel);
                continu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(PaitentDetails.this);
                        LayoutInflater inflater = (PaitentDetails.this).getLayoutInflater();
                        View dialogView= inflater.inflate(R.layout.paitentfeedback, null);
                        builder.setView(dialogView);



                        Spinner spinne=dialogView.findViewById(R.id.spinner);
                        Button back=dialogView.findViewById(R.id.back);
                        Button create=dialogView.findViewById(R.id.create);

                        Button record=dialogView.findViewById(R.id.record);


                        spinne.setOnItemSelectedListener(PaitentDetails.this);

                        // Spinner Drop down elements
                        List<String> categorie = new ArrayList<String>();
                        categorie.add("NONE");
                        categorie.add("RESIDENT REFUSED");
                        categorie.add("OUT OF FACILITY");
                        categorie.add("PHYSICALLY UNABLE TO TAKE");
                        categorie.add("WITHHELD PER Dr/RN ORDER");
                        categorie.add("GIVEN TO FAMILY TO GIV LATER");

                        // Creating adapter for spinner
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PaitentDetails.this, android.R.layout.simple_spinner_item, categorie);

                        // Drop down layout style - list view with radio button
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        // attaching data adapter to spinner
                        spinne.setAdapter(dataAdapter);

                        back.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i= new Intent(PaitentDetails.this,PaitentDetails.class);
                                startActivity(i);
                                finish();
                            }
                        });
                        record.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences preferences=getSharedPreferences("Mypref",MODE_PRIVATE);
                                String Caregiver=preferences.getString("name","0");
                                String name1=preferences.getString("Paitient_name","0");
                                AlertDialog.Builder builder = new AlertDialog.Builder(PaitentDetails.this);
                                LayoutInflater inflater = (PaitentDetails.this).getLayoutInflater();
                                View dialogView= inflater.inflate(R.layout.adminstration, null);
                                builder.setView(dialogView);
                                Button continu=dialogView.findViewById(R.id.continu);
                                Button cancel=dialogView.findViewById(R.id.cancel);
                                TextView txt_name=dialogView.findViewById(R.id.txt_name);
                                TextView resident=dialogView.findViewById(R.id.resident);
                                txt_name.setText("By user:-"+Caregiver);
                                resident.setText("For Resident:-"+name1);
                                cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(PaitentDetails.this,PaitentDetails.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });
                                continu.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i= new Intent(PaitentDetails.this,AssitedLivingFacilityActivity.class);
                                        startActivity(i);
                                        finish();
                                    }
                                });
                                builder.create();
                                builder.show();

                            }
                        });

                        builder.create();
                        builder.show();

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i= new Intent(PaitentDetails.this,PaitentDetails.class);
                        startActivity(i);
                        finish();
                    }


                });
                spinner.setOnItemSelectedListener(PaitentDetails.this);

                // Spinner Drop down elements
                List<String> categories = new ArrayList<String>();
                categories.add("Water");
                categories.add("Milk");
                categories.add("YOGURT");
                categories.add("JUICE");
                categories.add("THIKIT");
                categories.add("MISC");

                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(PaitentDetails.this, android.R.layout.simple_spinner_item, categories);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                spinner.setAdapter(dataAdapter);


                builder.create();
                builder.show();

            }




        });

        apiInterface= RetrofitInstance.getRetrofit().create(Apiinterface.class);

        Log.d("#@#@$@##", "onCreate: "+Alf_ID);
        Log.d("#@#@$@##", "onCreate: "+TIME);
        Log.d("#@#@$@##", "onCreate: "+Psrno);
        Call<MedicationList> call=apiInterface.paitient(Psrno,Alf_ID,TIME);
        call.enqueue(new Callback<MedicationList>() {
            @Override
            public void onResponse(Call<MedicationList> call, Response<MedicationList> response) {
                if(response.body().getListdata()!=null) {

                    if (response.body().getListdata().size() > 0) {
                            ArrayList<String> name=new ArrayList<>();
                        for (int i = 0; i < response.body().getListdata().size(); i++) {
                            if (response.body().getListdata() != null) {
                                imageLists.addAll(Arrays.asList(response.body().getListdata().get(i)));
//                                name.add(response.body().getListdata().get(i).getMedication().toString());
                                name.addAll(Arrays.asList(response.body().getListdata().get(i).getMedication()));
                                Log.d("medicene_name1234", "onResponse: "+name);
                            } else {

                            }

                        }

                        mAdapter.notifyDataSetChanged();

                    }
                }

            }

            @Override
            public void onFailure(Call<MedicationList> call, Throwable t) {

            }

        });

    }


    @Override
    public void onItemClick(int Status) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    private void Given_mediciene(){
        Apiinterface apiinterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);
        SharedPreferences preferences =getSharedPreferences("Mypref", MODE_PRIVATE);
        String mediciene=preferences.getString("med","0");
        Log.d("!@!@!@!@", "Given_mediciene: "+mediciene);
        Call<GivenmedicieneData> call = apiinterface.mediceine(mediciene);
        call.enqueue(new Callback<GivenmedicieneData>() {
            @Override
            public void onResponse(Call<GivenmedicieneData> call, Response<GivenmedicieneData> response) {

                if (response.isSuccessful()) {

                    Log.d("fhgdc", "onResponse: "+response.body().getStatus());
                }
                else{
                    Log.d("fsdhgfj", "onResponse: ");
                    Log.d("fsdhgfj", "onResponse: "+response.body());
                    Log.d("fsdhgfj", "onResponse: "+response.body().getStatus());
                    Log.d("fsdhgfj", "onResponse: "+response.body().toString());
                    Log.d("fsdhgfj", "onResponse: "+response.toString());
                    Log.d("fsdhgfj", "onResponse: "+response.body().getError());

                }
            }

            @Override
            public void onFailure(Call<GivenmedicieneData> call, Throwable t) {

            }



        });
    }
}