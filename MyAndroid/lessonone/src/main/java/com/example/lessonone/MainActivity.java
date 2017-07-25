package com.example.lessonone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView firstTextView;
    private TextView secondTextView;
    private Button button;
    private View.OnClickListener firstTextListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstTextView = (TextView) findViewById(R.id.firstTextView);
        firstTextView.setText(R.string.first_text);

        secondTextView = (TextView) findViewById(R.id.secondTextView);
        secondTextView.setText(R.string.second_text);
        secondTextView.setOnClickListener(this);

        button = (Button) findViewById(R.id.button);
        button.setText(R.string.button_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String one = firstTextView.getText().toString();
                    String two = secondTextView.getText().toString();
                    firstTextView.setText(two);
                    secondTextView.setText(one);
            }
        });

        firstTextListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String one = firstTextView.getText().toString();
                String two = secondTextView.getText().toString();
                firstTextView.setText(two);
                secondTextView.setText(one);
            }
        };

        firstTextView.setOnClickListener(firstTextListener);

    }

    @Override
    public void onClick(View v) {

                String one = firstTextView.getText().toString();
                String two = secondTextView.getText().toString();
                firstTextView.setText(two);
                secondTextView.setText(one);

    }
}
