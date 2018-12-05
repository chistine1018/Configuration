package com.example.linyanan.configuration.model;

import android.util.Log;

import static com.example.linyanan.configuration.model.Player.O;
import static com.example.linyanan.configuration.model.Player.X;

public class Board {
    private Cell[][] cells = new Cell[3][3];

    private Player winner, peace;
    private GameState gameState;
    private Player currentUser;
    private int count;

    private enum GameState {IN_PROGRESS, FINISHED}

    public Board() {
        restart();
    }

    public void restart() {
        clearCells();
        winner = null;
        peace = null;
        count = 0;
        currentUser = X;
        gameState = GameState.IN_PROGRESS;

    }

    public Player mark(int row, int coulum) {
        Player playerMoved = null;

        if (isValid(row, coulum)) {
            cells[row][coulum].setValue(currentUser);
            playerMoved = currentUser;
            if (isAlreadyWin(currentUser, row, coulum)) {
                gameState = GameState.FINISHED;
                winner = currentUser;
            } else if (count == 9) {
                peace = currentUser;
            } else {
                changeUser();
            }

        }

        return playerMoved;
    }

    public boolean isAlreadyWin(Player player, int row, int coulum) {
        count++;
        Log.e("TAG", "isAlreadyWin: " + count);


        return (cells[0][0].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][2].getValue() == player

                || cells[0][2].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][0].getValue() == player

                || cells[row][0].getValue() == player
                && cells[row][1].getValue() == player
                && cells[row][2].getValue() == player

                || cells[0][coulum].getValue() == player
                && cells[1][coulum].getValue() == player
                && cells[2][coulum].getValue() == player
        );

    }

    public Player getWinner() {
        return winner;
    }

    public Player getPeace() {
        return peace;
    }

    public void changeUser() {
        currentUser = currentUser == X ? O : X;

    }

    public boolean isValid(int row, int coulum) {
        if (gameState == GameState.FINISHED) {
            return false;
        } else if (thisCellAlreadySet(row, coulum)) {
            return false;
        }


        return true;


    }

    public boolean thisCellAlreadySet(int row, int coulum) {
        return cells[row][coulum].getValue() != null;

    }

    public void clearCells() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();

            }

        }
    }
}
