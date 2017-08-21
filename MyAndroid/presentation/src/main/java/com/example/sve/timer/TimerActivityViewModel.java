package com.example.sve.timer;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableLong;
import android.util.Log;

import com.example.sve.base.BaseViewModel;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TimerActivityViewModel implements BaseViewModel {

    public Activity activity;

    public TimerActivityViewModel(Activity activity) {
        this.activity = activity;
    }

    public ObservableLong age = new ObservableLong(0);

    Observable<Long> observable;
    private Disposable disposable;


    @Override
    public void init() {


    }


    @Override
    public void release() {

    }

    @Override
    public void resume() {

        disposable = observable.interval(1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(Long l) throws Exception {
                        return l % 2 == 0;
                    }
                })
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(@NonNull Long aLong) {
                        age.set(aLong);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void pause() {

        if (!disposable.isDisposed()) {
            disposable.dispose();
        }


    }


}
