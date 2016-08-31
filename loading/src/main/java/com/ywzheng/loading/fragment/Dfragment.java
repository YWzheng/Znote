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

public class Dfragment extends Fragment {

    private static Dfragment dfragment;

    public static Dfragment newInstance() {
        if (dfragment != null) {
            return dfragment;
        }
        synchronized (Dfragment.class) {
            if (dfragment == null) {
                return new Dfragment();
            }
        }
        return dfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_loading_02, container, false);
    }
}
