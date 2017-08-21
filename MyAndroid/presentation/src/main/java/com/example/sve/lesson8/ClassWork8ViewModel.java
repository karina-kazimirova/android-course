package com.example.sve.lesson8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.example.sve.base.BaseViewModel;
import com.example.sve.lessonthree.Lesson3Activity;

import java.util.Observable;

/**
 * Created by Sve on 09.08.2017.
 */

public class ClassWork8ViewModel implements BaseViewModel{

    public ObservableField<String> hellotext = new ObservableField<>("Hello");


    // ссылка на активити
    public Activity activity;

    public ClassWork8ViewModel(Activity activity) {
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

    public void onSuperButtonClick(){
        Log.e("KKK", "Click");

        // переходим на активити

       //Intent intent = new Intent(this, Lesson3Activity.class);
        //activity.startActivity(intent);
    }


    // все выполнится в другом потоке
    public class MyAsyncTask extends AsyncTask<Void, Integer, String>{

        // выполнятся в UI до doinBackgrounf()
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        // в UI потоке, но вызываем самостоятельно из doinBackground
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(Void... params) {

           // тут все выполнится в отдельном потоке и передаст данные в onPostExecute()

            // вызываем прогресс-бр
            publishProgress(20);

            return null;
        }


        //метод котрый выполнится в UI потоке
        // входное значение s передается из метода doInBackgroun
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
