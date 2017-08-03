package com.example.lessontwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.R;
import com.example.lessonone.DZ1Activity;
import com.example.main.MainActivity;

/**
 * Created by Sve on 27.07.2017.
 */

public class DZ2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz2);
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
                Intent intent = new Intent(DZ2Activity.this, DZ1Activity.class);
                startActivity(intent);
                break;


            case R.id.lesson_two:
                Intent intent1 = new Intent(DZ2Activity.this, DZ2Activity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.diagonaltranslate, R.anim.alpha);
    }


}
