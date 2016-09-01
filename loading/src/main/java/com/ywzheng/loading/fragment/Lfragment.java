package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.catloading.CatLoadingView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Lfragment extends Fragment {

    private static Lfragment lfragment;
    @BindView(R.id.start)
    Button mStart;

    public static Lfragment newInstance() {
        if (lfragment != null) {
            return lfragment;
        }
        synchronized (Lfragment.class) {
            if (lfragment == null) {
                return new Lfragment();
            }
        }
        return lfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_10, container, false);
        ButterKnife.bind(this, view);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CatLoadingView mView = new CatLoadingView();
                mView.show(getActivity().getSupportFragmentManager(), "");
            }
        });

        return view;
    }
}
