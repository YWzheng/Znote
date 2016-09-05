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
import com.ywzheng.loading.fragment.Ifragment;
import com.ywzheng.loading.fragment.Jfragment;
import com.ywzheng.loading.fragment.Kfragment;
import com.ywzheng.loading.fragment.Lfragment;
import com.ywzheng.loading.fragment.Mfragment;
import com.ywzheng.loading.fragment.Nfragment;
import com.ywzheng.loading.fragment.Ofragment;
import com.ywzheng.loading.fragment.Pfragment;

/**
 * Created by yongwei on 16/8/26.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private final String[] mTitles = {"系统", "自定义", "直播", "分区", "发现", "直播", "分区", "发现", "直播", "分区", "发现", "发现", "发现"};
    private Fragment[] fragments;
    private int fragmentSize = 16;

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
                case 4:
                    fragments[position] = Cfragment.newInstance();
                    break;
                case 3:
                    fragments[position] = Nfragment.newInstance();
                    break;
                case 2:
                    fragments[position] = Mfragment.newInstance();
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
                case 9:
                    fragments[position] = Ifragment.newInstance();
                    break;
                case 10:
                    fragments[position] = Jfragment.newInstance();
                    break;
                case 11:
                    fragments[position] = Kfragment.newInstance();
                    break;
                case 12:
                    fragments[position] = Lfragment.newInstance();
                    break;
                case 13:
                    fragments[position] = Dfragment.newInstance();
                    break;
                case 14:
                    fragments[position] = Ofragment.newInstance();
                    break;
                case 15:
                    fragments[position] = Pfragment.newInstance();
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
