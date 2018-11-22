package com.example.linyanan.configuration.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.linyanan.configuration.R;
import com.example.linyanan.configuration.model.Board;
import com.example.linyanan.configuration.model.Player;

public class ControllerActivity extends AppCompatActivity {
    private Board model;
    private GridLayout gridLayout;
    private LinearLayout linearLayout;
    private TextView result_person, result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        linearLayout = findViewById(R.id.result_linearlayout);
        result_person = findViewById(R.id.result_person);
        result_text = findViewById(R.id.result_text);
        gridLayout = findViewById(R.id.gridLayout);


        model = new Board();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                reset();
                return true;
            //how this
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void touckEvent(View v) {
        Button button = (Button) v;
        String tag = button.getTag().toString();
        int row = Integer.valueOf(tag.substring(0, 1));
        int colnum = Integer.valueOf(tag.substring(1, 2));

        Player playerMoved = model.mark(row, colnum);
        if (playerMoved != null) {
            button.setText(playerMoved.toString());
            if (model.getWinner() != null) {
                linearLayout.setVisibility(View.VISIBLE);
                result_person.setText(playerMoved.toString());
                result_text.setText("Winner");
            } else if (model.getPeace() != null) {
                linearLayout.setVisibility(View.VISIBLE);
                result_text.setText("Peace");
            }

        }


    }

    public void reset() {
        linearLayout.setVisibility(View.GONE);
        result_person.setText("");
        result_text.setText("");
        model.restart();
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((Button) gridLayout.getChildAt(i)).setText("");

        }

    }
}
