package com.gemidroid.android_lib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by User1 on 28/12/2017.
 */

public class
AndroidLibrary extends AppCompatActivity {


    TextView txt_library;
    String sIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        txt_library = findViewById(R.id.txt_lib);

        if(getIntent().hasExtra("jokes")) {
            sIntent = getIntent().getStringExtra("jokes");
            txt_library.setText(sIntent);
        }


    }
}
