package com.example.sve.lessonseven;


import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sve.myandroid.R;

import com.example.sve.myandroid.databinding.ActivityDz7Binding;


/**
 * Created by Sve on 10.08.2017.
 */

public class DZ7Activity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityDz7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_dz7);

        User user = new User("Иванова И.И.", "жен", "20","http://babysit.pamconsult.by/wp-content/uploads/2017/06/candidat-01.jpg",  false);
        binding.setUser(user);
    }

    public class User extends BaseObservable {
        public final String fio;
        public final String pol;
        public String age;
        public String photoUrl;
        public boolean isMan;

        public User(String fio, String pol, String age, String photoUrl, boolean isMan) {
            this.fio = fio;
            this.pol = pol;
            this.age = age;
            this.photoUrl = photoUrl;
            this.isMan = isMan;
        }


    }


    }


