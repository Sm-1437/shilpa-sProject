package com.example.newproject.pojoClasses.loginpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPOjo {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("product")
    @Expose
    private String product;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

}
