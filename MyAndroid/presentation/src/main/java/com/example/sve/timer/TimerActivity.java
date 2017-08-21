package com.example.sve.timer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sve.base.BaseActivity;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityTimerBinding;

/**
 * Created by Sve on 17.08.2017.
 */

public class TimerActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


    // создаем модель для этой активити
      TimerActivityViewModel viewModel = new TimerActivityViewModel(this);
     this.viewModel=viewModel;



        ActivityTimerBinding binding = DataBindingUtil
               .setContentView(this, R.layout.activity_timer);

        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);





    }
}