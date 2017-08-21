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
public class ProfileUseCase extends UseCase<ProfileId, ProfileModel> {


    //ProfileModel - модифицированный Profile из data
//выходной параметр заменить на List
    @Override
    protected Observable<ProfileModel> buildUseCase(ProfileId param) {




        // обращаемся к Rest и он возвраает один Profile из листа
        return RestService.getInstance().getProfiles()
                // Промежуточная модификация .doOnNext()
                // .filter(); фильтрует данные, не пропускает по критериям(  в методе !=null - например)

                // делаем задержку на 3 секунды .delay(3, TimeUnit.SECONDS)
                .map(new Function<List<Profile>, ProfileModel>() {
                    @Override
                    public ProfileModel apply(@NonNull List<Profile> profilelist) throws Exception {

                        Profile profileData = profilelist.get(0);

                        ProfileModel profileModel = new ProfileModel();
                        profileModel.setName(profileData.getName());
                        profileModel.setSurname(profileData.getSurname());
                        profileModel.setAge(profileData.getAge());


                        return profileModel;
                    }
                });// модифицируем данные из одного формата в другой. Подается входно и то что передаем
    }
}
