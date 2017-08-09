package com.example.classwork6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Sve on 04.08.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {


    private List<Person> persons;
    private OnItemClickListener onItemClickListener;

    public void setListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }



    //создаем конструктор
    public MyAdapter(List<Person> persons){
        this.persons= persons;
    }


    @Override
    public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        //из xml получаем объектную модель
      View root = LayoutInflater.from(parent.getContext())
              .inflate(R.layout.item_recycler, parent, false);
        Log.e("AAA", "onCreateViewHolder()");
        return new Holder(root);
    }

    // заполняем
    @Override
    public void onBindViewHolder(MyAdapter.Holder holder, int position) {
        Log.e("AAA", "onBingViewHolder()");
        final Person item = persons.get(position);
        holder.textView.setText(persons.get(position).name);
        holder.imageView.setVisibility(View.VISIBLE);
        holder.progressBar.setVisibility(View.VISIBLE);




        Context context = holder.imageView.getContext();

        final ProgressBar progressView = holder.progressBar;
        Picasso.with(context).load(persons.get(position).photo_Link)
                .resize(350,250)
                .into(holder.imageView, new Callback() {

                    @Override
                    public void onSuccess() {
                        progressView.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError() {


                    }
                });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(String.valueOf(persons));
                }

            }
        });

    }

    // количество
    @Override
    public int getItemCount() {
        // проверяем количество items? чтобы сделать столько ячеек, сколько данных
        return persons == null ? 0 : persons.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        ProgressBar progressBar;

        public Holder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_view);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
        }

    }


    interface OnItemClickListener{
        public void onItemClick(String item);
    }


}
