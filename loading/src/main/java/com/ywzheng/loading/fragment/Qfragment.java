package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;

import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Qfragment extends Fragment {

    private static Qfragment qfragment;


    public static Qfragment newInstance() {
        if (qfragment != null) {
            return qfragment;
        }
        synchronized (Qfragment.class) {
            if (qfragment == null) {
                return new Qfragment();
            }
        }
        return qfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_f, container, false);
        ButterKnife.bind(this, view);
        return view;
    }



}
