package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.DouBanLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Afragment extends Fragment {

    private static Afragment aFragment;
    @BindView(R.id.douban)
    DouBanLoadingView mDouban;

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

        View view = inflater.inflate(R.layout.loading_a, container, false);
        ButterKnife.bind(this, view);
        mDouban.showLoading();
        return view;
    }

}
