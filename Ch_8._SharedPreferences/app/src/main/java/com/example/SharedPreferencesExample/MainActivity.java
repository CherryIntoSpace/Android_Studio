package com.example.SharedPreferencesExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_save;

    /*SharedPreferences를 저장하는 xml파일의 파일명을 담고 있는 변수 선언(shared)*/
    String shared = "file";

    /*앱이 실행될 때 수행되는 생명 주기*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = findViewById(R.id.et_save);

        /*SharedPreferences는 적은 데이터의 양을 저장하기 위한 안드로이드 스튜디오의 기본 제공 기능*/
        /*file.xml에서 private 모드로 SharedPreferences를 가져오고, sharedPreferences에 저장*/
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        /*저장한 sharedPreferences에서 키 값이 "KHJ"인 문자열(value)을 가져와 value에 저장 */
        String value = sharedPreferences.getString("KHJ","");

        /*et_save(EditText)의 텍스트를 value로 설정*/
        et_save.setText(value);
    }

    /*앱이 종료되었을 때 수행되는 생명 주기*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        /*String 형태의 value에 et_save(EditText)에서 텍스트를 문자열로 가져와 저장*/
        String value = et_save.getText().toString();

        /*file.xml에서 private 모드로 SharedPreferences를 가져오고, sharedPreferences에 저장*/
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        /*SharedPreferences에 기록하기 위한 클래스 Editor의 참조 변수 editor를 선언,
        * 이 editor에 앱에서 쓰이는 sharedPreferences의 edit() 메소드를 저장한다. */
        SharedPreferences.Editor editor = sharedPreferences.edit();

        /*이 editor에 키 값이 "KHJ"이고 값이 value인 데이터를 문자열로 저장한다.*/
        editor.putString("KHJ", value);

        /*editor에 commit하여 데이터를 저장한다.*/
        editor.commit();
    }
}