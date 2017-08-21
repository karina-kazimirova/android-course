package com.example.sve.classwork12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sve.base.BaseActivity;
import com.example.sve.classwork9.ClassWork9ViewModel;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityClw12Binding;

/**
 * Created by Sve on 18.08.2017.
 */

public class CLW12Activity  extends BaseActivity {

    //private RecyclerView.Adapter adapter;


    public static void show(Activity activity){
        Intent intent = new Intent(activity, CLW12Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        CLW12ActivityViewModel viewModel = new CLW12ActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityClw12Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_clw12);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(viewModel.adapter);


        super.onCreate(savedInstanceState);
    }
}
