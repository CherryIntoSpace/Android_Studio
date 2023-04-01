package com.example.ThreadExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*스레드란 백그라운드에서 작업을 할 수 있게 하는 기능(ex. 앱을 잠시 홈버튼을 눌러 앱에서 빠져나왔을 때,
 * 앱이 백그라운드 상태에 들어가는데 이 상태에서 처리할 수 있는 프로세스들을 정의할 수 있음)*/
public class MainActivity extends AppCompatActivity {

    Button btn_start, btn_stop;
    Thread thread;

    /*Thread의 시작을 판단할 flag*/
    boolean isThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);

        /*btn_start(Button)을 눌렀을 때 스레드 시작*/
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThread = true;

                /*thread 클래스 정의*/
                thread = new Thread() {

                    /*thread 클래스의 run() 메소드를 재정의*/
                    public void run() {

                        /*isThread가 true일 동안에 다음을 실행*/
                        while (isThread) {

                            /*5(=500millis)초 동안 sleep*/
                            try {
                                sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            /*sleep 이후에 handler 안의 Toast메세지가 5초 마다 계속 띄워짐*/
                            handler.sendEmptyMessage(0);
                        }
                    }
                };
                /*thread 시작*/
               thread.start();
            }
        });

        /*btn_stop(Button)을 눌렀을 때 스레드 종료*/
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*isThread를 false로 함으로써 더이상 스레드 시작을 막음*/
               isThread = false;
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Toast.makeText(getApplicationContext(), "KHJ's Thread", Toast.LENGTH_SHORT).show();
        }
    };
}