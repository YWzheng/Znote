package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.LineWithText;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Bfragment extends Fragment {

    private static Bfragment bfragment;
    @BindView(R.id.linewithtext)
    LineWithText mLinewithtext;

    int mValueLVLineWithText = 0;
    public Timer mTimerLVLineWithText = new Timer();// 定时器

    public static Bfragment newInstance() {
        if (bfragment != null) {
            return bfragment;
        }
        synchronized (Bfragment.class) {
            if (bfragment == null) {
                return new Bfragment();
            }
        }
        return bfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_b, container, false);
        ButterKnife.bind(this, view);
        startLVLineWithTextAnim();
        return view;
    }

    private void startLVLineWithTextAnim() {
        mValueLVLineWithText = 0;
        if (mTimerLVLineWithText != null) {
            mTimerLVLineWithText.cancel();// 退出之前的mTimer
        }
        mTimerLVLineWithText = new Timer();
        timerTaskLVLineWithText();
    }

    public void timerTaskLVLineWithText() {
        mTimerLVLineWithText.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mValueLVLineWithText < 100) {

                    mValueLVLineWithText++;
                    Message msg = mHandle.obtainMessage(2);
                    msg.arg1 = mValueLVLineWithText;
                    mHandle.sendMessage(msg);

                } else {
                    mTimerLVLineWithText.cancel();
                }
            }
        }, 0, 50);
    }

    private Handler mHandle = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 2)
                mLinewithtext.setValue(msg.arg1);
        }
    };
}
