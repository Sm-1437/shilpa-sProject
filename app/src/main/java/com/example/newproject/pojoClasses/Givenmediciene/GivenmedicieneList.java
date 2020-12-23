package com.example.newproject.pojoClasses.Givenmediciene;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GivenmedicieneList {
    @SerializedName("323")
    @Expose
    private String _323;
    @SerializedName("324")
    @Expose
    private String _324;

    public String get323() {
        return _323;
    }

    public void set323(String _323) {
        this._323 = _323;
    }

    public String get324() {
        return _324;
    }

    public void set324(String _324) {
        this._324 = _324;
    }


}
