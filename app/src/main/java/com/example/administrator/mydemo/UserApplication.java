package com.example.administrator.mydemo;

import android.app.Application;

import com.example.administrator.mydemo.entity.AtDemand;
import com.example.administrator.mydemo.entity.TabAccount;

import java.util.ArrayList;
import java.util.List;

public class UserApplication extends Application {

    private static UserApplication singleton;
    private static final String VALUE = "Harvey";
    private String value;
    private TabAccount appTa;
    private List<AtDemand> appAd;
    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<AtDemand> getAppAd() {
        return appAd;
    }

    public void setAppAd(List<AtDemand> appAd) {
        this.appAd = appAd;
    }

    public TabAccount getAppTa() {
        return appTa;
    }

    public void setAppTa(TabAccount appTa) {
        this.appTa = appTa;
    }

    public static UserApplication getInstance(){
        return singleton;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setValue(VALUE);
        setAppTa(null);
        setAppAd(null);
        singleton = this;
        setLongitude(0.0);
        setLatitude(0.0);
    }

}
