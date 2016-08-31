package com.ywzheng.welcome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ywzheng.welcome.fragment.Afragment;
import com.ywzheng.welcome.fragment.Bfragment;
import com.ywzheng.welcome.fragment.Cfragment;
import com.ywzheng.welcome.fragment.Dfragment;
import com.ywzheng.welcome.fragment.Efragment;
import com.ywzheng.welcome.fragment.Ffragment;
import com.ywzheng.welcome.fragment.Gfragment;
import com.ywzheng.welcome.fragment.Hfragment;

/**
 * Created by yongwei on 16/8/26.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments = new Fragment[8];
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
                case 6:
                    fragments[position] = Gfragment.newInstance();
                    break;
                case 7:
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
        return 8;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
