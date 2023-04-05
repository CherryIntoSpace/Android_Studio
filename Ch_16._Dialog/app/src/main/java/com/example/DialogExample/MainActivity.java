package com.example.DialogExample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_et;
    Button btn_mlist;
    Button btn_slist;
    TextView tv_result;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*btn_et는 EditText AlertDialog를 띄우는 Button이고 btn_mlist는 다중 리스트 선택 AlertDialog를
         * 띄우는 Button, btn_slist는 싱글 리스트 선택 AlertDialog를 띄우는 Button이다.*/
        btn_et = findViewById(R.id.btn_dialog);
        btn_mlist = findViewById(R.id.btn_dialog2);
        btn_slist = findViewById(R.id.btn_dialog3);
        tv_result = findViewById(R.id.tv_result);
        list = findViewById(R.id.list);

        /*btn_et(Button)을 눌렀을 때 수행되는 생명 주기*/
        btn_et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog란 사용자의 전체화면을 가리지 않으면서 사용자의 응답이나 추가 정보를 입력하도록
                 * 하는 작은 창을 말함. AlertDialog를 구성하기 위해서는 AlertDialog.Builder의 참조변수를
                 * 선언해줘야 함.(ad) */
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                /*AlertDialog 최상단에 위치하고 있는 아이콘과 제목을 setIcon(), setTitle() 메소드를 통하여
                 * 변경할 수 있음.*/
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle("제목");

                /*AlertDialog의 중간에 위치한 메세지(주로 사용자에게 질의문을 제시함)를 setMessage() 메소드
                 * 를 통해 설정할 수 있음.*/
                ad.setMessage("KHJ?");

                /*AlertDialog는 또한 setView() 메소드를 통해
                사용자 정의 뷰를 화면에 출력해줄 수 있다.(여기선 EditText 위젯을 사용해
                 사용자로부터 입력 받음)*/
                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);

                /*ad(AlertDialog)에서 setPositiveButton()와 setNegativeButton() 메소드를 통해
                Confirm(확인)이나 Cancel(취소)과 같이 긍정·부정 버튼을 구현할 수 있다. */

                /*다음은 "확인" text와 OnClickListener 리스너로 이루어진 긍정 버튼이
                 눌러졌을 때의 생명 주기를 정의한다.*/
                ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*위에서 정의한 et(EditText)로부터 Text를 읽어들여 String으로 전환한 뒤
                         * String 타입의 result 변수에 저장한다.*/
                        String result = et.getText().toString();

                        /*다음 tv_result(TextView)를 result로 setText 한다.*/
                        tv_result.setText(result);

                        /*마지막으로 dismiss()를 통해 DialogInterface 창을 닫는다.*/
                        dialogInterface.dismiss();
                    }
                });

                /*"취소" text와 OnClickListener 리스너로 이루어진 부정 버튼이
                눌러졌을 때의 생명 주기를 정의한다.*/
                ad.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*"취소" 버튼이 눌러졌을 때는 그냥 DialogInterface 창만 닫는다.*/
                        dialogInterface.dismiss();
                    }
                });

                /*ad(AlertDialog) 구성이 끝났으므로 마지막으로 btn_dialog이 눌러졌을 때 ad를 show() 한다. */
                ad.show();
            }
        });

        /*SelectedItems은 사용자가 AlertDialog에서 선택한 항목들을 저장해놓는 List,
        adapter는 activity_main의 list와 SelectedItems을 연결해주는 ArrayAdapter*/
        final List SelectedItems = new ArrayList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SelectedItems);
        list.setAdapter(adapter);

        /*AlertDialog의 선택 항목 리스트를 나타내기 위한 ListItems(List 타입)*/
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("KHJ Cherry");
        ListItems.add("KHJ Into");
        ListItems.add("KHJ Space");

        /*ListItems를 AlertDialog로 나타내기 위해서는 배열로 바꿔줘야 함(ConvertedItems)*/
        final String[] ConvertedItems = ListItems.toArray(new String[ListItems.size()]);

        /*btn_mlist(Button)을 눌렀을 때 수행되는 생명 주기*/
        btn_mlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AlertDialog 구성을 위한 참조변수 ad 선언*/
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                /*ad의 제목 설정(setTitle)*/
                ad.setTitle("AlertDialog Multi List");

                /*ad를 다중 선택 리스트로 설정(인자는 1.배열(ConvertedItems), 2.배열에서 체크 or 체크해제할 항목 지정
                 * , 3.클릭 리스너*/
                ad.setMultiChoiceItems(ConvertedItems, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int pos, boolean isChecked) {
                        /*체크 여부를 확인하는 isChecked, ListItems에서 항목 클릭시 해당 항목의 위치를 불러오는
                         * pos 변수를 인자로 함*/

                        /*pos에 위치한 해당 항목을 클릭하여 isChecked가 참이되었을 때, 이 항목이 SelectedItems에
                         * 위치한다면 SelectedItems에 이 항목을 지움*/
                        if (isChecked) {
                            if (SelectedItems.contains(ListItems.get(pos))) {
                                SelectedItems.remove(ListItems.get(pos));
                            }
                            /*반대로 존재하지 않는다면 SelectedItems에 이 항목을 추가함*/
                            else {
                                SelectedItems.add(ListItems.get(pos));
                            }
                        }
                    }
                });

                /*ad(MultiChoiceItems)에서 "Ok" (긍정)버튼을 눌렀을 때 수행되는 생명 주기*/
                ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int pos) {
                        /*list와 SelectedItems가 연결된 adapter에 데이터 변경 신호를 보내어 list를 갱신함
                        (notifyDataSetChanged)*/
                        adapter.notifyDataSetChanged();

                        /*DialogInterface 창을 닫음*/
                        dialogInterface.dismiss();
                    }
                });
                /*ad(MultiChoiceItems)에서 "Cancel" (부정)버튼을 눌렀을 때 수행되는 생명 주기*/
                ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*DialogInterface 창을 닫음*/
                        dialogInterface.dismiss();
                    }
                });
                /*마지막으로 정의가 끝난 해당 ad를 show()함*/
                ad.show();
            }
        });

        /*btn_slist(Button)을 눌렀을 때 수행되는 생명 주기*/
        btn_slist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*시작 체크위치는 0, 즉 ListItems의 첫번째 원소를 가리키고 있음. 바로 "Ok" 버튼을 눌러
                * 재클릭 없이 첫번째 원소를 adapter에 갱신하는 것을 위하여 미리 SelectedItems의 clear와
                * add(ListItems.get(defaultItem))을 해줌*/
                SelectedItems.clear();
                int defaultItem = 0;
                SelectedItems.add(ListItems.get(defaultItem));

                /*AlertDialog 구성을 위한 참조변수 ad 선언*/
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                /*ad(SingleChoiceItems)의 제목 지정*/
                ad.setTitle("AlertDialog Single List");

                /*ad(SingleChoiceItems)를 단일 선택 리스트로 설정(인자 : 1.항목 배열(ConvertedItems),
                2.시작 체크 위치(defaultItem), 3.클릭 리스너*/
                ad.setSingleChoiceItems(ConvertedItems, defaultItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int pos) {
                        /*SelectedItems를 clear 해주고 클릭한 pos 위치의 항목을 add함*/
                        SelectedItems.clear();
                        SelectedItems.add(ListItems.get(pos));
                    }
                });

                /*ad(SingleChoiceItems)에서 "Ok" 버튼(긍정)을 눌렀을 때 수행되는 생명 주기*/
                ad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*list와 SelectedItems가 연결된 adapter에 데이터 변경 신홀를 보내어 list를 갱신
                        * (notifyDataSetChanged)*/
                        adapter.notifyDataSetChanged();

                        /*DialogInterface 창을 닫음*/
                        dialogInterface.dismiss();
                    }
                });

                /*ad(SingleChoiceItems)에서 "Cancel" 버튼(부정)을 눌렀을 때 수행되는 생명 주기*/
                ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        /*DialogInterface 창을 닫음*/
                        dialogInterface.dismiss();
                    }
                });

                /*마지막으로 정의가 끝난 해당 ad를 show()함*/
                ad.show();
            }
        });
    }
}