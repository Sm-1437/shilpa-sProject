package com.example.newproject.pojoClasses.Medcount;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medcountlist {
    @SerializedName("MEDCOUNT")
    @Expose
    private String mEDCOUNT;
    @SerializedName("psrno")
    @Expose
    private String psrno;

    public String getMEDCOUNT() {
        return mEDCOUNT;
    }

    public void setMEDCOUNT(String mEDCOUNT) {
        this.mEDCOUNT = mEDCOUNT;
    }

    public String getPsrno() {
        return psrno;
    }

    public void setPsrno(String psrno) {
        this.psrno = psrno;
    }

}
