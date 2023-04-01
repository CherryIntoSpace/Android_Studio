package com.example.EtBtn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /*EditText와 Button 클래스의 참조 변수 et_id와 btn_test 선언*/
    EditText et_id;
    Button btn_test;

    /*onCreate : 앱을 실행하였을 때 수행되는 생명 주기*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*xml에서 생성한 id들을 R 에서 참고하여 MainActivity의 et_id와 btn_test에 지정*/
        et_id = findViewById(R.id.et_id);
        btn_test=findViewById(R.id.btn_test);
        /*btn_test를 눌렀을 때 수행되는 생명 주기*/
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*et_id(EditText)의 텍스트를 KHJ로 지정*/
                et_id.setText("KHJ");
            }
        });
    }
}