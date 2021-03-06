package com.ywzheng.login.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ywzheng.login.fragment.Afragment;
import com.ywzheng.login.fragment.Bfragment;
import com.ywzheng.login.fragment.Cfragment;
import com.ywzheng.login.fragment.Dfragment;
import com.ywzheng.login.fragment.Efragment;
import com.ywzheng.login.fragment.Ffragment;


/**
 * Created by yongwei on 16/8/26.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;
    private int fragmentSize=6;

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
                    fragments[position] = Efragment.newInstance();
                    break;
                case 5:
                    fragments[position] = Ffragment.newInstance();
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
        return null;
    }
}
