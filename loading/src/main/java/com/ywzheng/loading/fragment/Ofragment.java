package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.butterfly.ButterFlyDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Ofragment extends Fragment {

    private static Ofragment mfragment;


    public static Ofragment newInstance() {
        if (mfragment != null) {
            return mfragment;
        }
        synchronized (Ofragment.class) {
            if (mfragment == null) {
                return new Ofragment();
            }
        }
        return mfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_o, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.butterfly)
    public void onClick() {
        new ButterFlyDialog(getActivity()).show();
    }
}
