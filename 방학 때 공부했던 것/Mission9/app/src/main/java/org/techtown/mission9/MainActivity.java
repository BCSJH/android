package org.techtown.mission9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

abstract class userin extends BaseAdapter{
    ArrayList<userin> items = new ArrayList<userin>();

    @Override
    public int getCount() {
        return items.size();
    }
    public void addItems(userin item){
        items.add(item);
    }
    public  Object getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View converView, ViewGroup viewGroup){
        userin
    }
}

public class MainActivity extends AppCompatActivity {
    TextView textView2;
    Button button;
    EditText name;
    EditText year;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.add);
        name = findViewById(R.id.name);
        year = findViewById(R.id.birthday);
        tel = findViewById(R.id.tel);
    }
}
