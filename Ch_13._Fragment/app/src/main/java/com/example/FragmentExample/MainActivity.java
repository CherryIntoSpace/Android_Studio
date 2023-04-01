package com.example.FragmentExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction은 Fragment의 추가, 변경, 삭제 기능을 제공함*/
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                /*Fragment1 클래스의 참조변수 fragment1 생성(Fragment1.java의 onCreateView() 시작*/
                Fragment1 fragment1 = new Fragment1();

                /*activity_main의 메인 레이아웃 frame을 fragment1으로 교체한다.
                * fragment1 클래스에는 onCreateView가 호출되어 View 객체를 return 하였으므로
                * fragment1.xml의 레이아웃들을 사용하거나 화면에 출력할 수 있다.*/
                transaction.replace(R.id.frame,fragment1);

                /*커밋하여 완료한다.*/
                transaction.commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction은 Fragment의 추가, 변경, 삭제 기능을 제공함*/
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.frame,fragment2);
                transaction.commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction은 Fragment의 추가, 변경, 삭제 기능을 제공함*/
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.frame,fragment3);
                transaction.commit();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentTransaction은 Fragment의 추가, 변경, 삭제 기능을 제공함*/
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.frame,fragment4);
                transaction.commit();
            }
        });
    }
}