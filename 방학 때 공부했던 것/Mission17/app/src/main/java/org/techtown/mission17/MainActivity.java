package org.techtown.mission17;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    BookDatabase database;

    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.title);
        editText2 = (EditText) findViewById(R.id.writer);
        editText3 = (EditText) findViewById(R.id.content);

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        database = BookDatabase.getInstance(this);
        boolean isOpen = database.open();
        if (isOpen) {
            Log.d(TAG, "Book database is open.");
        } else {
            Log.d(TAG, "Book database is not open.");
        }

        Button button = (Button) findViewById(R.id.store);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String author = editText2.getText().toString();
                String contents = editText3.getText().toString();

                database.insertRecord(name, author, contents);
                Toast.makeText(getApplicationContext(), "책 정보를 추가했습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }

    protected void onDestroy() {
        // close database
        if (database != null) {
            database.close();
            database = null;
        }

        super.onDestroy();
    }

}