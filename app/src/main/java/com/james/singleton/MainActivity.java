package com.james.singleton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.james.singleton.model.BubbleWrap;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();
    private BubbleWrap bubblewrap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bubblewrap =  BubbleWrap.getInstance();
        setUpAddMoreButton();
        setUpPopActivityButton();
    }


    private void setUpAddMoreButton(){
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubblewrap.addMoreBubbles();
                updateUI();
            }
        });

    }

    private void setUpPopActivityButton(){
        Button btn_Pop = findViewById(R.id.button2);
        btn_Pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PupActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateUI(){
        TextView tv = findViewById(R.id.textView);
        String msg = String.format(
                Locale.getDefault(),
                "%d bubbles left!",
                bubblewrap.getNumberBubbles());
        tv.setText(msg);
    }
    @Override
    protected void onResume(){
        super.onResume();
        updateUI();
    }

}
