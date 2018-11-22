package com.example.linyanan.configuration.presenter;

import com.example.linyanan.configuration.base.BaseAttacher;
import com.example.linyanan.configuration.view.UseView;

public interface Presenter <V extends UseView>extends BaseAttacher<V>{
        void onCreate();

        void onDestory();

        void onPause();

        void onResume();

        }
