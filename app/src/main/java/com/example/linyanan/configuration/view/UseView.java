package com.example.linyanan.configuration.view;

import com.example.linyanan.configuration.base.BaseView;

public interface UseView extends BaseView {
    void showWinner(String winPlayer);

    void clearWinnerDisplay();

    void clearButtons();

    void setButtonText(int row, int col, String text);

    void showPeace();
}
