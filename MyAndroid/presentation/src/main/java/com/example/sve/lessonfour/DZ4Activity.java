package com.example.sve.lessonfour;


import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;

import com.example.sve.myandroid.R;


public class DZ4Activity extends AppCompatActivity {

    Time mytime;
    Handler handler;
    Runnable r;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz4);


        mytime = new Time();
        r = new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                mytime.setToNow();
                ClockView cl = new ClockView(DZ4Activity.this, mytime.hour, mytime.minute, mytime.second);
                setContentView(cl);
                handler.postDelayed(r, 1000);

            }
        };

        handler = new Handler();
        handler.postDelayed(r, 1000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
    }
}
