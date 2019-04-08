package org.techtown.paintboard;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.techtown.tutorial.graphic.PaintBoard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintBoard myView = new PaintBoard(this);
        setContentView(myView);
    }
    }
