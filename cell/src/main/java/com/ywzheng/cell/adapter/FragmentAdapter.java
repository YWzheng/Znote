package com.ywzheng.cell.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ywzheng.cell.fragment.Afragment;
import com.ywzheng.cell.fragment.Bfragment;


/**
 * Created by yongwei on 16/8/26.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private int fragmentSize = 2;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[fragmentSize];
    }


    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = Afragment.newInstance();
                    break;
                case 1:
                    fragments[position] = Bfragment.newInstance();
                    break;
                default:
                    fragments[position] = Afragment.newInstance();
                    break;

            }
        }

        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragmentSize;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "待定";
    }
}
