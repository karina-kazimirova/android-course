package com.example.classwork5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Sve on 02.08.2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AAA", "onReceiver");

        // МОЖНО ПИСАТЬ NOTIFICATION

    }
}
