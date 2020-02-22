package com.draft.retrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class aaa {

    @SerializedName("classifications")
    @Expose
    private List<rsponseclasification> classifications = null;
    @SerializedName("family")
    @Expose
    private String family;


    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public List<rsponseclasification> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<rsponseclasification> classifications) {
        this.classifications = classifications;
    }
}
