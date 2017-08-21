package com.example.sve.classwork13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sve.myandroid.R;

/**
 * Created by Sve on 21.08.2017.
 */
// наследоваться обязательно от Fragment support.v4
public class ClW13Fragment extends Fragment {

    public ClW13Fragment() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    // подключаем xml
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_clw13, container, false);

        // здесь больше ниче не добавлять, тк этот фрагм еще не создана
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // все setter
        // view.


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    /**
     *
     * создать документацию
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // активити гарантированно создано
        //getActivity(). - обращаемся к активити в котором находится фрагмент

    }


    // добавлен на активити
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    // удален с активти
    @Override
    public void onDetach() {
        super.onDetach();
    }


    // при удаленние активити или этого фрагмента
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
