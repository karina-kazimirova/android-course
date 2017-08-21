package com.example.sve.classwork12;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sve.base.BaseAdapter;
import com.example.sve.base.BaseItemViewHolder;
import com.example.sve.domain.entity.ProfileModel;

/**
 * Created by Sve on 18.08.2017.
 */

public class ProfileAdapter extends BaseAdapter<ProfileModel, ProfileItemViewModel> {

    @Override
    public ProfileItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel itemViewModel = new ProfileItemViewModel();
        return ProfileItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }

}
