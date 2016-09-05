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

public class Pfragment extends Fragment {

    private static Pfragment pfragment;


    public static Pfragment newInstance() {
        if (pfragment != null) {
            return pfragment;
        }
        synchronized (Pfragment.class) {
            if (pfragment == null) {
                return new Pfragment();
            }
        }
        return pfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_f, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
