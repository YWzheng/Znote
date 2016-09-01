package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.CircleNumberProgress;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Jfragment extends Fragment {

    private static Jfragment ifragment;
    @BindView(R.id.number_circle)
    CircleNumberProgress mNumberCircle;
    private int current = 0;

    public static Jfragment newInstance() {
        if (ifragment != null) {
            return ifragment;
        }
        synchronized (Jfragment.class) {
            if (ifragment == null) {
                return new Jfragment();
            }
        }
        return ifragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_08, container, false);
        ButterKnife.bind(this, view);
        final Handler handler1 = new Handler();

        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                current++;
                if (current > 100) {
                    current = 0;
                }
                mNumberCircle.setCurrentProgress(current);
                handler1.postDelayed(this, 100);
            }
        }, 100);
        return view;
    }
}
