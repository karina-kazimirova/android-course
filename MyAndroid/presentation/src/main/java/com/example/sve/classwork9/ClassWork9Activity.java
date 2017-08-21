package com.example.sve.classwork9;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sve.base.BaseActivity;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityCl9Binding;


/**
 * Created by Sve on 09.08.2017.
 */

public class ClassWork9Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // создаем модель для этой активити
        ClassWork9ViewModel viewModel = new ClassWork9ViewModel(this);
        this.viewModel = viewModel;

        ActivityCl9Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_cl9);

        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);




    }
}
