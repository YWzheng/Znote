package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.RotateLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.button;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Efragment extends Fragment {

    private static Efragment efragment;
    @BindView(R.id.rotateloading)
    RotateLoading mRotateloading;

    public static Efragment newInstance() {
        if (efragment != null) {
            return efragment;
        }
        synchronized (Efragment.class) {
            if (efragment == null) {
                return new Efragment();
            }
        }
        return efragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_03, container, false);
        ButterKnife.bind(this, view);
        if (mRotateloading.isStart()) {
            mRotateloading.stop();
        } else {
            mRotateloading.start();
        }
        return view;
    }
}
