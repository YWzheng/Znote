package com.ywzheng.cell.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ywzheng.cell.R;

/**
 * Created by yongwei on 2016/9/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_16, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(position + "");
        if (position % 2 == 0) {
            holder.mDescTextView.setVisibility(View.VISIBLE);
            holder.mDescTextView.setText(position + "111");
            holder.mRbRating.setRating(2);
        }
        holder.mSubmitTime.setText("2016-9-5 11:58:24");
        holder.mRbRating.setRating(Float.valueOf("2.4"));
    }

    @Override
    public int getItemCount() {
        return 50;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mSubmitTime;
        TextView mTextView;
        TextView mDescTextView;
        RatingBar mRbRating;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_title);
            mDescTextView = (TextView) itemView.findViewById(R.id.tv_category);
            mSubmitTime = (TextView) itemView.findViewById(R.id.tv_submittime);
            mRbRating = (RatingBar) itemView.findViewById(R.id.rb_rating);
        }
    }

}
