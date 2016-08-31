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

public class Afragment extends Fragment {

    private static Afragment aFragment;

    public static Afragment newInstance() {
        if (aFragment != null) {
            return aFragment;
        }
        synchronized (Afragment.class) {
            if (aFragment == null) {
                return new Afragment();
            }
        }
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.splash_view_01, container, false);
    }
}
