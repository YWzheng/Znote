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

public class Bfragment extends Fragment {

    private static Bfragment bfragment;

    public static Bfragment newInstance() {
        if (bfragment != null) {
            return bfragment;
        }
        synchronized (Bfragment.class) {
            if (bfragment == null) {
                return new Bfragment();
            }
        }
        return bfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loading_03, container, false);
    }
}
