package com.ywzheng.znote.ui.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.ywzheng.znote.R;
import com.ywzheng.znote.utils.ViewAnimationUtils;

/**
 * Created by yongwei on 2016/8/24.
 * create a circular reveal
 * From:https://github.com/googlesamples/android-OurStreets
 */
public class RevealFragment extends Fragment {
    public static final String TAG = "RevealFragment";
    private View mEmptyView;
    private View mMainContent;
    private static final FastOutLinearInInterpolator INTERPOLATOR =
            new FastOutLinearInInterpolator();
    private View mInflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflate = inflater.inflate(R.layout.fragment_circular_reveal, container, false);
        return mInflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //some of code such as view.findViewById()
        ViewCompat.requestApplyInsets(view);
        mEmptyView = view.findViewById(R.id.progress);
        mMainContent = view.findViewById(R.id.content);
        mMainContent.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // http://stackoverflow.com/questions/26475147/error-while-trying-to-create-circular-reveal-illegalstateexception-cannot-star
                animateProgressToContent();
            }
        }, 2000);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public static RevealFragment newInstance() {
        return new RevealFragment();
    }

    public RevealFragment() {
        setExitTransition(new Slide());
    }

    /**
     * Add animation safety by making sure that the fragment currently is attached.
     */
    private void safelyAnimateProgressToContent() {
        if (mMainContent.isAttachedToWindow()) {
            animateProgressToContent();
        } else {
            mMainContent.addOnAttachStateChangeListener(new View
                    .OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    v.removeOnAttachStateChangeListener(this);
                    animateProgressToContent();
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    v.removeOnAttachStateChangeListener(this);
                }
            });
        }
    }

    /**
     * Perform the animation from loading progress to the actual fragment's content.
     */
    private void animateProgressToContent() {
        AnimatorSet animatorSet = new AnimatorSet();
        FrameLayout targetView = ((FrameLayout) mInflate);
        //noinspection ConstantConditions
        animatorSet.play(createCircularReveal(targetView)).with(createColorChange(targetView));
        animatorSet.start();
    }

    @NonNull
    private Animator createCircularReveal(@NonNull View targetView) {
        Animator circularReveal = ViewAnimationUtils.createCircularReveal(targetView,
                R.id.progress, INTERPOLATOR);
        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                swapEmptyWithContentView(true);
            }
        });
        return circularReveal;
    }

    @NonNull
    private ObjectAnimator createColorChange(@NonNull FrameLayout targetView) {
        return ViewAnimationUtils.createColorChange(targetView,
                android.R.color.darker_gray, android.R.color.transparent, INTERPOLATOR);
    }

    /**
     * Replace the empty view with the gallery view.
     *
     * @param animate <code>true</code> if the swap should be animated, else <code>false</code>.
     */
    private void swapEmptyWithContentView(boolean animate) {
        if (animate) {
            mEmptyView.animate()
                    .alpha(0f)
                    .setInterpolator(INTERPOLATOR)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            mEmptyView.setVisibility(View.GONE);
                        }
                    });
            mMainContent.setAlpha(0f);
            mMainContent.setVisibility(View.VISIBLE);
            mMainContent.animate()
                    .alpha(1f)
                    .setInterpolator(INTERPOLATOR)
                    .start();
        } else {
            mEmptyView.setVisibility(View.GONE);
            mMainContent.setVisibility(View.VISIBLE);
        }
    }
}
