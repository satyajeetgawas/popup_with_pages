package com.sg.popupslider.example;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button popupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popupBtn = (Button) findViewById(R.id.button);
        popupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupBtnAction(v);
            }
        });
    }

    private void popupBtnAction(View v) {
        FragmentManager ft = getSupportFragmentManager();
        DialogFragment newFragment = new FragmentDialog();
        newFragment.show(ft, "dialog");
    }
}
