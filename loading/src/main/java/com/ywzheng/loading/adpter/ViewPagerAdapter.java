package com.ywzheng.loading.adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by yongwei on 2016/8/26.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    private ArrayList<View> mList;

    /**
     * @param context
     */
    public ViewPagerAdapter(Context context) {
        mContext = context;
        mList = new ArrayList<View>();
    }

    /**
     * @param item
     */
    public void add(View item) {
        mList.add(item);
    }

    /**
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View item = mList.get(position);
        container.addView(item);
        return item;

    }

    /**
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * @return　size
     */
    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    /**
     * @param view
     * @param object
     * @return true
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View) object;
    }
}
