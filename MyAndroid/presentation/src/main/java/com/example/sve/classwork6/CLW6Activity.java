package com.example.sve.classwork6;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.sve.base.BaseActivity;
import com.example.sve.domain.entity.Person;
import com.example.sve.domain.interaction.ProfileUseCase;
import com.example.sve.myandroid.R;
import com.example.sve.myandroid.databinding.ActivityClw6Binding;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sve on 04.08.2017.
 */

public class CLW6Activity extends BaseActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Person> persons;



    private ProfileUseCase useCase = new ProfileUseCase();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        // создаем модель для этой активити
        CLW6ActivityViewModel viewModel = new CLW6ActivityViewModel(this);
        this.viewModel = viewModel;


        ActivityClw6Binding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_clw6);

        binding.setViewModel(viewModel);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


      persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "27лет", "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", "27лет", "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", "27лет", "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", "27лет", "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", "27лет", "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", "27лет", "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", "27лет", "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", "27лет", "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", "27лет", "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", "27лет", "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", "27лет", "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", "27лет", "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));


        adapter = new MyAdapter(persons);
        recyclerView.setAdapter(adapter);

        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
