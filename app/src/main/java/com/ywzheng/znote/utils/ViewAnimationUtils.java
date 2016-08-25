package com.ywzheng.znote.utils;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

/**
 * Created by yongwei on 2016/8/24.
 */

public class ViewAnimationUtils {

    public static final Property<FrameLayout, Integer> FOREGROUND_COLOR =
            new Property<FrameLayout, Integer>(Integer.class, "foregroundColor") {

                @Override
                public void set(FrameLayout layout, Integer value) {
                    if (layout.getForeground() instanceof ColorDrawable) {
                        ((ColorDrawable) layout.getForeground().mutate()).setColor(value);
                    } else {
                        layout.setForeground(new ColorDrawable(value));
                    }
                }

                @Override
                public Integer get(FrameLayout layout) {
                    if (layout.getForeground() instanceof ColorDrawable) {
                        return ((ColorDrawable) layout.getForeground()).getColor();
                    } else {
                        return Color.TRANSPARENT;
                    }
                }
            };
    /**
     * Get the center of a given view.
     *
     * @param view The view to get coordinates from.
     * @return The center of the given view.
     */
    public static Point getCenterForView(@NonNull View view) {
        final int centerX = (view.getLeft() + view.getRight()) / 2;
        final int centerY = (view.getTop() + view.getBottom()) / 2;
        return new Point(centerX, centerY);
    }

    /**
     * Create a simple circular reveal for a given view id within a root view.
     * This reveal will start from the start view's boundaries until it fills the root layout_view_14.
     *
     * @param rootView     The layout_view_14's root.
     * @param startViewId  The id of the view to use as animation source.
     * @param interpolator The interpolator to use.
     * @return The created circular reveal.
     */
    @NonNull
    public static Animator createCircularReveal(@NonNull View rootView, @IdRes int startViewId,
                                                @NonNull Interpolator interpolator) {
        final View startView = rootView.findViewById(startViewId);
        return createCircularReveal(startView, rootView, interpolator);
    }

    /**
     * Create a simple circular reveal from a given start view to it's target view.
     * This reveal will start from the start view's boundaries until it fills the target view.
     *
     * @param startView    The view to start the reveal from.
     * @param targetView   The target view which will be displayed once the reveal is done.
     * @param interpolator The interpolator to use.
     * @return The created circular reveal.
     */
    @NonNull
    public static Animator createCircularReveal(@NonNull View startView, @NonNull View targetView,
                                                @NonNull Interpolator interpolator) {
        Point center = getCenterForView(startView);
        return createCircularReveal(center, startView.getWidth(), targetView, interpolator);
    }

    /**
     * Create a simple circular reveal from a given start view to it's target view.
     * This reveal will start from the start view's boundaries until it fills the target view.
     *
     * @param center       The center x and y coordinates of the start circle.
     * @param width        The initial width of the view's coordinates.
     * @param targetView   The target view which will be displayed once the reveal is done.
     * @param interpolator The interpolator to use.
     * @return The created circular reveal.
     */
    @NonNull
    public static Animator createCircularReveal(@NonNull Point center, int width,
                                                @NonNull View targetView,
                                                @NonNull Interpolator interpolator) {
        final Animator circularReveal = android.view.ViewAnimationUtils.createCircularReveal(targetView,
                center.x, center.y, width, (float) Math.hypot(center.x, center.y));
        circularReveal.setInterpolator(interpolator);
        return circularReveal;
    }


    /**
     * Create a color change animation over a foreground property of a {@link FrameLayout}.
     *
     * @param target The target view.
     * @param startColorRes The color to start from.
     * @param targetColorRes The color this animation will end with.
     * @param interpolator The interpolator to use.
     * @return The color change animation.
     */
    @NonNull
    public static ObjectAnimator createColorChange(@NonNull FrameLayout target,
                                                   @ColorRes int startColorRes,
                                                   @ColorRes int targetColorRes,
                                                   @NonNull Interpolator interpolator) {
        Context context = target.getContext();
        final int startColor = ContextCompat.getColor(context, startColorRes);
        final int targetColor = ContextCompat.getColor(context, targetColorRes);
        ObjectAnimator colorChange = ObjectAnimator.ofInt(target,
                ViewAnimationUtils.FOREGROUND_COLOR, startColor, targetColor);
        colorChange.setEvaluator(new ArgbEvaluator());
        colorChange.setInterpolator(interpolator);
        colorChange.setDuration(context.getResources()
                .getInteger(android.R.integer.config_longAnimTime));
        return colorChange;
    }
}
