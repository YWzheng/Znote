package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.NiceLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Ifragment extends Fragment {

    private static Ifragment ifragment;
    @BindView(R.id.nice_loading)
    NiceLoadingView mNiceLoading;

    public static Ifragment newInstance() {
        if (ifragment != null) {
            return ifragment;
        }
        synchronized (Ifragment.class) {
            if (ifragment == null) {
                return new Ifragment();
            }
        }
        return ifragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_07, container, false);
        ButterKnife.bind(this, view);
        mNiceLoading.start();
//        mNiceLoading.success();
//        mNiceLoading.failed();
        return view;
    }
}
