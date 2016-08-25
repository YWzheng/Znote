package com.ywzheng.znote.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ywzheng.znote.R;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by yongwei on 2016/8/25.
 */

public class FontActivity extends AppCompatActivity {


    /*
    * 注意：如果不在appclication文件初始化CalligraphyConfig
    * 不设置字体的控件会采用手机默认字体
    * 初始化代码：
    * // Custom fonts
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    * */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_view_13);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        //xml中设置字体
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
