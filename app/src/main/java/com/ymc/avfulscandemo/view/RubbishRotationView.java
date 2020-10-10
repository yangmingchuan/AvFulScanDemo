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
import com.ymc.avfulscandemo.utils.C4030ab;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description 病毒清理 合并布局
 */
public class RubbishRotationView extends RelativeLayout {

    /* renamed from: a */
    private Context f18867a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f18868b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RotationCircleView f18869c;

    /* renamed from: d */
    private TextView f18870d;

    /* renamed from: e */
    private Handler f18871e = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f18872f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ObjectAnimator f18873g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ObjectAnimator f18874h;

    public RubbishRotationView(Context context) {
        super(context);
        m22525a(context);
    }

    public RubbishRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22525a(context);
    }

    public RubbishRotationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22525a(context);
    }

    /* renamed from: a */
    private void m22525a(Context context) {
        this.f18867a = context;
        View.inflate(this.f18867a, R.layout.layout_rubbish_rotation_view, this);
        initView();
    }

    /* renamed from: d */
    private void initView() {
        this.f18868b = findViewById(R.id.rotation_iv);
        this.f18869c = findViewById(R.id.rotation_rcl);
        this.f18870d = findViewById(R.id.rotation_tv);
    }

    /* renamed from: a */
    public void setRes(int i, int i2, String str) {
        this.f18868b.setImageResource(i);
        this.f18869c.setImageResource(i2);
        this.f18870d.setText(str);
        this.f18870d.setTextColor(-1);
    }

    /* renamed from: a */
    public void mo21094a() {
        this.f18871e.post(new Runnable() {
            public void run() {
                if (!RubbishRotationView.this.f18872f) {
                    if (RubbishRotationView.this.f18873g == null) {
                        RubbishRotationView rubbishRotationView = RubbishRotationView.this;
                        ObjectAnimator unused = rubbishRotationView.f18873g = C4030ab.m22806a(rubbishRotationView.f18869c, "alpha", 1.0f, 0.0f);
                        RubbishRotationView.this.f18873g.setDuration(700);
                        RubbishRotationView rubbishRotationView2 = RubbishRotationView.this;
                        ObjectAnimator unused2 = rubbishRotationView2.f18874h = C4030ab.m22806a(rubbishRotationView2.f18868b, "alpha", 0.0f, 1.0f);
                        RubbishRotationView.this.f18874h.setDuration(800);
                    }
                    boolean unused3 = RubbishRotationView.this.f18872f = true;
                    RubbishRotationView.this.f18873g.start();
                    RubbishRotationView.this.f18874h.start();
                }
            }
        });
    }

    /* renamed from: b */
    public void start() {
        RotationCircleView rotationCircleView = this.f18869c;
        if (rotationCircleView != null) {
            rotationCircleView.start();
        }
    }

    /* renamed from: c */
    public void mo21097c() {
        this.f18871e.removeCallbacksAndMessages((Object) null);
        ObjectAnimator objectAnimator = this.f18873g;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f18873g.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f18874h;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f18874h.cancel();
        }
    }

    public long getRemainingTime() {
        if (!this.f18872f) {
            return 800;
        }
        ObjectAnimator objectAnimator = this.f18874h;
        long duration = (objectAnimator == null || !objectAnimator.isRunning()) ? 0 : this.f18874h.getDuration() - this.f18874h.getCurrentPlayTime();
        if (duration < 0) {
            return 0;
        }
        if (duration > 800) {
            return 800;
        }
        return duration;
    }
}
