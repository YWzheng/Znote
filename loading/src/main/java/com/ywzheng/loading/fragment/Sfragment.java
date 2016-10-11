package com.ywzheng.loading.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.BounceLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Sfragment extends Fragment {

    private static Sfragment sfragment;
    @BindView(R.id.loadingView)
    BounceLoadingView mLoadingView;

    public static Sfragment newInstance() {
        if (sfragment != null) {
            return sfragment;
        }
        synchronized (Sfragment.class) {
            if (sfragment == null) {
                return new Sfragment();
            }
        }
        return sfragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_s, container, false);
        ButterKnife.bind(this, view);
        mLoadingView.addBitmap(R.drawable.v4);
        mLoadingView.addBitmap(R.drawable.v5);
        mLoadingView.addBitmap(R.drawable.v6);
        mLoadingView.addBitmap(R.drawable.v7);
        mLoadingView.addBitmap(R.drawable.v8);
        mLoadingView.addBitmap(R.drawable.v9);
        mLoadingView.setShadowColor(Color.LTGRAY);
        mLoadingView.setDuration(700);
        mLoadingView.start();
        return view;
    }

}
