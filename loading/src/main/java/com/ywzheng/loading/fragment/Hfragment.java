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

public class Hfragment extends Fragment {

    private static Hfragment gfragment;

    public static Hfragment newInstance() {
        if (gfragment != null) {
            return gfragment;
        }
        synchronized (Hfragment.class) {
            if (gfragment == null) {
                return new Hfragment();
            }
        }
        return gfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_06, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
