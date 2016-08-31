package com.ywzheng.welcome;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ywzheng.welcome.adapter.FragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mViewpager.setOffscreenPageLimit(1);
        mViewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        //xml中设置字体
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
