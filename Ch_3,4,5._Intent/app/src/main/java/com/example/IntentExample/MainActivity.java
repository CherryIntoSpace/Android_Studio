package com.example.IntentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;

    ImageView test_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);

        test_image = findViewById(R.id.test_image);
        /*test_image(ImageView)를 눌렀을 때 수행되는 생명 주기*/
        test_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Show Image",Toast.LENGTH_SHORT).show();
            }
        });

        btn_move = findViewById(R.id.btn_move);
        /*btn_move(Button)를 눌렀을 때 수행되는 생명 주기*/
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*et_test(EditText) 내에 입력된 문자들을 문자열로 전환하고
                위에서 선언한 String 형태의 str 변수에 저장*/
                str = et_test.getText().toString();

                /*Intent()의 첫번째 인자는 메세지를 보내는 액티비티, 두번째 인자는 호출될 액티비티를 의미
                * 이로써 MainActivity의 intent는 MainActivity에서
                * SubActivity로 데이터를 송신을 가능하게 해주는 객체가 되었다.*/
                Intent intent = new Intent(MainActivity.this, SubActivity.class);

                /*putExtra 메소드를 통하여 이름(키 값)이 "str"인 str 변수 데이터를 intent에 넣는다.*/
                intent.putExtra("str", str);

                /*이후 startActivity()를 통하여 다른 액티비티로 전달할 수 있다.*/
                startActivity(intent);
            }
        });
    }
}