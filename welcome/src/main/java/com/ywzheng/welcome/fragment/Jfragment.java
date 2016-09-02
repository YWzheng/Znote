package com.ywzheng.welcome.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywzheng.welcome.BuildConfig;
import com.ywzheng.welcome.R;
import com.ywzheng.welcome.widget.twitter.ContentView;
import com.ywzheng.welcome.widget.twitter.MainView;
import com.ywzheng.welcome.widget.twitter.SplashView;

import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by yongwei on 2016/8/31.
 */

public class Jfragment extends Fragment {

    private static Jfragment jfragment;
    private static final boolean DO_XML = false;

    private MainView mMainView;
    private SplashView mSplashView;
    private Handler mHandler = new Handler();
    private ContentView mContentView;

    public static Jfragment newInstance() {
        if (jfragment != null) {
            return jfragment;
        }
        synchronized (Afragment.class) {
            if (jfragment == null) {
                return new Jfragment();
            }
        }
        return jfragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        // change the DO_XML variable to switch between code and xml
        if (DO_XML) {
            // inflate the view from XML and then get a reference to it
            view = inflater.inflate(R.layout.splash_view_j, container, false);
            return view;
        } else {
            // create the main view and it will handle the rest
            mMainView = new MainView(getActivity().getApplicationContext());
            mSplashView = ((MainView) mMainView).getSplashView();
            view = mMainView;
        }

        // pretend like we are loading data
        startLoadingData();
        return view;
    }

    private void startLoadingData() {
        // finish "loading data" in a random time between 1 and 3 seconds
        Random random = new Random();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadingDataEnded();
            }
        }, 1000 + random.nextInt(2000));
    }

    private void onLoadingDataEnded() {
        Context context = getActivity().getApplicationContext();
        // now that our data is loaded we can initialize the content view
        mContentView = new ContentView(context);
        // add the content view to the background
        mMainView.addView(mContentView, 0);

        // start the splash animation
        mSplashView.splashAndDisappear(new SplashView.ISplashListener() {
            @Override
            public void onStart() {
                // log the animation start event
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "splash started");
                }
            }

            @Override
            public void onUpdate(float completionFraction) {
                // log animation update events
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "splash at " + String.format("%.2f", (completionFraction * 100)) + "%");
                }
            }

            @Override
            public void onEnd() {
                // log the animation end event
                if (BuildConfig.DEBUG) {
                    Log.d(TAG, "splash ended");
                }
                // free the view so that it turns into garbage
                mSplashView = null;
                if (!DO_XML) {
                    // if inflating from code we will also have to free the reference in MainView as well
                    // otherwise we will leak the View, this could be done better but so far it will suffice
                    ((MainView) mMainView).unsetSplashView();
                }
            }
        });
    }
}
