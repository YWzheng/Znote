package com.ywzheng.cell.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ywzheng.cell.R;
import com.ywzheng.cell.adapter.ListViewBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yongwei on 2016/8/31.
 */

public class Bfragment extends Fragment {

    private static Bfragment aFragment;
    @BindView(R.id.listview)
    ListView mListview;


    public static Bfragment newInstance() {
        if (aFragment != null) {
            return aFragment;
        }
        synchronized (Bfragment.class) {
            if (aFragment == null) {
                return new Bfragment();
            }
        }
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_list_view, container, false);
        ButterKnife.bind(this, view);
        mListview.setAdapter(new ListViewBaseAdapter(getActivity()));

        return view;
    }
}
