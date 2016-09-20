package com.ywzheng.znote;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by yongwei on 2016/9/20.
 */

public class AnimationHelper {

    private void iconIn(View view, final Context context) {
        Animation anim = AnimationUtils.loadAnimation(context,
                R.anim.anim_launch_item_fade_in);
        anim.setStartOffset(560);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(anim);
    }
}
