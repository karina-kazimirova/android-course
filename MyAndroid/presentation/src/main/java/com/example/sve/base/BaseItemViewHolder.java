package com.example.sve.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Sve on 18.08.2017.
 */
// В этот класс будут подаваться разные данные(Model - то что в Item, ViewModel, DataBindind - для каждого item
public abstract class BaseItemViewHolder<Model, ViewModel extends BaseItemViewModel<Model>,
        DataBinding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private DataBinding dataBinding;
    private ViewModel viewModel;

    public BaseItemViewHolder(DataBinding dataBinding, ViewModel viewModel) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
        this.viewModel = viewModel;
        viewModel.init();
    }

    public void bindTo(Model item, int position) {
        viewModel.setItem(item, position);
        dataBinding.executePendingBindings();
    }

    public void release() {
        viewModel.release();
    }
}
