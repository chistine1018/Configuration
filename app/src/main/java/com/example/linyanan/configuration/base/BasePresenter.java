package com.example.linyanan.configuration.base;

import android.util.Log;
import android.view.View;

import com.example.linyanan.configuration.base.BaseAttacher;
import com.example.linyanan.configuration.base.BaseView;
import com.example.linyanan.configuration.view.UseView;

public class BasePresenter<V extends BaseView> implements BaseAttacher<V> {
    private V view;


    public void onAttached(V view) {
        this.view = view;
    }

    @Override
    public void onDetched() {

    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public void aaa() {
        Log.e("aa", "aaa: ");
    }

}
