package org.techtown.mission5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onCButton1licked(View view) {
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);

        final String id = editText2.getText().toString();
        final String pas = editText3.getText().toString();
        if(id==null||id==""||id.length()<=0){
            Toast.makeText(this,"아이디를 입력해주세요",Toast.LENGTH_LONG).show();
        }
        else if(pas==null||pas==""||pas.length()<=0){
            Toast.makeText(this,"비밀번호를 입력해주세요",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
            startActivityForResult(intent,REQUEST_CODE_MENU);
            finish();
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK){
            Toast.makeText(getApplicationContext(), data.getStringExtra("name"), Toast.LENGTH_LONG).show();
        }
    }
}
