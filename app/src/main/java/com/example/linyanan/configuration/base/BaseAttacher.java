package com.example.linyanan.configuration.base;

public interface BaseAttacher<V extends BaseView> {
    void onAttached(V view);

    void onDetched();
}
