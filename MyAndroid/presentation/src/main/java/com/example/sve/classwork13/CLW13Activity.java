package com.example.sve.classwork13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.sve.myandroid.R;

/**
 * Created by Sve on 21.08.2017.
 */
// Для создания фрагмента наследуемся от FragmentActivity(в supprot.v4)
public class CLW13Activity extends FragmentActivity {

    public static void show(Activity activity){
        Intent intent = new Intent(activity, CLW13Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clw13);




        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), new ClW13Fragment());

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    // метод для создания всех фрагментов
    public static  void showFragment(FragmentManager fragmentManager, Fragment fragment){

        // блок кода в котором должны выполнится все действия
        // сюда добавляются анимации появления и тд
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // указываем что хотим заменить - container из xml в котором находится fragment
        fragmentTransaction.replace(R.id.container, fragment, null);
        // выполняем предыдущее
        fragmentTransaction.commit();


    }
}
