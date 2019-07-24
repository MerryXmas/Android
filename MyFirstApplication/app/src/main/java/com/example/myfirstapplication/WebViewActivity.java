package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient(){
//           测试，此方法被废除
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com");
        setContentView(webView);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK ){
            if(webView.canGoBack()){
                webView.goBack();
            }else {
                if ((System.currentTimeMillis() - exitTime) > 2000){
                    Toast.makeText(WebViewActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    exitTime = System.currentTimeMillis();
                }else {
                    return super.onKeyDown(keyCode,event);
                }
            }
        }
        return true;
    }
    //点击返回按钮方法
//    public  void onBackPressed(){
//            if(webView.canGoBack()){
//                webView.goBack();
//            }else {
//                if ((System.currentTimeMillis() - exitTime) > 1000){
//                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                    exitTime = System.currentTimeMillis();
//                }else {
//                    super.onBackPressed();
//                }
//            }
//        }
}
