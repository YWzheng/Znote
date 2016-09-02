package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.Battery;
import com.ywzheng.loading.widget.Block;
import com.ywzheng.loading.widget.ChromeLogo;
import com.ywzheng.loading.widget.CircularJump;
import com.ywzheng.loading.widget.CircularZoom;
import com.ywzheng.loading.widget.EatBeans;
import com.ywzheng.loading.widget.News;
import com.ywzheng.loading.widget.PlayBall;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Nfragment extends Fragment {

    private static Nfragment mfragment;
    @BindView(R.id.lv_circularCD)
    CircularJump mLvCircularCD;
    @BindView(R.id.lv_circular)
    PlayBall mLvCircular;
    @BindView(R.id.lv_finePoiStar)
    News mLvFinePoiStar;
    @BindView(R.id.lv_circularSmile)
    ChromeLogo mLvCircularSmile;
    @BindView(R.id.lv_gears)
    Battery mLvGears;
    @BindView(R.id.lv_gears_two)
    Block mLvGearsTwo;
    @BindView(R.id.lv_wifi)
    EatBeans mLvWifi;
    @BindView(R.id.lv_circularring)
    CircularZoom mLvCircularring;


    public static Nfragment newInstance() {
        if (mfragment != null) {
            return mfragment;
        }
        synchronized (Nfragment.class) {
            if (mfragment == null) {
                return new Nfragment();
            }
        }
        return mfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_d, container, false);
        ButterKnife.bind(this, view);

        onClick();
        return view;
    }

    private void onClick() {
        mLvCircularCD.startAnim();
        mLvCircular.startAnim();
        mLvFinePoiStar.startAnim();
        mLvCircularSmile.startAnim();
        mLvGears.startAnim();
        mLvGearsTwo.startAnim();
        mLvWifi.startAnim();
        mLvCircularring.startAnim();

    }
}
