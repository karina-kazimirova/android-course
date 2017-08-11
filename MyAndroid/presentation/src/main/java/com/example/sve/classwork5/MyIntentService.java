package com.example.sve.classwork5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Sve on 02.08.2017.
 */

public class MyIntentService extends IntentService {

    public static final String KEY_ACTION = "KEY_ACTION";

    public static final String MY_ACTION = "com.example.classwork5.MY_ACTION";



    // Работает в отдельном потоке.
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action = intent.getStringExtra(KEY_ACTION);
       // Log.e("HHH", "onHandleIntent() action = "+ action);




        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentreceiver = new Intent(MY_ACTION);

        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);


        sendBroadcast(intentreceiver);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("HHH", "onDestroy");
    }
}
