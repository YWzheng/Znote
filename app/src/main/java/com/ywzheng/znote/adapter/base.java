package com.ywzheng.znote.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by yongwei on 2016/9/6.
 */

public class base extends BaseAdapter {


    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        switch (getItemViewType(position)) {
            case TYPE_ONE:
                break;
            case TYPE_TWO:
                break;
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if (true) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

}
