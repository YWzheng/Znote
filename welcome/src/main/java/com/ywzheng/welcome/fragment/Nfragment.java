package com.ywzheng.welcome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.ywzheng.welcome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Nfragment extends Fragment {

    private static Nfragment nfragment;
    @BindView(R.id.content)
    FrameLayout mContent;


    public static Nfragment newInstance() {
        if (nfragment != null) {
            return nfragment;
        }
        synchronized (Afragment.class) {
            if (nfragment == null) {
                return new Nfragment();
            }
        }
        return nfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.splash_view_n, container, false);

        ButterKnife.bind(this, view);
        mContent.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.splash_alpha_anim));
        return view;

    }


}
