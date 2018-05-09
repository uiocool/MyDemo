package com.example.administrator.mydemo;

import android.app.Application;

import com.example.administrator.mydemo.entity.TabAccount;

public class UserApplication extends Application {

    private static UserApplication singleton;
    private static final String VALUE = "Harvey";
    private String value;
    private TabAccount appTa;

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
        singleton = this;
    }

}
