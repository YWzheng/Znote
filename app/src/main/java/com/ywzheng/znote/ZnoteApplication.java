package com.ywzheng.znote;

import android.app.Application;
import android.support.annotation.NonNull;

/**
 * Created by yongwei on 2016/8/25.
 */

public class ZnoteApplication extends Application {

    private static ZnoteApplication sInstance;

    @NonNull
    public static ZnoteApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;



    }
}
