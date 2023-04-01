package com.example.FragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    public Fragment1(){

    }
    Context mContext;
    /*MainActivity에서 뷰가 생성될 때 실행되는 생명주기(onCreate)가 있다면 Fragment에서도 뷰가 생성될 때
    * 실행되는 생명주기(onCreateView)가 있음. MainActivity 에서 fragment1 변수를 선언했을 때 다음 생명 주기가
    * 수행된다.*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = container.getContext();

        /*Fragment1의 뷰가 생성될 때 fragment1.xml의 레이아웃들을 객체화 하여 View를 return 한다*/
        return inflater.inflate(R.layout.fragment1, container, false);
    }
}
