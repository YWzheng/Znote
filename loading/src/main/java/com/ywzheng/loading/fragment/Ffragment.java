package com.ywzheng.loading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.loading.R;
import com.ywzheng.loading.widget.book.BookLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.button;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Ffragment extends Fragment {

    private static Ffragment ffragment;
    @BindView(R.id.bookloading)
    BookLoading mBookloading;


    public static Ffragment newInstance() {
        if (ffragment != null) {
            return ffragment;
        }
        synchronized (Ffragment.class) {
            if (ffragment == null) {
                return new Ffragment();
            }
        }
        return ffragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_loading_04, container, false);
        ButterKnife.bind(this, view);
        if (mBookloading.isStart()) {
            mBookloading.stop();
        } else {
            mBookloading.start();
        }
        return view;
    }
}
