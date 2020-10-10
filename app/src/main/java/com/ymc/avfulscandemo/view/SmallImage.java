package com.ymc.avfulscandemo.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description
 */
public class SmallImage extends AppCompatImageView {
    public SmallImage(Context context) {
        super(context);
        setImg(context);
    }

    /* renamed from: a */
    private void setImg(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
        layoutParams.addRule(13);
        setLayoutParams(layoutParams);
        setScaleType(ImageView.ScaleType.FIT_XY);
        setVisibility(View.INVISIBLE);
    }
}
