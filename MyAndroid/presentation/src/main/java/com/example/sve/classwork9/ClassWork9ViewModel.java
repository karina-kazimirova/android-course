package com.example.sve.classwork9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.AsyncTask;
import android.util.Log;

import com.example.sve.base.BaseViewModel;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.entity.ProfileId;
import com.example.sve.domain.interaction.ProfileUseCase;
import com.example.sve.domain.interaction.SaveProfileUseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Sve on 09.08.2017.
 */

public class ClassWork9ViewModel implements BaseViewModel{




    // Состояние экрана
    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);


    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt(5);

    private ProfileUseCase useCase = new ProfileUseCase();

    // для сохранения данных
    private SaveProfileUseCase saveProfileUseCase = new SaveProfileUseCase();




    // ссылка на активити
    public Activity activity;

    public ClassWork9ViewModel(Activity activity) {
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

        // сохраняем данные
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName("gg");
        profileModel.setSurname("frfr");
        profileModel.setAge(23);
        saveProfileUseCase.execute(profileModel, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.e("Aaa", "ok");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("Aaa", "erro = " + e);

            }

            @Override
            public void onComplete() {

            }
        });

        //ghb каждом развороте экрана - получать данные
        ProfileId profileId = new ProfileId();
        profileId.setId("123");


        // запрос usecase - и ответ получаем в этот метод (как OnclickListenner)
        useCase.execute(profileId, new DisposableObserver<ProfileModel>() {
            @Override
            public void onNext(@NonNull ProfileModel profile) {
                // подписка на получение информации
                name.set(profile.getName());
                surname.set(profile.getSurname());
                age.set(profile.getAge());
                // для ENUM состояние
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {

                Log.e("AAA", "error = ", e);

            }

            @Override
            public void onComplete() {

            }
        });


    }

    @Override
    public void pause() {
        // отписываемся от Observale
        useCase.dispose();


    }

    public void onSuperButtonClick(){
        Log.e("KKK", "Click");

        // переходим на активити

       // Intent intent = new Intent(this, Lesson3Activity.class);
       // activity.startActivity(intent);
    }



}
