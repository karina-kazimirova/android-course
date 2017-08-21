package com.example.sve.data.net;


import com.example.sve.data.entity.Profile;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Sve on 16.08.2017.
 */

public interface RestApi {
    // Создаем запрос ( последние две переменные из ссылки)

    @GET("data/profile")
    Observable<List<Profile>> getProfiles();

    // Поиск по id
    //@GET("data/profile/{id}")
    //Observable<Profile> getProfiles(@Path("id")String id);

    @POST("data/profile")
    Observable<Void> saveProfile(@Body Profile profile);


}
