package com.ywzheng.cell.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ywzheng.cell.utils.DataUtils;

/**
 * Created by yongwei on 2016/9/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private final String mString;
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        mString = DataUtils.loadJSONFromAsset(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, android.R.layout.simple_list_item_2, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(position + "");
        if (position % 2 == 0) {
            holder.mDescTextView.setVisibility(View.VISIBLE);
            holder.mDescTextView.setText(position + "111");
        } else {
            holder.mDescTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        TextView mDescTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
            mDescTextView = (TextView) itemView.findViewById(android.R.id.text2);
        }
    }

}
