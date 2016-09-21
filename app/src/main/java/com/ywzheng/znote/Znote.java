package com.ywzheng.znote;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.ywzheng.znote.http.pojo.KrTV;
import com.ywzheng.znote.http.pojo.KrTVData;
import com.ywzheng.znote.utils.my.AssetsUtil;
import com.ywzheng.znote.utils.my.GsonUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

        //AlertDialog 重点在于&#8226;这个符号的使用，列表项
        new AlertDialog.Builder(this)
                .setTitle("AppCompat Extension Library")
                .setMessage("A library that builds on the official AppCompat Design Library and provides additional common components:\\n &#8226; AccountHeaderView\\n &#8226; FloatingActionMenu\\n &#8226;\n" +
                        "        CircleImageView\\n &#8226; FlexibleToolbarLayout\\n &#8226; Delightful Detail Drawables\\n &#8226; TypefaceCompat")
                .setNeutralButton("View on Github", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String url = "https://github.com/TR4Android/AppCompat-Extension-Library";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                })
                .setNegativeButton("Dismiss", null)
                .show();

        //页面跳转动画，
//        Intent intent=new Intent();
//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, this., "View");
//        this.startActivity(intent, options.toBundle());

        //获取本地json数据并转换对象
        String s = AssetsUtil.readAssets(this, "example.json");
        KrTV krTV = GsonUtil.parseJson(s, KrTV.class);
        List<KrTVData> list = krTV.data;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
