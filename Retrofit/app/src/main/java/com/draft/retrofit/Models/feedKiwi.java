package com.draft.retrofit.Models;

public class feedKiwi {

String key;
String full;
String language;
String device;


public feedKiwi(String key, String full, String language, String device) {
    this.key = key;
    this.full = full;
    this.language = language;
    this.device = device;
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
