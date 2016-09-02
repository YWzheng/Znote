package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.Circular;
import com.ywzheng.loading.widget.CircularCD;
import com.ywzheng.loading.widget.CircularRing;
import com.ywzheng.loading.widget.CircularSmile;
import com.ywzheng.loading.widget.FinePoiStar;
import com.ywzheng.loading.widget.Gears;
import com.ywzheng.loading.widget.GearsTwo;
import com.ywzheng.loading.widget.LVWifi;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Mfragment extends Fragment {

    private static Mfragment mfragment;

    @BindView(R.id.lv_circularCD)
    CircularCD mLvCircularCD;
    @BindView(R.id.lv_circular)
    Circular mLvCircular;
    @BindView(R.id.lv_finePoiStar)
    FinePoiStar mLvFinePoiStar;
    @BindView(R.id.lv_circularSmile)
    CircularSmile mLvCircularSmile;
    @BindView(R.id.lv_gears)
    Gears mLvGears;
    @BindView(R.id.lv_gears_two)
    GearsTwo mLvGearsTwo;
    @BindView(R.id.lv_wifi)
    LVWifi mLvWifi;
    @BindView(R.id.lv_circularring)
    CircularRing mLvCircularring;


    public static Mfragment newInstance() {
        if (mfragment != null) {
            return mfragment;
        }
        synchronized (Mfragment.class) {
            if (mfragment == null) {
                return new Mfragment();
            }
        }
        return mfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.loading_c, container, false);
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
