package com.ymc.avfulscandemo.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ymc.avfulscandemo.R;
import com.ymc.avfulscandemo.utils.AnimatorUtils;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description 病毒清理 组合布局
 */
public class RubbishRotationView extends RelativeLayout {

    private Context mContext;

    public ImageView IvRotation;

    public RotationCircleView circleView;

    private TextView tvTitle;

    private Handler mainHandler = new Handler(Looper.getMainLooper());

    public static boolean isStart;

    public static ObjectAnimator animatorDismiss;

    public static ObjectAnimator animatorShow;

    public RubbishRotationView(Context context) {
        super(context);
        init(context);
    }

    public RubbishRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public RubbishRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        View.inflate(mContext, R.layout.layout_rubbish_rotation_view, this);
        initView();
    }

    private void initView() {
        IvRotation = findViewById(R.id.rotation_iv);
        circleView = findViewById(R.id.rotation_rcl);
        tvTitle = findViewById(R.id.rotation_tv);
    }

    /**
     * 设置资源
     * @param i 外围UI
     * @param i2 圆形UI
     * @param str 文案提示
     */
    public void setRes(int i, int i2, String str) {
        IvRotation.setImageResource(i);
        circleView.setImageResource(i2);
        tvTitle.setText(str);
        tvTitle.setTextColor(-1);
    }

    public void mo21094a() {
        mainHandler.post(new Runnable() {
            public void run() {
                if (!RubbishRotationView.isStart) {
                    if (RubbishRotationView.animatorDismiss == null) {
                        RubbishRotationView rubbishRotationView = RubbishRotationView.this;
                        animatorDismiss = AnimatorUtils.m22806a(rubbishRotationView.circleView, "alpha", 1.0f, 0.0f);
                        RubbishRotationView.animatorDismiss.setDuration(700);
                        RubbishRotationView rubbishRotationView2 = RubbishRotationView.this;
                        animatorShow = AnimatorUtils.m22806a(rubbishRotationView2.IvRotation, "alpha", 0.0f, 1.0f);
                        RubbishRotationView.animatorShow.setDuration(800);
                    }
                    RubbishRotationView.isStart = true;
                    RubbishRotationView.animatorDismiss.start();
                    RubbishRotationView.animatorShow.start();
                }
            }
        });
    }

    public void start() {
        RotationCircleView rotationCircleView = circleView;
        if (rotationCircleView != null) {
            rotationCircleView.start();
        }
    }

    /* renamed from: c */
    public void mo21097c() {
        mainHandler.removeCallbacksAndMessages((Object) null);
        ObjectAnimator objectAnimator = animatorDismiss;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            animatorDismiss.cancel();
        }
        ObjectAnimator objectAnimator2 = animatorShow;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            animatorShow.cancel();
        }
    }

    public long getRemainingTime() {
        if (!isStart) {
            return 800;
        }
        ObjectAnimator objectAnimator = animatorShow;
        long duration = (objectAnimator == null || !objectAnimator.isRunning()) ? 0 : animatorShow.getDuration() - animatorShow.getCurrentPlayTime();
        if (duration < 0) {
            return 0;
        }
        if (duration > 800) {
            return 800;
        }
        return duration;
    }
}
