package com.example.newproject.pojoClasses.MedicationPOjo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicationList {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("error")
    @Expose
    private Object error;
    @SerializedName("NoOfRecord")
    @Expose
    private Integer noOfRecord;
    @SerializedName("DBName")
    @Expose
    private Object dBName;
    @SerializedName("DBConnString")
    @Expose
    private Object dBConnString;
    @SerializedName("listdata")
    @Expose
    private List<MedicationData> listdata = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Integer getNoOfRecord() {
        return noOfRecord;
    }

    public void setNoOfRecord(Integer noOfRecord) {
        this.noOfRecord = noOfRecord;
    }

    public Object getDBName() {
        return dBName;
    }

    public void setDBName(Object dBName) {
        this.dBName = dBName;
    }

    public Object getDBConnString() {
        return dBConnString;
    }

    public void setDBConnString(Object dBConnString) {
        this.dBConnString = dBConnString;
    }

    public List<MedicationData> getListdata() {
        return listdata;
    }

    public void setListdata(List<MedicationData> listdata) {
        this.listdata = listdata;
    }

}