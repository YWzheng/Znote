package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Cfragment extends Fragment {

    private static Cfragment cfragment;

    public static Cfragment newInstance() {
        if (cfragment != null) {
            return cfragment;
        }
        synchronized (Cfragment.class) {
            if (cfragment == null) {
                return new Cfragment();
            }
        }
        return cfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_loading_01, container, false);
    }
}
