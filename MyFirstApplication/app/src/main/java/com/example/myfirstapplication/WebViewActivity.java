package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;
    private RelativeLayout relativeLayout;
    private LinearLayout parentLayout;
    private Button button;
    private int index = 0;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        parentLayout = findViewById(R.id.parent_view);
        //代码中动态new出UI控件
        relativeLayout = new RelativeLayout(WebViewActivity.this);
        webView = new WebView(WebViewActivity.this);
        button = new Button(WebViewActivity.this);
        //设置控件LayoutParams
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutParams);
        //设置控件属性
        webView.setId(R.id.web_view);
        button.setHeight(100);
        button.setWidth(100);
        button.setId(R.id.button);
        button.setText("全屏浏览");
        //将LinearLayout放入parentLayout中
        parentLayout.addView(relativeLayout);
        relativeLayout.addView(webView);
        relativeLayout.addView(button);
        //设置控件位置布局
        RelativeLayout.LayoutParams btnParams = (RelativeLayout.LayoutParams) button.getLayoutParams();
        btnParams.addRule(RelativeLayout.ALIGN_BOTTOM,R.id.web_view);
        btnParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                WebViewActivity.this.setTitle(title);
                Log.e("网页标题为",title);
                super.onReceivedTitle(view, title);
            }
        });
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
//        使用代码动态布局不能重复添加
//        setContentView(webView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index == 0){
                    view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                    button.setText("退出全屏");
                    index = 1;
                }else {
                    view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    button.setText("全屏浏览");
                    index = 0;
                }
            }
        });
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
