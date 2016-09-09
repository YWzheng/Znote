package com.ywzheng.znote.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.ywzheng.znote.R;
import com.ywzheng.znote.ui.WebViewUtils;


/**
 * Created by yongwei on 2016/8/23.
 * webView:
 * 1.需要权限：ACCESS_NETWORK_STATE，INTERNET
 * 2.
 */
public class WebViewActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_11);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mWebView = (WebView) findViewById(R.id.webView);

        WebViewUtils.initWebView(this,mWebView,mProgressBar);

        //加载网络
//        mWebView.loadUrl("http://www.jianshu.com/users/fdb2c33b32ea/latest_articles");
        //加载本地
        mWebView.loadUrl("file:///android_asset/LeisureIntroduction.html");
    }


}
