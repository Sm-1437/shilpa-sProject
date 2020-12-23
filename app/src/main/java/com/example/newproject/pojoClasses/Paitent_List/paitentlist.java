package com.example.newproject.pojoClasses.Paitent_List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class paitentlist {
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("RoomNo")
    @Expose
    private String roomNo;
    @SerializedName("Psrno")
    @Expose
    private String psrno;
    @SerializedName("PatientName")
    @Expose
    private String patientName;
    @SerializedName("Alergies")
    @Expose
    private String alergies;
    @SerializedName("Diagnoses")
    @Expose
    private String diagnoses;
    @SerializedName("ImgProfile")
    @Expose
    private String imgProfile;
    @SerializedName("FacilityCode")
    @Expose
    private String facilityCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getPsrno() {
        return psrno;
    }

    public void setPsrno(String psrno) {
        this.psrno = psrno;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAlergies() {
        return alergies;
    }

    public void setAlergies(String alergies) {
        this.alergies = alergies;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

}
