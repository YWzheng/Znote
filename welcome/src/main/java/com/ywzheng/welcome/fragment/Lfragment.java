package com.ywzheng.welcome.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.ywzheng.welcome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Lfragment extends Fragment {

    private static Lfragment jfragment;
    @BindView(R.id.logo_outer_iv)
    ImageView mLogoOuterIv;
    @BindView(R.id.logo_inner_iv)
    ImageView mLogoInnerIv;
    @BindView(R.id.app_name_tv)
    TextView mAppNameTv;

    public static Lfragment newInstance() {
        if (jfragment != null) {
            return jfragment;
        }
        synchronized (Afragment.class) {
            if (jfragment == null) {
                return new Lfragment();
            }
        }
        return jfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.splash_view_k, container, false);
        ButterKnife.bind(this, view);
        initAnimation();
        return view;

    }

    private void initAnimation() {
        startLogoInner1();
        startLogoOuterAndAppName();
    }

    private void startLogoInner1() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_top_in);
        mLogoInnerIv.startAnimation(animation);
    }

    private void startLogoOuterAndAppName() {
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                if (fraction >= 0.8) {

                } else if (fraction >= 0.95) {
                    valueAnimator.cancel();
                }

            }
        });
        valueAnimator.start();
    }
}
