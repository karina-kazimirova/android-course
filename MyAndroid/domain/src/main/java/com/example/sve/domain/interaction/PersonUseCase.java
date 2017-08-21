package com.example.sve.domain.interaction;

import com.example.sve.data.entity.PersonData;
import com.example.sve.data.entity.Profile;
import com.example.sve.domain.entity.Person;
import com.example.sve.domain.entity.PersonId;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.domain.interaction.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Sve on 14.08.2017.
 */

public class PersonUseCase extends UseCase<PersonId, Person> {


    @Override
    protected Observable<Person> buildUseCase(PersonId param) {

    return Observable.never();}
}
