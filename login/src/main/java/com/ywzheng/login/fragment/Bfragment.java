package com.ywzheng.login.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.login.R;


/**
 * Created by yongwei on 2016/8/31.
 */

public class Bfragment extends Fragment {

    private static Bfragment bFragment;

    public static Bfragment newInstance() {
        if (bFragment != null) {
            return bFragment;
        }
        synchronized (Afragment.class) {
            if (bFragment == null) {
                return new Bfragment();
            }
        }
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_view_02, container, false);
    }
}
