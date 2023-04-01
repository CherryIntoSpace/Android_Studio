package com.example.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_url;
    private Button btn_go;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_url = findViewById(R.id.et_url);
        btn_go = findViewById(R.id.btn_go);

        /*btn_go(Button)을 눌렀을 때 수행되는 생명 주기*/
        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*et_url(EditText)로부터 텍스트를 받아와 문자열로 설정, String 형태의 url 변수에 저장*/
                url = et_url.getText().toString();

                /*activity_main의 MainActivity의 intent 생성, 이 intent는 SubActivity로 데이터를 송신
                * 하는 intent임*/
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                /*이 intent에 앞서 생성한 url 변수를 키 값(name) "url"로 지정하여 담음*/
                intent.putExtra("url",url);

                /*액티비티 시작(intent)*/
                startActivity(intent);
            }
        });

    }
}