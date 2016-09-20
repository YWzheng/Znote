package com.ywzheng.znote.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 */
public class FullVideoView extends VideoView {
    public FullVideoView(Context context) {
        super(context);
    }

    public FullVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        /*
        这段代码未经测试,不能确保使该videoView按最大的尺寸播放.尽量全部写为MeasureSpec.EXACTLY的
         */
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = getMeasuredWidth();//经过super按比例缩放的
        int measuredHeight = getMeasuredHeight();//经过super按比例缩放的


        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthSpecMode == MeasureSpec.EXACTLY && heightSpecMode == MeasureSpec.EXACTLY) {
            width = widthSpecSize;
            height = heightSpecSize;
        } else if (widthSpecMode == MeasureSpec.EXACTLY) {
            width = Math.max(widthMeasureSpec, measuredWidth);
            height = measuredHeight;
        } else if (heightSpecMode == MeasureSpec.EXACTLY) {
            width = measuredWidth;
            height = Math.max(heightMeasureSpec, measuredHeight);
        } else {
            width = measuredWidth;
            height = measuredHeight;
        }

        setMeasuredDimension(width, height);
    }

}
