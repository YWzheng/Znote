package com.ywzheng.welcome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.ywzheng.welcome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Mfragment extends Fragment {

    private static Mfragment mfragment;
    @BindView(R.id.launch_icon)
    ImageView mLaunchIcon;
    @BindView(R.id.content)
    FrameLayout mContent;


    public static Mfragment newInstance() {
        if (mfragment != null) {
            return mfragment;
        }
        synchronized (Afragment.class) {
            if (mfragment == null) {
                return new Mfragment();
            }
        }
        return mfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.splash_view_m, container, false);
        ButterKnife.bind(this, view);
        iconIn();
        return view;

    }
    private void iconIn() {
        Animation anim = AnimationUtils.loadAnimation(getActivity(),
                R.anim.anim_launch_item_fade_in);
        anim.setStartOffset(560);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = AnimationUtils.loadAnimation(getActivity(),
                        R.anim.anim_launch_item_scale_in);
                mLaunchIcon.setVisibility(View.VISIBLE);
                mLaunchIcon.startAnimation(anim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mContent.startAnimation(anim);
    }

}
