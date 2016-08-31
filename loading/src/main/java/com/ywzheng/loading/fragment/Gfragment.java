package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.newton.NewtonCradleLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Gfragment extends Fragment {

    private static Gfragment gfragment;
    @BindView(R.id.newton_cradle_loading)
    NewtonCradleLoading mNewtonCradleLoading;


    public static Gfragment newInstance() {
        if (gfragment != null) {
            return gfragment;
        }
        synchronized (Gfragment.class) {
            if (gfragment == null) {
                return new Gfragment();
            }
        }
        return gfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_05, container, false);
        ButterKnife.bind(this, view);
        if (mNewtonCradleLoading.isStart()) {
            mNewtonCradleLoading.stop();
        } else {
            mNewtonCradleLoading.start();
        }
        return view;
    }
}
