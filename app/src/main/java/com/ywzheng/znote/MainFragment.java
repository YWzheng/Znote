package com.ywzheng.znote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yongwei on 2016/8/24.
 */

public class MainFragment extends Fragment {
    public static final String TAG = "MainFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_view_12, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //some of code such as view.findViewById()
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public MainFragment() {
        setExitTransition(new Slide());
    }
}
