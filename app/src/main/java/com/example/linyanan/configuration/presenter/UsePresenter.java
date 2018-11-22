package com.example.linyanan.configuration.presenter;

import com.example.linyanan.configuration.base.BasePresenter;
import com.example.linyanan.configuration.model.Board;
import com.example.linyanan.configuration.model.Player;
import com.example.linyanan.configuration.view.UseView;

public class UsePresenter<V extends UseView> extends BasePresenter<V> implements Presenter<V> {
    private Board model;
    UseView useView;


    public UsePresenter(UseView view) {
        this.model = new Board();
        this.useView = view;
    }

    public UsePresenter(int eee) {

    }

    @Override
    public void onCreate() {
        model = new Board();

    }

    @Override
    public void onDestory() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    public void touckEvent(int row, int colnum) {

        Player playerMoved = model.mark(row, colnum);
        if (playerMoved != null) {
            useView.setButtonText(row, colnum, playerMoved.toString());
            if (model.getWinner() != null) {
                useView.showWinner(playerMoved.toString());
            } else if (model.getPeace() != null) {
                useView.showPeace();
            }

        }


    }

    public void onReset() {
        useView.clearButtons();
        useView.clearWinnerDisplay();
        model.restart();
    }
}
