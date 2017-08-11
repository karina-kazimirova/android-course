package com.example.sve.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.sve.classwork6.CLW6Activity;
import com.example.sve.classwork7.CLW7Activity;
import com.example.sve.lesson8.ClassWork8Activity;
import com.example.sve.lessonfive.DZ5Activity;
import com.example.sve.lessonfour.DZ4Activity;
import com.example.sve.lessonfour.Dz4NewActivity;
import com.example.sve.lessonone.DZ1Activity;
import com.example.sve.lessonseven.DZ7Activity;
import com.example.sve.lessonthree.DZ3Activity;
import com.example.sve.lessontwo.DZ2Activity;
import com.example.sve.myandroid.R;


/**
 * Created by Sve on 26.07.2017.
 */

public class MainActivity extends AppCompatActivity {

   private View.OnClickListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstmain);

        // ContextCompat - проверка на разрешения

        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        Button dz2Button = (Button) findViewById(R.id.dz2Button);
        Button dz3Button = (Button) findViewById(R.id.dz3Button);
        Button dz4Button = (Button) findViewById(R.id.dz4Button);
        Button dz4newButton = (Button) findViewById(R.id.dz4newButton);
        Button dz5Button = (Button) findViewById(R.id.dz5Button);
        Button clw6Button = (Button) findViewById(R.id.clw6Button);
        Button clw7Button = (Button) findViewById(R.id.clw7Button);
        Button clw8Button = (Button) findViewById(R.id.clw8Button);
        Button dz7Button = (Button) findViewById(R.id.dz7Button);



       listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;

                switch (v.getId()){
                    case R.id.dz1Button:
                       intent = new Intent(MainActivity.this, DZ1Activity.class);
                        break;

                    case R.id.dz2Button:
                        intent = new Intent(MainActivity.this, DZ2Activity.class);
                        break;

                    case R.id.dz3Button:
                        intent = new Intent(MainActivity.this, DZ3Activity.class);
                        break;

                    case R.id.dz4Button:
                        intent = new Intent(MainActivity.this, DZ4Activity.class);
                        break;

                    case R.id.dz4newButton:
                        intent = new Intent(MainActivity.this, Dz4NewActivity.class);
                        break;
                    case R.id.dz5Button:
                        intent = new Intent(MainActivity.this, DZ5Activity.class);
                        break;
                    case R.id.clw6Button:
                        intent = new Intent(MainActivity.this, CLW6Activity.class);
                        break;
                    case R.id.clw7Button:
                        intent = new Intent(MainActivity.this, CLW7Activity.class);
                        break;
                    case R.id.clw8Button:
                        intent = new Intent(MainActivity.this, ClassWork8Activity.class);
                        break;

                    case R.id.dz7Button:
                        intent = new Intent(MainActivity.this, DZ7Activity.class);
                        break;


                }


                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
            }
        };

        dz1Button.setOnClickListener(listener);
        dz2Button.setOnClickListener(listener);
        dz3Button.setOnClickListener(listener);
        dz4Button.setOnClickListener(listener);
        dz4newButton.setOnClickListener(listener);
        dz5Button.setOnClickListener(listener);
        clw6Button.setOnClickListener(listener);
        clw7Button.setOnClickListener(listener);
        clw8Button.setOnClickListener(listener);
        dz7Button.setOnClickListener(listener);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.lesson_one:
                Intent intent = new Intent(MainActivity.this, DZ1Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                break;

            case R.id.lesson_two:
                Intent intent1 = new Intent(MainActivity.this, DZ2Activity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                break;

            case R.id.lesson_three:
                Intent intent2 = new Intent(MainActivity.this, DZ3Activity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}