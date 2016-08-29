package com.ywzheng.znote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

/**
 * 杂记
 * Created by yongwei on 2016/8/29.
 */

public class Znote extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //获取安装应用列表
        getPackageManager().getInstalledApplications(0);

        //布局填充器
        LayoutInflater.from(this).inflate(R.layout.splash_view_01, null);

        //代码设置颜色
        TextView mTextView = new TextView(this);
        mTextView.setBackgroundColor(0xff0000bb);
    }
}
