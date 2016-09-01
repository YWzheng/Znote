package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.NumberProgress;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Kfragment extends Fragment {

    private static Kfragment ifragment;
    @BindView(R.id.number_progress3)
    NumberProgress mNumberProgress3;

    private int current = 0;

    public static Kfragment newInstance() {
        if (ifragment != null) {
            return ifragment;
        }
        synchronized (Kfragment.class) {
            if (ifragment == null) {
                return new Kfragment();
            }
        }
        return ifragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_09, container, false);
        ButterKnife.bind(this, view);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                current++;
                if (current > 100) {
                    current = 0;
                }
                mNumberProgress3.setCurrentProgress(current);
                handler.postDelayed(this, 100);
            }
        }, 100);
        return view;
    }
}
