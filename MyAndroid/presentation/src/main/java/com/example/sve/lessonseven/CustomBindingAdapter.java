package com.example.sve.lessonseven;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Sve on 11.08.2017.
 */

public class CustomBindingAdapter {

    @BindingAdapter("bind:src")
    public static void setPhotoUrl(ImageView imageView, String photoUrl) {

        Picasso.with(imageView.getContext()).load(photoUrl).resize(500, 500).into(imageView);

    }
}
