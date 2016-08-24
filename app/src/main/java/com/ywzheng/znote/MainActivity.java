package com.ywzheng.znote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_1, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
