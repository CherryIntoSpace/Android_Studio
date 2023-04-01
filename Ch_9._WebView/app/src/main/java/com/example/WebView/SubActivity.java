package com.example.WebView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SubActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        /*SubActivity의 intent는 MainActivity가 송신한 intent를 수신하는 intent이다.*/
        Intent intent = getIntent();

        /*String 형태의 url 변수는 이 intent로부터 키 값(name)이 "url"인 문자열을 받아와 저장한다.*/
        String url = intent.getStringExtra("url");

        webView = findViewById(R.id.webview);

        /*이 webView(WebView)에 대하여 자바스크립트 설정과 url 변수를 참조하여 해당 주소에 요청을 보내고,
        * 크롬 브라우저에 맞는 환경 조성, 사이트를 이동할 때 새 창을 열지 않고 WebView 내에서 다시 엶으로써
        * 페이지 이동을 원할하게 하는 기능이다.*/
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());
    }

    /*뒤로가기(Back) 키를 눌렀을 때 수행되는 생명 주기*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*뒤로가기 키가 눌렸고, WebView 내에서 페이지 뒤로 가기가 가능할 때 이전 페이지로 간다.*/
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /*사이트를 이동할 때 새 창을 열지 않고 WebView 내에서 다시 엶으로써
     * 페이지 이동을 원할하게 하는 기능 정의*/
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}