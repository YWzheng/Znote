package com.ywzheng.crash;

import android.annotation.SuppressLint;
import android.os.Environment;
import android.os.Process;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异常捕获
 * Created by hzwangchenyan on 2016/1/25.
 */
@SuppressLint("SimpleDateFormat")
public class CrashHandler3 implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public static CrashHandler3 getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static CrashHandler3 instance = new CrashHandler3();
    }

    public void init() {
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if (BuildConfig.DEBUG) {
            mDefaultHandler.uncaughtException(thread, ex);
        } else {
            saveCrashInfo(ex);
            Process.killProcess(Process.myPid());
        }
    }

    private void saveCrashInfo(Throwable ex) {
        StringBuilder sb = new StringBuilder();
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        sb.append(writer.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());
        String fileName = String.format("log_%s.txt", time);
        try {
            FileOutputStream fos = new FileOutputStream(getLogDir() + fileName);
            fos.write(sb.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getLogDir() {
        String dir = getAppDir() + "Log/";
        return mkdirs(dir);
    }
    private static String getAppDir() {
        return Environment.getExternalStorageDirectory() + "/PonyMusic/";
    }
    private static String mkdirs(String dir) {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }
}
