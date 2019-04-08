package org.techtown.samplecustomviewstyle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.techtown.graphics.custom.style.CustomViewStyles;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomViewStyles myView = new CustomViewStyles(this);
        setContentView(myView);
    }
}
