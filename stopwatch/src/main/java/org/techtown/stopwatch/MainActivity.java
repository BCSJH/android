package org.techtown.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button start_btn;
    Button stop_btn;
    Button reset_btn;
    TextView hour_tx;
    TextView minute_tx;

    private TimerTask second;
    private final Handler handler = new Handler();

    Timer timer;

    public int hour_num = 0;
    public int minute_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = (Button)findViewById(R.id.start);
        stop_btn = (Button)findViewById(R.id.stop);
        reset_btn = (Button)findViewById(R.id.reset);

        hour_tx = (TextView)findViewById(R.id.hour);
        minute_tx = (TextView)findViewById(R.id.minute);

        start_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { test_start(); }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { timer.cancel(); }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                hour_num = 0;
                minute_num = 0;
            }
        });
    }

    public void test_start(){
        second = new TimerTask() {
            @Override
            public void run() {
                update();
                minute_num++;
            }
        };
       timer  = new Timer();
        timer.schedule(second,0,1000);
    }

    protected void update(){
        Runnable updater = new Runnable() {
            @Override
            public void run() {
                if(minute_num<60) {
                    minute_tx.setText(minute_num + "");
                }
                else{
                    hour_num++;
                    minute_num=0;
                    hour_tx.setText(hour_num+"");
                    minute_tx.setText(minute_num+"");
                }
            }
        };
        handler.post(updater);
    }

}
