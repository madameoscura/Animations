package com.example.animations.logic;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.animations.R;
import com.example.animations.gui.SecondActivity;

public class SecondActivityListener implements View.OnClickListener {

    SecondActivity secondActivity;

    public SecondActivityListener(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnBounceBall) {
            secondActivity.imageBounceBall.clearAnimation();
            secondActivity.imageBounceBall.startAnimation(bounceBall(secondActivity.imageBounceBall));

        }
    }

    private TranslateAnimation bounceBall(final ImageView imageBounceBall) {
        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0, getDisplayHeight() / 2);
        transAnim.setStartOffset(500);
        transAnim.setDuration(3000);
     //   transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageBounceBall.clearAnimation();
                final int left = imageBounceBall.getLeft();
                final int top = imageBounceBall.getTop();
                final int bottom = imageBounceBall.getBottom();
                final int right = imageBounceBall.getRight();
                imageBounceBall.layout(left, top, right, bottom);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        return transAnim;
    }

    private int getDisplayHeight() {
        return secondActivity.getResources().getDisplayMetrics().heightPixels;
    }
}
