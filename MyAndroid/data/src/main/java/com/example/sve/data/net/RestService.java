package com.example.sve.data.net;

import com.example.sve.data.entity.Profile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sve on 16.08.2017.
 */

public class RestService {


    // Делаем Singletone
    private static final RestService instance = new RestService();

    private RestApi restApi;


    // при создании вызовется init() только один раз  и настроит Retrofit
    private RestService(){
        init();
    }

    public static RestService getInstance(){
        return instance;
    }


    // подключаем OkHttp ( замена стандратному Url connection). Обеспечивает запросами к интеренту
    private  void init(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson =  new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/70E26EEB-3ACD-601D-FF12-541F239F8800/FDBEBFDC-2C3B-E045-FF00-D718E4134700/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        restApi = retrofit.create(RestApi.class);
    }

    public Observable<List<Profile>> getProfiles() {
        return restApi.getProfiles();
    }

    public Observable<Void> saveProfile(Profile profile) {
        return restApi.saveProfile(profile);
    }
}