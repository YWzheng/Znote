package com.ywzheng.loading.adpter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ywzheng.loading.fragment.Afragment;
import com.ywzheng.loading.fragment.Bfragment;
import com.ywzheng.loading.fragment.Cfragment;
import com.ywzheng.loading.fragment.Dfragment;
import com.ywzheng.loading.fragment.Efragment;
import com.ywzheng.loading.fragment.Ffragment;
import com.ywzheng.loading.fragment.Gfragment;
import com.ywzheng.loading.fragment.Hfragment;

/**
 * Created by yongwei on 16/8/26.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] mTitles = {"系统", "自定义", "直播", "分区", "发现", "直播", "分区", "发现", "直播", "分区", "发现"};
    private Fragment[] fragments;
    private int fragmentSize = 9;

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
                case 2:
                    fragments[position] = Cfragment.newInstance();
                    break;
                case 3:
                    fragments[position] = Dfragment.newInstance();
                    break;
                case 4:
                    fragments[position] = Afragment.newInstance();
                    break;
                case 5:
                    fragments[position] = Efragment.newInstance();
                    break;
                case 6:
                    fragments[position] = Ffragment.newInstance();
                    break;
                case 7:
                    fragments[position] = Gfragment.newInstance();
                    break;
                case 8:
                    fragments[position] = Hfragment.newInstance();
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
        return mTitles[position];
    }
}
