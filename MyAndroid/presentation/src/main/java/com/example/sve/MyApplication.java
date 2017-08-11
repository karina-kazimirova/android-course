package com.example.sve;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Sve on 31.07.2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
