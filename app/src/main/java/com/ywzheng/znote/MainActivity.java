package com.ywzheng.znote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * The project was established in 2016 on August 9,
 * mainly to collect all kinds of UI effect and code
 * <p>
 * 2016-8-9
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,FragmentA.newInstance())
                    .commit();

        }
    }

}
