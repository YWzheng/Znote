package com.ywzheng.crash;

import android.app.Application;

/**
 * Created by yongwei on 2016/8/31.
 */

public class App extends Application {

    protected boolean isNeedCaughtExeption = true;// 是否捕获未知异常

    @Override
    public void onCreate() {
        super.onCreate();

        if (isNeedCaughtExeption) {

            initA();

            initB();
        }
    }

    //方案一
    private void initA() {
        CrashHandler1 crashHandler = CrashHandler1.getInstance();
        crashHandler.init(getApplicationContext());
    }

    //方案二
    private void initB() {
        CrashHandler2.init(getApplicationContext());
    }
}
