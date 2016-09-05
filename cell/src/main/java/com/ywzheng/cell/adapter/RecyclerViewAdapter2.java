package com.ywzheng.cell.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.cell.R;

/**
 * Created by yongwei on 2016/9/2.
 */

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder> {
    private Context context;

    public RecyclerViewAdapter2(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_01, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);

        }
    }

}
