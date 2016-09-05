package com.ywzheng.cell.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.cell.R;
import com.ywzheng.cell.adapter.RecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by yongwei on 2016/8/31.
 */

public class Afragment extends Fragment {

    private static Afragment aFragment;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    public static Afragment newInstance() {
        if (aFragment != null) {
            return aFragment;
        }
        synchronized (Afragment.class) {
            if (aFragment == null) {
                return new Afragment();
            }
        }
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity()));
        ButterKnife.bind(this, view);
        return view;
    }
}
