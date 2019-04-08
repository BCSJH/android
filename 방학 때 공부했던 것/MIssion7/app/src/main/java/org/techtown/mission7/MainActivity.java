package org.techtown.mission7;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    TextView viewText_name;
    EditText text_name;
    TextView viewText_age;
    EditText text_age;
    TextView viewText_birthday;
    Button button_birthday;
    Button button_save;
    SimpleDateFormat sdf;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        viewText_name = (TextView) findViewById(R.id.viewText_name);

        text_name = (EditText) findViewById(R.id.text_name);

        viewText_age = (TextView) findViewById(R.id.viewText_age);

        text_age = (EditText) findViewById(R.id.text_age);

        viewText_birthday = (TextView) findViewById(R.id.viewText_birthday);

        button_birthday = (Button) findViewById(R.id.button_birthday);

        button_save = (Button) findViewById(R.id.button_save);



        sdf = new SimpleDateFormat("yyyy년 MM월 dd일");

        button_birthday.setText( sdf.format(Calendar.getInstance().getTime()) );

    }





    public void  onButtonBirthdayClicked(View v) {

        Calendar c = Calendar.getInstance();

        String today = button_birthday.getText().toString();

        if(today.length() == 13) {

            try {

                c.setTime(sdf.parse(today));

            } catch (ParseException e) {

            }

        }



        DatePickerDialog datePickerDialog = new DatePickerDialog(

                MainActivity.this,

                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        try {

                            Calendar calendar = Calendar.getInstance();

                            calendar.set(year, monthOfYear, dayOfMonth);

                            button_birthday.setText( sdf.format(calendar.getTime()) );

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    }

                },

                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));



        datePickerDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        datePickerDialog.show();

    }





    public void onButtonLoginClicked(View v) {

        Toast toast = Toast.makeText(getBaseContext(),

                "이름 : " + text_name.getText() + ", " +

                        "나이 : " + text_age.getText() + ", " +

                        "생년월일 : " + button_birthday.getText(),

                Toast.LENGTH_LONG);



        toast.show();

    }

}

