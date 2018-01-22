package com.matcha.domtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv=findViewById(R.id.webView);
        parseHTML parseHTML=new parseHTML();
        wv.loadData(parseHTML.getString(),"text/html;charset=UTF-8",null);

    }
}
