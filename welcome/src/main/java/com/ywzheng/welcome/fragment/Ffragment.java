package com.ywzheng.welcome.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ywzheng.welcome.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Ffragment extends Fragment {

    private static Ffragment bFragment;
    @BindView(R.id.splash_image)
    ImageView mSplashImage;

    public static Ffragment newInstance() {
        if (bFragment != null) {
            return bFragment;
        }
        synchronized (Afragment.class) {
            if (bFragment == null) {
                return new Ffragment();
            }
        }
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash_view_f, container, false);
        ButterKnife.bind(this, view);

        mSplashImage.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        return view;
    }
}
