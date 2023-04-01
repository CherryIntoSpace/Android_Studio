package com.example.CustomNaviExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*activity_main의 DrawerLayout 위젯을 저장할 변수 drawerLayout*/
    private DrawerLayout drawerLayout;

    /*activity_drawer의 LinearLayout 위젯(서랍 화면)을 저장할 변수 drawerView*/
    private View drawerView;

    private Button btn_open;
    private Button btn_close;

    /*앱이 실행될 때 수행되는 생명 주기*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer_layout);
        drawerView=findViewById(R.id.drawerView);
        btn_open=findViewById(R.id.btn_open);
        btn_close=findViewById(R.id.btn_close);

        /*btn_open(Button)이 눌렸을 때 수행되는 생명 주기*/
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*drawerLayout의 서랍을 열 때, drawerView로 서랍을 연다.*/
                drawerLayout.openDrawer(drawerView);
            }
        });

        /*btn_close(Button)이 눌렸을 때 수행되는 생명 주기*/
       btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*현재 펼쳐진 drawerLayout의 drawerView 서랍을 닫는다.*/
                drawerLayout.closeDrawers();
            }
        });

       /*listener는 서랍의 상태(슬라이드, 열림, 닫힘, 상태변경)에 따라 여러 이벤트를 발생시킬 수 있는
       * 기능이다.*/
       drawerLayout.setDrawerListener(listener);

       /*drawerView, 뷰 자체를 터치했을 때 수행되는 생명 주기*/
       drawerView.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
               /*Toast 메세지 발송*/
               Toast.makeText(getApplicationContext(), "KHJ",Toast.LENGTH_SHORT).show();
               return true;
           }
       });
    }

    /*listener 구현하기*/
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };
}