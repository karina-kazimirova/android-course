package com.example.sve.lessonone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sve.lessontwo.DZ2Activity;
import com.example.sve.myandroid.R;


public class DZ1Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView firstTextView;
    private TextView secondTextView;
    private Button button;
    private View.OnClickListener firstTextListener;

    public static final String KEY_USERNAME ="KEY_USERNAME";
    public static final String KEY_PASSWORD ="KEY_PASSWORD";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dz1);

        //String username = getIntent().getStringExtra(KEY_USERNAME);
        //String password = getIntent().getStringExtra(KEY_PASSWORD);


        firstTextView = (TextView) findViewById(R.id.firstTextView);
        firstTextView.setText(R.string.first_text);
        //firstTextView.setText(username);

        secondTextView = (TextView) findViewById(R.id.secondTextView);
        secondTextView.setText(R.string.second_text);
        //secondTextView.setText(password);
        secondTextView.setBackgroundResource(R.color.colorAccent);
        secondTextView.setOnClickListener(this);

        button = (Button) findViewById(R.id.button);
        button.setText(R.string.button_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeItems();
            }
        });

        firstTextListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeItems();
            }
        };

        firstTextView.setOnClickListener(firstTextListener);

    }

    private void changeItems(){
        String one = firstTextView.getText().toString();
        String two = secondTextView.getText().toString();
        firstTextView.setText(two);
        secondTextView.setText(one);

    }

    @Override
    public void onClick(View v) {

        changeItems();
        Toast.makeText(this, "Нажат текст 2", Toast.LENGTH_LONG).show();


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
                Intent intent = new Intent(DZ1Activity.this, DZ1Activity.class);
                startActivity(intent);
                break;


            case R.id.lesson_two:
                Intent intent1 = new Intent(DZ1Activity.this, DZ2Activity.class);
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
