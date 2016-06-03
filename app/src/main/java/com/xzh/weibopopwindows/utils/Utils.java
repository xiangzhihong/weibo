package com.xzh.weibopopwindows.utils;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by xiangzhihong on 2015/12/3 on 18:13.
 */
public class Utils {
    public static void addGuideImage(@NonNull Activity context, @NonNull String sharedName, @DrawableRes @NonNull int guideFirst) {
        View view = context.getWindow().getDecorView();
        View viewParent = view.findViewById(android.R.id.content);
        if (view == null || !(viewParent instanceof FrameLayout) || !SharedUtil.newInstance(context).getBoolean(sharedName, true))return;
        final FrameLayout frameLayout = (FrameLayout) viewParent;
        final ImageView guideImage = new ImageView(view.getContext());
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        guideImage.setLayoutParams(params);
        guideImage.setScaleType(ImageView.ScaleType.FIT_XY);
        guideImage.setImageResource(guideFirst);
        guideImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLayout.removeView(guideImage);
            }
        });
        frameLayout.addView(guideImage);
        SharedUtil.newInstance(context).set(sharedName, false);
    }
}
