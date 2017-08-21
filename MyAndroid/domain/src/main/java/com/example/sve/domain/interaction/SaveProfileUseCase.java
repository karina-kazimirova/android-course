package com.example.sve.domain.interaction;



import com.example.sve.data.entity.Profile;
import com.example.sve.data.net.RestService;
import com.example.sve.domain.entity.ProfileId;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.interaction.base.UseCase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


// наследуемся от UseCase и реализуем абстракнтый метод
public class SaveProfileUseCase extends UseCase<ProfileModel, Void> {


    //ProfileModel - модифицированный Profile из data

    @Override
    protected Observable<Void> buildUseCase(ProfileModel param) {

        Profile profileData = new Profile();
        profileData.setName(param.getName());
        profileData.setSurname(param.getSurname());
        profileData.setAge(param.getAge());

        return RestService.getInstance().saveProfile(profileData);
    }


}
