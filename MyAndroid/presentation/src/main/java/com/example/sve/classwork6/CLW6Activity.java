package com.example.sve.classwork6;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.sve.myandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sve on 04.08.2017.
 */

public class CLW6Activity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private List<Person> persons;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clw6);

        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", R.drawable.sova_anmation_1, "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", R.drawable.sova_anmation_2, "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", R.drawable.sova_anmation_3, "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", R.drawable.sova_anmation_1, "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", R.drawable.sova_anmation_2, "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", R.drawable.sova_anmation_3, "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", R.drawable.sova_anmation_1, "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", R.drawable.sova_anmation_2, "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", R.drawable.sova_anmation_3, "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));
        persons.add(new Person("Emma Wilson", R.drawable.sova_anmation_1, "https://cdn.pixabay.com/photo/2017/07/22/22/56/tiger-2530158_960_720.jpg"));
        persons.add(new Person("Lavery Maiss", R.drawable.sova_anmation_2, "https://cdn.pixabay.com/photo/2017/06/19/07/12/water-lily-2418338_960_720.jpg"));
        persons.add(new Person("Lillie Watts", R.drawable.sova_anmation_3, "https://cdn.pixabay.com/photo/2017/05/09/13/31/spring-2298279_960_720.jpg"));



        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        // отвечает за расположение + GridLayoutManager  и тд
        // для специфч-го расположения нужно создать свой LayoutManager
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        // назначаем менеджер View
        recyclerView.setLayoutManager(manager);

        // создали адаптер, который заполняет каждую ячейку данныии
        MyAdapter adapter = new MyAdapter(persons);

        adapter.setListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Log.e("AAA", "");
            }
        });

        recyclerView.setAdapter(adapter);


    }
}
