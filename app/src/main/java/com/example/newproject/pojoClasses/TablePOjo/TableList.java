package com.example.newproject.pojoClasses.TablePOjo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableList {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("NursingHomeName")
    @Expose
    private String nursingHomeName;
    @SerializedName("Facilitiescode")
    @Expose
    private String facilitiescode;
    @SerializedName("FacilityId")
    @Expose
    private String facilityId;
    @SerializedName("Organisation_ID")
    @Expose
    private String organisationID;
    @SerializedName("IsActive")
    @Expose
    private String isActive;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNursingHomeName() {
        return nursingHomeName;
    }

    public void setNursingHomeName(String nursingHomeName) {
        this.nursingHomeName = nursingHomeName;
    }

    public String getFacilitiescode() {
        return facilitiescode;
    }

    public void setFacilitiescode(String facilitiescode) {
        this.facilitiescode = facilitiescode;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(String organisationID) {
        this.organisationID = organisationID;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

}
