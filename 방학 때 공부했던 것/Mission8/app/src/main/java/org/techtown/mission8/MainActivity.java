package org.techtown.mission8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {


    Button button;
    Button button2;
    EditText editText;
    RelativeLayout relativeLayout;
    WebView webView;
    boolean open = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.ButtonHide);//버튼을 눌러 입력하는 것 보이게
        button2 = (Button) findViewById(R.id.ButtonGo);//이동 누르는 버튼
        editText = (EditText) findViewById(R.id.EditTextHtml);//이동할 사이트 입력
        webView = (WebView) findViewById(R.id.webView);
        relativeLayout = (RelativeLayout) findViewById(R.id.Hide);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(open==false) {
                    relativeLayout.setVisibility(View.VISIBLE);
                    button.setText("▲");
                    open = true;
                }

                else if(open==true){
                    relativeLayout.setVisibility(View.GONE);
                    button.setText("▼");
                    open=false;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(editText.getText().toString());

            }
        });
    }
}
