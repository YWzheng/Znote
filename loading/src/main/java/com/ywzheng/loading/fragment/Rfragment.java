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
import com.ywzheng.loading.widget.FlikerProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Rfragment extends Fragment {

    private static Rfragment rfragment;
    @BindView(R.id.flikerbar)
    FlikerProgressBar mFlikerbar;


    public static Rfragment newInstance() {
        if (rfragment != null) {
            return rfragment;
        }
        synchronized (Rfragment.class) {
            if (rfragment == null) {
                return new Rfragment();
            }
        }
        return rfragment;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mFlikerbar.setProgress(msg.arg1);
            if (msg.arg1 == 100) {
                mFlikerbar.finishLoad();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_11, container, false);
        ButterKnife.bind(this, view);
        mFlikerbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mFlikerbar.isFinish()) {
                    mFlikerbar.toggle();
                }
            }
        });

        downLoad();
        return view;
    }

    private void downLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(200);
                        Message message = handler.obtainMessage();
                        message.arg1 = i + 1;
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
