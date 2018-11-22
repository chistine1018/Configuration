package com.example.linyanan.configuration.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.linyanan.configuration.R;
import com.example.linyanan.configuration.model.Board;
import com.example.linyanan.configuration.model.Player;
import com.example.linyanan.configuration.presenter.UsePresenter;

public class ControllerActivity extends AppCompatActivity implements UseView {
    private GridLayout gridLayout;
    private LinearLayout linearLayout;
    private TextView result_person, result_text;
    UsePresenter usePresenters = new UsePresenter(2);
    UsePresenter usePresenter = new UsePresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        linearLayout = findViewById(R.id.result_linearlayout);
        result_person = findViewById(R.id.result_person);
        result_text = findViewById(R.id.result_text);
        gridLayout = findViewById(R.id.gridLayout);
        usePresenter.onDetched();
        usePresenter.onAttached(this);
        usePresenter.onCreate();
        usePresenter.aaa();
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
                usePresenter.onReset();
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

        usePresenter.touckEvent(row, colnum);

    }


    @Override
    public void showWinner(String winPlayer) {
        linearLayout.setVisibility(View.VISIBLE);
        result_person.setText(winPlayer);
        result_text.setText("Winner");
    }

    @Override
    public void clearWinnerDisplay() {
        linearLayout.setVisibility(View.GONE);
        result_person.setText("");
        result_text.setText("");

    }

    @Override
    public void clearButtons() {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            ((Button) gridLayout.getChildAt(i)).setText("");

        }
    }

    @Override
    public void setButtonText(int row, int colnum, String player) {
        Button btn = gridLayout.findViewWithTag("" + row + colnum);
        if (btn != null) {
            btn.setText(player);
        }
    }

    @Override
    public void showPeace() {
        linearLayout.setVisibility(View.VISIBLE);
        result_person.setText("Peace");

    }

    @Override
    protected void onResume() {
        super.onResume();
        usePresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        usePresenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        usePresenter.onDestory();
    }
}

