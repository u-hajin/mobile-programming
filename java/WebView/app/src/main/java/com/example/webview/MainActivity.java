package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    // AndroidManifest.xml에 인터넷 권한 설정 필요.

    private WebView webView;
    private String url = "https://www.google.co.kr/"; // 주소 지정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // JS를 허용.
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient()); // webview 환경을 크롬에 맟춤.
        webView.setWebViewClient(new WebViewClientClass());
        
    }

    // 뒤로가기 눌렀을 때 WebView가 종료되게

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { // 특정키가 입력됐을 때 동작 지정
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { // 현재 페이지의 url을 읽어온다.
            view.loadUrl(url);
            return true;
        }
    }
}