package com.ywzheng.cell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ywzheng.cell.R;

/**
 * Created by yongwei on 2016/9/5.
 */

public class ListViewBaseAdapter extends BaseAdapter {

    private Context mContext;

    public ListViewBaseAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return 50;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_view_01, parent, false);
        return view;
    }
}
