package com.example.DebugExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s = "MainActivity's String";
        int a = 10;

        /*logcat에 log 출력(문자열만 출력).e(에러)
        (필터 : com.example.DebugExample level:error)*/
        Log.e("MainActivity : ",s);
        Log.e("MainActivity : ", String.valueOf(a));
    }
}