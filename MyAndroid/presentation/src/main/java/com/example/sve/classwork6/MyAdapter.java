package com.example.sve.classwork6;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sve.data.entity.Profile;
import com.example.sve.domain.entity.Person;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ItemRecyclerBinding;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sve on 04.08.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    private List<Person> persons;

    public MyAdapter(List<Person> persons){
        this.persons= persons;
    }

    @Override
    public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //из xml получаем объектную модель
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemRecyclerBinding binding = ItemRecyclerBinding.inflate(inflater, parent, false);
        Log.e("AAA", "onCreateViewHolder()");
        return new Holder(binding.getRoot());
    }

    // заполняем
    @Override
    public void onBindViewHolder(MyAdapter.Holder holder, int position) {
        Log.e("AAA", "onBingViewHolder()");
        final Person person = persons.get(position);
        holder.binding.setPerson(person);



    }

    // количество
    @Override
    public int getItemCount() {
        // проверяем количество items? чтобы сделать столько ячеек, сколько данных
        return persons == null ? 0 : persons.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        ItemRecyclerBinding binding;

        public Holder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

    }


   @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String v) {
       Picasso.with(imageView.getContext()).load(v)
               .resize(350,250)
               .into(imageView);
    }




}
