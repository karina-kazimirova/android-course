package com.example.sve.lesson8;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.sve.base.BaseActivity;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityCl8Binding;


/**
 * Created by Sve on 09.08.2017.
 */

public class ClassWork8Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        // создаем модель для этой активити
        ClassWork8ViewModel viewModel = new ClassWork8ViewModel(this);
        this.viewModel = viewModel;

        ActivityCl8Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_cl8);

        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);




    }
}
