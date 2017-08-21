package com.example.sve.classwork12;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;

import com.example.sve.base.BaseViewModel;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.interaction.GetProfileListUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Sve on 18.08.2017.
 */

public class CLW12ActivityViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    // ссылка на активити
    public Activity activity;

    // Ссылка на контекст
    public CLW12ActivityViewModel(Activity activity) {
        this.activity = activity;
    }

    private GetProfileListUseCase getProfileListUseCase = new GetProfileListUseCase();

    public ProfileAdapter adapter = new ProfileAdapter();



    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getProfileListUseCase.execute(null, new DisposableObserver<List<ProfileModel>>(){

            @Override
            public void onNext(List<ProfileModel> profileModels) {
                adapter.setItems(profileModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("AAAA items = ", e.toString());
            }

            @Override
            public void onComplete() {
                Log.e("AAAA item", "onComplete");
            }
        });
    }

    @Override
    public void pause() {
        //getProfileListUseCase.dispose();
    }
}
