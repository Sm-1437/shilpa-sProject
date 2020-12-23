package com.example.newproject.pojoClasses.Dashboardpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardList {


        @SerializedName("PharmaRole")
        @Expose
        private String pharmaRole;
        @SerializedName("f_id")
        @Expose
        private String fId;
        @SerializedName("f_name")
        @Expose
        private String fName;
        @SerializedName("imgurl")
        @Expose
        private String imgurl;

        public String getPharmaRole() {
            return pharmaRole;
        }

        public void setPharmaRole(String pharmaRole) {
            this.pharmaRole = pharmaRole;
        }

        public String getFId() {
            return fId;
        }

        public void setFId(String fId) {
            this.fId = fId;
        }

        public String getFName() {
            return fName;
        }

        public void setFName(String fName) {
            this.fName = fName;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }


}
