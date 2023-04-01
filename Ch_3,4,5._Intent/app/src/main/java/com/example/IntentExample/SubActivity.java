package com.example.IntentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        /*SubActivity의 intent는 MainActivity에서 전송한 intent를 수신하는 intent이다.*/
        Intent intent = getIntent();

        /*이 intent에서 이름(키 값)이 "str"인 데이터에서 문자열로 받아와 String 형태의 str 변수에 저장한다.*/
        String str = intent.getStringExtra("str");

        /*tv_sub(TextView)을 str로 지정한다.*/
        tv_sub.setText(str);
    }
}