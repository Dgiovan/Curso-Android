package com.example.retrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Clasifications {

    @SerializedName("classifications")
    @Expose
    private List<cReceta> classifications = null;

    @SerializedName("h1title")
    @Expose
    private String h1title;

    public Clasifications(String h1title) {
        this.h1title = h1title;
    }

    public Clasifications(List<cReceta> classifications) {
        this.classifications = classifications;
    }

    public String getH1title() {
        return h1title;
    }

    public void setH1title(String h1title) {
        this.h1title = h1title;
    }

    public List<cReceta> getClassifications() {
        return classifications;
    }

    public void setClassifications(List<cReceta> classifications) {
        this.classifications = classifications;
    }
}
