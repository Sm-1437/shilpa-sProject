
package com.example.newproject.pojoClasses.loginpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Listdatum {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("LastLogin")
    @Expose
    private String lastLogin;
    @SerializedName("FacilityCode")
    @Expose
    private String facilityCode;
    @SerializedName("IsValid")
    @Expose
    private String isValid;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("ALFRole")
    @Expose
    private String aLFRole;
    @SerializedName("FName")
    @Expose
    private String fName;
    @SerializedName("LName")
    @Expose
    private String lName;
    @SerializedName("Initials")
    @Expose
    private String initials;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("ReEnterPassword")
    @Expose
    private String reEnterPassword;
    @SerializedName("IsRestrict")
    @Expose
    private String isRestrict;
    @SerializedName("OrgID")
    @Expose
    private String orgID;
    @SerializedName("UserFor")
    @Expose
    private String userFor;
    @SerializedName("PharmaRole")
    @Expose
    private String pharmaRole;
    @SerializedName("ASLid")
    @Expose
    private String aSLid;
    @SerializedName("IsFirstTymLogin")
    @Expose
    private String isFirstTymLogin;
    @SerializedName("LastLogin1")
    @Expose
    private String lastLogin1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getALFRole() {
        return aLFRole;
    }

    public void setALFRole(String aLFRole) {
        this.aLFRole = aLFRole;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReEnterPassword() {
        return reEnterPassword;
    }

    public void setReEnterPassword(String reEnterPassword) {
        this.reEnterPassword = reEnterPassword;
    }

    public String getIsRestrict() {
        return isRestrict;
    }

    public void setIsRestrict(String isRestrict) {
        this.isRestrict = isRestrict;
    }

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public String getPharmaRole() {
        return pharmaRole;
    }

    public void setPharmaRole(String pharmaRole) {
        this.pharmaRole = pharmaRole;
    }

    public String getASLid() {
        return aSLid;
    }

    public void setASLid(String aSLid) {
        this.aSLid = aSLid;
    }

    public String getIsFirstTymLogin() {
        return isFirstTymLogin;
    }

    public void setIsFirstTymLogin(String isFirstTymLogin) {
        this.isFirstTymLogin = isFirstTymLogin;
    }

    public String getLastLogin1() {
        return lastLogin1;
    }

    public void setLastLogin1(String lastLogin1) {
        this.lastLogin1 = lastLogin1;
    }

}