package com.example.retrofit.Models;

public class cReceta {

   private String icon;
   private String shorttitle;

    public cReceta(String icon, String shorttitle) {
        this.icon = icon;
        this.shorttitle = shorttitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShorttitle() {
        return shorttitle;
    }

    public void setShorttitle(String shorttitle) {
        this.shorttitle = shorttitle;
    }
}
