package com.example.sve.domain.interaction;

import com.example.sve.data.entity.Profile;
import com.example.sve.data.net.RestService;
import com.example.sve.domain.entity.ProfileId;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.interaction.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Sve on 21.08.2017.
 */
public class GetProfileListUseCase extends UseCase<ProfileId, List<ProfileModel>> {

    @Override
    protected Observable<List<ProfileModel>> buildUseCase(ProfileId param) {
        return RestService.getInstance().getProfiles().map(new Function<List<Profile>, List<ProfileModel>>() {
            @Override
            public List<ProfileModel> apply(@NonNull List<Profile> profiles) throws Exception {
                List<ProfileModel> list = new ArrayList<>();
                for(Profile profile: profiles) {
                    list.add(convert(profile));
                }
                return list;
            }
        });

    }

    private ProfileModel convert(Profile dataModel) {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setName(dataModel.getName());
        profileModel.setSurname(dataModel.getSurname());
        profileModel.setAge(dataModel.getAge());
        return profileModel;
    }
}
