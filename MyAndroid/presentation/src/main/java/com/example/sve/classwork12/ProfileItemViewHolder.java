package com.example.sve.classwork12;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sve.base.BaseItemViewHolder;
import com.example.sve.base.BaseItemViewModel;
import com.example.sve.domain.entity.ProfileModel;
import com.example.sve.myandroid.databinding.ItemProfileBinding;

/**
 * Created by Sve on 18.08.2017.
 */

public class ProfileItemViewHolder extends BaseItemViewHolder<ProfileModel,
        ProfileItemViewModel, ItemProfileBinding> {

    public ProfileItemViewHolder(ItemProfileBinding binding, ProfileItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static ProfileItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                               ProfileItemViewModel viewModel) {
        ItemProfileBinding binding = ItemProfileBinding.inflate(inflater, parent, false);
        return new ProfileItemViewHolder(binding, viewModel);
    }
}

