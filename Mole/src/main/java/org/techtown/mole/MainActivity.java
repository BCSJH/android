package org.techtown.mole;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Handler mHandler;
    int mScore =0;
    int mTime =30;
    boolean stopp=false;
    int[] imgValue = new int [9];
    ImageButton[] imgMole = new ImageButton[9];
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgMole[0]=(ImageButton)findViewById(R.id.imagebutton1);
        imgMole[1]=(ImageButton)findViewById(R.id.imagebutton2);
        imgMole[2]=(ImageButton)findViewById(R.id.imagebutton3);
        imgMole[3]=(ImageButton)findViewById(R.id.imagebutton4);
        imgMole[4]=(ImageButton)findViewById(R.id.imagebutton5);
        imgMole[5]=(ImageButton)findViewById(R.id.imagebutton6);
        imgMole[6]=(ImageButton)findViewById(R.id.imagebutton7);
        imgMole[7]=(ImageButton)findViewById(R.id.imagebutton8);
        imgMole[8]=(ImageButton)findViewById(R.id.imagebutton9);

        final Button stop = (Button)findViewById(R.id.stop);
        Button go = (Button)findViewById(R.id.go);
        Button resett = (Button)findViewById(R.id.reset);
        final TextView txtScore = (TextView)findViewById(R.id.score);
        final TextView txtTime = (TextView)findViewById(R.id.time);


        resett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScore = 0;
                mTime = 30;
                mHandler.sendEmptyMessageDelayed(0,1000);
            }
        });

        for(int i =0;i<9;i++){
            final int arrayI = i;
            imgMole[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgMole[arrayI].setImageResource(R.drawable.mole);
                    if(imgValue[arrayI]==1){
                        mScore+=30;
                        imgValue[arrayI]=0;
                    }
                }
            });
        }
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopp=true;
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopp=false;
                mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        });
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                txtTime.setText("시간:"+mTime);
                txtScore.setText("점수:"+mScore);
                if(mTime==0){
                    @SuppressLint("WrongConstant") Toast toast = Toast.makeText(getBaseContext(),"종료",100000);
                    toast.show();
                    return;
                }
                if(stopp==true){

                }
                if(stopp==false) {
                    mHandler.sendEmptyMessageDelayed(0, 1000);
                    mTime--;
                    double rValus = java.lang.Math.random();
                    int selectedIndex = (int) (rValus * 10);
                    if (selectedIndex == 9)
                        selectedIndex = 4;
                    for (int i = 0; i < 9; i++) {
                        imgValue[i] = 0;
                        imgMole[i].setImageResource(R.drawable.mole);
                    }
                    imgValue[selectedIndex] = 1;
                    imgMole[selectedIndex].setImageResource(R.drawable.mole2);
                }
            }
        };
    }
}
