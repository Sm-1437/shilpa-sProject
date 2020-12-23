package com.example.newproject.pojoClasses.Alfpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlfList {
    @SerializedName("ALFRole")
    @Expose
    private String aLFRole;
    @SerializedName("RoleType")
    @Expose
    private String roleType;
    @SerializedName("Menu")
    @Expose
    private String menu;
    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("ImgURL")
    @Expose
    private String imgURL;

    public String getALFRole() {
        return aLFRole;
    }

    public void setALFRole(String aLFRole) {
        this.aLFRole = aLFRole;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

}