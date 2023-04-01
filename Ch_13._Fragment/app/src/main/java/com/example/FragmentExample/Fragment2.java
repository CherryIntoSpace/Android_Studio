package com.example.FragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    public Fragment2(){

    }

    /*MainActivity에서 뷰가 생성될 때 실행되는 생명주기(onCreate)가 있다면 Fragment에서도 뷰가 생성될 때
    * 실행되는 생명주기(onCreateView)가 있음음*/
   @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }
}
