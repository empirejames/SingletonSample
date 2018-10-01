package com.james.singleton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.james.singleton.model.BubbleWrap;

import java.util.Locale;

public class PupActivity extends AppCompatActivity {

    private BubbleWrap bubbleWrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bubbleWrap = BubbleWrap.getInstance();
        setUpPupButton();
        updateUI();
    }

    private void setUpPupButton() {
        Button btn_pup = findViewById(R.id.btn_pop_content);
        btn_pup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleWrap.pupBubble();
                updateUI();
            }
        });
    }

    private void updateUI(){
        TextView tv = findViewById(R.id.tv_pop_content);
        String msg = String.format(
                Locale.getDefault(),
                "%d bubbles left!",
                bubbleWrap.getNumberBubbles());
        tv.setText(msg);
    }

}
