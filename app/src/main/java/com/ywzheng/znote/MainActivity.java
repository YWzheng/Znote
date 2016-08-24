package com.ywzheng.znote;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

/**
 * The project was established in 2016 on August 9,
 * mainly to collect all kinds of UI effect and code
 * <p>
 * 2016-8-9
 */
public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // FIXME: This call is necessary when not calling setContentView.
        getDelegate().onPostCreate(null);
        findViewById(android.R.id.content)
                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            mFragmentManager.beginTransaction()
                    .replace(android.R.id.content, getFragment(), MainFragment.TAG)
                    .commit();
        }


    }

    private Fragment getFragment() {
        MainFragment fragment = (MainFragment) mFragmentManager
                .findFragmentByTag(MainFragment.TAG);
        if (fragment == null) {
            fragment = MainFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
