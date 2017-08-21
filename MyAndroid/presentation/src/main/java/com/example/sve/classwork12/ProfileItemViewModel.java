package com.example.sve.classwork12;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.example.sve.base.BaseItemViewModel;
import com.example.sve.domain.entity.ProfileModel;

/**
 * Created by Sve on 18.08.2017.
 */

public class ProfileItemViewModel extends BaseItemViewModel<ProfileModel> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableField<String> surname = new ObservableField<>("");
    public ObservableInt age = new ObservableInt();

    @Override
    public void setItem(ProfileModel item, int position) {
        Log.e("AAA", "ITEM " + position);
        Log.e("AAA", "ITEM name " + item.getName());
        name.set(item.getName());
        surname.set(item.getSurname());
        age.set(item.getAge());
    }
}
