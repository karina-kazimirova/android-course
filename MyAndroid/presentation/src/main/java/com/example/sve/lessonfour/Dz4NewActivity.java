package com.example.sve.lessonfour;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sve.myandroid.R;


/**
 * Created by Sve on 03.08.2017.
 */

public class Dz4NewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dznew4);


        ImageView owl = (ImageView) findViewById(R.id.owl);
        owl.setBackgroundResource(R.drawable.owl_animation);
        final AnimationDrawable animation = (AnimationDrawable)owl.getBackground();

        final Button btnStart = (Button) findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                animation.start();
            }
        });

        final Button btnStop = (Button) findViewById(R.id.buttonStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                animation.stop();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
    }



}














