package com.example.newproject.Api;

import com.example.newproject.pojoClasses.Alfpojo.Alfmain;
import com.example.newproject.pojoClasses.Dashboardpojo.Dashboardpojo;
import com.example.newproject.pojoClasses.Givenmediciene.GivenmedicieneData;
import com.example.newproject.pojoClasses.Medcount.MedcountDATA;
import com.example.newproject.pojoClasses.MedicationPOjo.MedicationList;
import com.example.newproject.pojoClasses.Paitent_List.Patientdata;
import com.example.newproject.pojoClasses.TablePOjo.TAblepojo;
import com.example.newproject.pojoClasses.loginpojo.LoginPOjo;
import com.example.newproject.pojoClasses.loginpojo.Loginpoup;
import com.example.newproject.pojoClasses.loginpojo.StoreloginPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiinterface {
    @FormUrlEncoded
    @POST("validate-store")
    Call<StoreloginPojo> storelogin(
            @Field("store") String store
    );
 @FormUrlEncoded
    @POST("login")
    Call<LoginPOjo> login(
            @Field("store") String store,
            @Field("email") String email,
            @Field("password") String password
    );
 @FormUrlEncoded
    @POST("PharmaLogin.asmx/LoginToPharmacy")
    Call<Loginpoup> loginpop(
            @Field("UserName") String UserName,
            @Field("Email") String Email
    );
 @FormUrlEncoded
    @POST("PharmaLogin.asmx/DashBoardToPharmacy")
    Call<Dashboardpojo> dashboard(
            @Field("PharmaRole") String PharmaRole
    );
 @FormUrlEncoded
    @POST("ALF.asmx/ShowALF")
    Call<TAblepojo> showalf(
            @Field("Organisation_ID") String Organisation_ID
    );
 @FormUrlEncoded
    @POST("Resident.asmx/showMedicationRecord")
    Call<MedicationList> paitient(
            @Field("psrNo") String psrNo,
            @Field("ALF_Id") String ALF_Id,
            @Field("timeslot") String timeslot
    );
 @FormUrlEncoded
    @POST("Resident.asmx/ShowPatientList")
    Call<Patientdata> list(
            @Field("ALF_Id") String ALF_Id,
            @Field("timeslot") String timeslot
    );
 @FormUrlEncoded
    @POST("Resident.asmx/GiveMedicine")
    Call<GivenmedicieneData> mediceine(
            @Field("medjson") String medjson
    );
@FormUrlEncoded
    @POST("Resident.asmx/GetMedCount")
    Call<MedcountDATA> COUNT(
            @Field("ALF_ID") String ALF_ID,
            @Field("timeslot") String timeslot
    );

 @FormUrlEncoded
    @POST("PharmaLogin.asmx/DashBoardToALF")
    Call<Alfmain> Alficon(
            @Field("ALFRole") String ALFRole
    );
    @GET("getdata.php")
    Call<List<ImageList>> geImgData();

}
