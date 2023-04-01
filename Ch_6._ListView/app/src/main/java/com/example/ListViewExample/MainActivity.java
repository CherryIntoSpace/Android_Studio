package com.example.ListViewExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*list는 activity_main.xml에 전달되는 객체*/
        list = findViewById(R.id.list);

        /*data는 문자열로 구성된 리스트(ArrayList)*/
        List<String> data = new ArrayList<>();

        /*adapter는 data를 list로 연결시켜주는 어댑터로, 앱 화면에 list를 어떻게 출력할지 결정하는 역할도
        * 한다.*/
        /*ArrayAdapter의 첫번째 인자는 현재 상태의 객체(context), 두번째 인자는 ListView에 나열되는 뷰의
        * 모양을 선택, 세번째 인자는 연결할 데이터를 의미한다.*/
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1,data);

        /*ListView의 list에 어댑터를 적용함*/
        list.setAdapter(adapter);

        /*data에 데이터들을 추가함*/
        data.add("KHJ First");
        data.add("KHJ Second");
        data.add("KHJ Third");

        /*data에 데이터들이 추가됐으므로 연결된 adapter에 변동사항이 발생했음을 알려주고 갱신한다.*/
        adapter.notifyDataSetChanged();
    }
}