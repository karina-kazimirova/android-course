package com.example.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.classwork2.Classwork2Activity;
import com.example.lessonone.DZ1Activity;
import com.example.R;
import com.example.lessontwo.DZ2Activity;

/**
 * Created by Sve on 26.07.2017.
 */

public class MainActivity extends AppCompatActivity {

   private View.OnClickListener listener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dz1Button = (Button) findViewById(R.id.dz1Button);
        Button dz2Button = (Button) findViewById(R.id.dz2Button);



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
                }
                startActivity(intent);
            }
        };

        dz1Button.setOnClickListener(listener);
        dz2Button.setOnClickListener(listener);

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
                break;


            case R.id.lesson_two:
                Intent intent1 = new Intent(MainActivity.this, DZ2Activity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
