package com.draft.retrofit.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class feedKiwi2 {
    @SerializedName("key")
@Expose
String key;
    @SerializedName("full")
    @Expose
String full;
    @SerializedName("language")
    @Expose
String language;
    @SerializedName("device")
    @Expose
String device;
    @SerializedName("human")
    @Expose
String human;


public feedKiwi2(String key, String full, String language, String device,String human) {
    this.key = key;
    this.full = full;
    this.language = language;
    this.device = device;
    this.human = human;
}

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public String getKey() {
    return key;
}

public void setKey(String key) {
    this.key = key;
}

public String getFull() {
    return full;
}

public void setFull(String full) {
    this.full = full;
}

public String getLanguage() {
    return language;
}

public void setLanguage(String language) {
    this.language = language;
}

public String getDevice() {
    return device;
}

public void setDevice(String device) {
    this.device = device;
}
}
