package com.example.sve.classwork2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sve.lessonone.DZ1Activity;
import com.example.sve.myandroid.R;


/**
 * Created by Sve on 26.07.2017.
 */

public class Classwork2Activity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classwork2);

        final EditText username = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Classwork2Activity.this, DZ1Activity.class);

                intent.putExtra(DZ1Activity.KEY_USERNAME, username.getText().toString());
                intent.putExtra(DZ1Activity.KEY_PASSWORD, password.getText().toString());

                startActivity(intent);
            }
        });
    }
}
