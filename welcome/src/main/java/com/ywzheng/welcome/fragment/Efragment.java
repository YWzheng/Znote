package com.ywzheng.welcome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.welcome.R;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Efragment extends Fragment {

    private static Efragment bFragment;

    public static Efragment newInstance() {
        if (bFragment != null) {
            return bFragment;
        }
        synchronized (Afragment.class) {
            if (bFragment == null) {
                return new Efragment();
            }
        }
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_view_e, container, false);
    }
}
