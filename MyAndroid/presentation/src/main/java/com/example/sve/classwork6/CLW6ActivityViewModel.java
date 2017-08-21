package com.example.sve.classwork6;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import com.example.sve.base.BaseViewModel;
import com.example.sve.domain.entity.ProfileId;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.interaction.ProfileUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


/**
 * Created by Sve on 14.08.2017.
 */

public class CLW6ActivityViewModel implements BaseViewModel {


      // ссылка на активити
    public Activity activity;

    public CLW6ActivityViewModel(Activity activity) {
        this.activity = activity;
    }



    @Override
    public void init() {

    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {


    }

    @Override
    public void pause() {


    }



}
