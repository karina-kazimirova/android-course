package com.example.sve.lessonfive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.sve.myandroid.R;


/**
 * Created by Sve on 03.08.2017.
 */

public class DZ5Activity  extends AppCompatActivity{

    String state = null;
    IntentFilter intentFilter = new IntentFilter("com.example.lessonfive.MY_ACTION");
    private TextView textMessage;


    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver1, intentFilter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz5);
        startService(new Intent(this, MyService.class));

        textMessage = (TextView) findViewById(R.id.textMessage);
    }

    @Override
    protected void onPause() {

        super.onPause();
        stopService(new Intent(this, MyService.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopService(new Intent(this, MyService.class));
    }

    @Override
    public void onResume() {
        super.onResume();

    }



    private BroadcastReceiver receiver1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent1) {

            state = intent1.getStringExtra("state");
            Log.e("LLL", state);

            textMessage.setText(state);

            }

    };


}
