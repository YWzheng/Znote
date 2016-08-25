package com.ywzheng.znote.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止滑动的viewpager
 */
public class NoscrollViewPager extends ViewPager {

    public NoscrollViewPager(Context context) {
        super(context);
    }

    public NoscrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    //* 事件不处理触摸事件，返回false
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    //false：不拦截儿子的触摸事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
