package com.kabdo.uimix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SuperCardView mSuperCardView = findViewById(R.id.mSuperCardView);
        mSuperCardView.setCardValues(true, true, true, false, true,
                "title", "subtitle", "http://via.placeholder.com/300.png",
                "", R.drawable.person_image_empty,
                0, 0, 0);
    }
}
