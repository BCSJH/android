package org.techtown.samplecustomviewdrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.techtown.graphics.custom.drawables.CustomViewDrawables;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomViewDrawables myView = new CustomViewDrawables(this);
        setContentView(myView);
    }
}
