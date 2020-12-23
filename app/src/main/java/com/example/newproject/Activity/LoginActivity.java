package com.example.newproject.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newproject.Api.Apiinterface;
import com.example.newproject.Api.RetrofitInstance;
import com.example.newproject.pojoClasses.loginpojo.LoginPOjo;
import com.example.newproject.R;
import com.example.newproject.pojoClasses.loginpojo.Loginpoup;
import com.example.newproject.pojoClasses.loginpojo.StoreloginPojo;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button btn_sumbit,btn_forgot;
    TextInputLayout login_StoreCode,login_email,login_password;
    TextInputEditText login_Store_editText,login_email_editText,login_password_editText;
    String TAG="@@#@#@#";
    ImageView fingerprint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        btn_sumbit=findViewById(R.id.btn_sumbit);
        fingerprint=findViewById(R.id.fingerprint);
        btn_forgot=findViewById(R.id.btn_forgot);
        login_StoreCode=findViewById(R.id.login_StoreCode);
        login_email=findViewById(R.id.login_email);
        login_email_editText=findViewById(R.id.login_email_editText);
        login_Store_editText=findViewById(R.id.login_Store_editText);
        login_password=findViewById(R.id.login_password);
        login_password_editText=findViewById(R.id.login_password_editText);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        btn_sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();


            }
        });
        login_Store_editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                storelogin();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        Executor newExecutor = Executors.newSingleThreadExecutor();

        FragmentActivity activity = this;

//Start listening for authentication events//

        final BiometricPrompt myBiometricPrompt = new BiometricPrompt(activity, newExecutor, new BiometricPrompt.AuthenticationCallback() {
            @Override

//onAuthenticationError is called when a fatal error occurrs//

            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                if (errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON) {
                } else {

//Print a message to Logcat//

                    Log.d(TAG, "An unrecoverable error occurred");
                }
            }

//onAuthenticationSucceeded is called when a fingerprint is matched successfully//

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Log.d(TAG, "onAuthenticationSucceeded: "+result.toString());
                Log.d(TAG, "Fingerprint recognised successfully");


            }

//onAuthenticationFailed is called when the fingerprint doesn’t match//

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();

//Print a message to Logcat//

                Log.d(TAG, "Fingerprint not recognised");
            }
        });

//Create the BiometricPrompt instance//

        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()

//Add some text to the dialog//

                .setTitle("Title text goes here")
                .setSubtitle("Subtitle goes here")
                .setDescription("This is the description")
                .setNegativeButtonText("Cancel")

//Build the dialog//

                .build();

//Assign an onClickListener to the app’s “Authentication” button//

        fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBiometricPrompt.authenticate(promptInfo);
                Log.d(TAG, "onClick: "+promptInfo);
            }
        });

    }


    public void storelogin(){
       Apiinterface apiinterface = RetrofitInstance.getRetrofitInstance().create(Apiinterface.class);
        Call<StoreloginPojo> call=apiinterface.storelogin(login_Store_editText.getText().toString());
        call.enqueue(new Callback<StoreloginPojo>() {
            @Override
            public void onResponse(Call<StoreloginPojo> call, Response<StoreloginPojo> response) {
              if(response.isSuccessful()){
                  if(response.body().getStatus()==1){
                      Log.d(TAG, "onResponse: "+response.body().getStatus());
                      Log.d(TAG, "onResponse: "+response.body().getMessage());
                      login_StoreCode.setError(null);
                  }
                  else{
                      login_StoreCode.setError("Enter Correct Store Code");
                      Log.d(TAG, "onResponse: "+response.body().getMessage());
                      Log.d(TAG, "onResponse: "+response.body().getStatus());
                  }
              }
            }

            @Override
            public void onFailure(Call<StoreloginPojo> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
                Log.d(TAG, "onFailure: "+t.getMessage());
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
            }
        });
    }
    public void loginppopup(String user,String email){
       Apiinterface apiinterface = RetrofitInstance.getRetrofit().create(Apiinterface.class);
        Call<Loginpoup> call=apiinterface.loginpop(user,email);
        call.enqueue(new Callback<Loginpoup>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<Loginpoup> call, Response<Loginpoup> response) {
              if(response.isSuccessful()){
                     Log.v(TAG, "onResponse: "+response.body().getStatus());
                     Log.v(TAG, "onResponse: "+response.body().getDBName());
                  if(response.body().getListdata()!=null) {

                      for (int i = 0; i < response.body().getListdata().size(); i++) {
                          AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                          LayoutInflater inflater = (LoginActivity.this).getLayoutInflater();

                          View dialogView = inflater.inflate(R.layout.login_suceess, null);
                          builder.setView(dialogView);




                          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            Date date1=new Date();
//                         String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                          Button button = dialogView.findViewById(R.id.button);
                          TextView txt_name = dialogView.findViewById(R.id.txt_name);
                          TextView clocllkk = dialogView.findViewById(R.id.clocllkk);
                          RadioButton clockout = dialogView.findViewById(R.id.clockout);
                          RadioButton clock = dialogView.findViewById(R.id.clock);
                          ImageView logo = dialogView.findViewById(R.id.logo);

//                          clocllkk.setText(" Clock Time:-" + " " + (sdf.format(calendar.getTime())));
                          clocllkk.setText(" Clock Time:-" + " " + date1);

                          txt_name.setText(response.body().getListdata().get(i).getFName());
                          SharedPreferences preferences = getSharedPreferences("Mypref", MODE_PRIVATE);
                          SharedPreferences.Editor editor = preferences.edit();
                          editor.putString("User_for", response.body().getListdata().get(i).getUserFor());
                          editor.putString("name", response.body().getListdata().get(i).getFName() + response.body().getListdata().get(i).getLName());
                          editor.putString("Pharma_role", response.body().getListdata().get(i).getPharmaRole());
                          editor.putString("Alf_role", response.body().getListdata().get(i).getALFRole());
                          editor.putString("Org_id", response.body().getListdata().get(i).getOrgID());
                          Log.d(TAG, "onResponse: " + response.body().getListdata().get(i).getUserFor());
                          Log.d(TAG, "onResponse: " + response.body().getListdata().get(i).getPharmaRole());
                          Log.d(TAG, "onResponse: " + response.body().getListdata().get(i).getALFRole());
                          Log.d(TAG, "onResponse: " + response.body().getListdata().get(i).getOrgID());
                          editor.commit();
                          editor.clear();
                          clockout.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  clock.isChecked();
                                  clock.setChecked(true);
                              }
                          });
                          button.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  if (response.body().getListdata().get(0).getUserFor().equals("P,A")) {
                                      Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                                      startActivity(i);
                                      finish();
                                  } else if (response.body().getListdata().get(0).getUserFor().equals("P")) {
                                      Intent i = new Intent(LoginActivity.this, DashboardActivity.class);
                                      startActivity(i);
                                      finish();
                                  } else if (response.body().getListdata().get(0).getUserFor().equals("A")) {
                                      Intent i = new Intent(LoginActivity.this, AssitedLivingFacilityActivity.class);
                                      startActivity(i);
                                  }
                              }
                          });
                          builder.create();
                          builder.show();
                      }
                  }
                  else{
                      Toast.makeText(LoginActivity.this, "No data found of this user", Toast.LENGTH_LONG).show();
                  }
              }
              else{
                  Toast.makeText(LoginActivity.this, "No data found of this user", Toast.LENGTH_LONG).show();
              }
            }

            @Override
            public void onFailure(Call<Loginpoup> call, Throwable t) {
                Log.v(TAG, "onFailurepopup: "+t);
                Log.v(TAG, "onFailurepoup: "+t.getMessage());
                Log.v(TAG, "onFailurepoup: "+t.getLocalizedMessage());
            }
        });
    }
    public void login(){
       Apiinterface apiinterface =RetrofitInstance.getRetrofitInstance().create(Apiinterface.class);
        Call<LoginPOjo> call=apiinterface.login(login_Store_editText.getText().toString(),login_email_editText.getText().toString(),login_password_editText.getText().toString());
        call.enqueue(new Callback<LoginPOjo>() {
            @Override
            public void onResponse(Call<LoginPOjo> call, Response<LoginPOjo> response) {
              if(response.isSuccessful()){
                  if(response.body().getStatus()==1) {
                      loginppopup(login_Store_editText.getText().toString(),login_email_editText.getText().toString());
                      Log.d(TAG, "onResponse: " + response.body().getStatus());
                      Log.d(TAG, "onResponse: " + response.body().getMessage());
                      login_StoreCode.setError(null);
                      login_email.setError(null);
                      login_password.setError(null);

                      if (response.body().getProduct().equals("Retail")) {

                          Toast.makeText(LoginActivity.this, "Login As A Retail", Toast.LENGTH_LONG).show();
                          Log.d(TAG, "onResponse: Retail"+" "+response.body().getProduct());
                      }
                      else if(response.body().getProduct().equals("SteerMAR")){
                          Toast.makeText(LoginActivity.this, "Login As A SteerMAR", Toast.LENGTH_SHORT).show();
                          Log.d(TAG, "onResponse:SteerMAR "+" "+response.body().getProduct());
                      }
                      else if(response.body().getProduct().equals("Pharmacy")){
                          Toast.makeText(LoginActivity.this, "Login As A Pharamacy", Toast.LENGTH_SHORT).show();
                          Log.d(TAG, "onResponse: Pharmacy"+""+response.body().getProduct());
                      } else if(response.body().getProduct().equals("Restaurant")){
                          Toast.makeText(LoginActivity.this, "Login As A Restaurant", Toast.LENGTH_SHORT).show();
                          Log.d(TAG, "onResponse: "+response.body().getProduct());
                      }
                      else{
                          Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                      }
                  }
                  else{
                      login_email.setError("Enter Vaild Email");
                      login_password.setError("Enter Valid Password");
                      Log.d(TAG, "onResponse: "+response.body().getMessage());
                      Log.d(TAG, "onResponse: "+response.body().getStatus());
                  }
              }
            }

            @Override
            public void onFailure(Call<LoginPOjo> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
                Log.d(TAG, "onFailure: "+t.getMessage());
                Log.d(TAG, "onFailure: "+t.getLocalizedMessage());
            }
        });
    }

}