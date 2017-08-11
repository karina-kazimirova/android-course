package com.example.sve.classwork7;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityClasswork7Binding;



/**
 * Created by Sve on 07.08.2017.
 */

public class CLW7Activity extends AppCompatActivity {
    //тип переменной которая автоматичсески меняется из xml
    public ObservableField<String> myText = new ObservableField<>("Ура");
    private Thread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



     ActivityClasswork7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_classwork7);

     //  Ссылку на эту активити отправлям в xml
      binding.setActivity(this);

        // обращаемся к id в хмl
        //binding.superTextView.setText("frfrfrfrf");

    }

    @Override
    protected void onResume() {
        super.onResume();
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<3; i++){

                    final int a = i;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {


                    }


                        // обращаемся из основного потока
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myText.set(String.valueOf(a));
                            }

                        });

                }
            }
        });
        thread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }
}
