package com.ywzheng.welcome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.welcome.R;
import com.ywzheng.welcome.widget.ParticleView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Ifragment extends Fragment {

    private static Ifragment bFragment;
    @BindView(R.id.pv_1)
    ParticleView mPv1;

    public static Ifragment newInstance() {
        if (bFragment != null) {
            return bFragment;
        }
        synchronized (Afragment.class) {
            if (bFragment == null) {
                return new Ifragment();
            }
        }
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_view_i, container, false);
        ButterKnife.bind(this, view);
        mPv1.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPv1.startAnim();
            }
        }, 10);

        return view;
    }


}
