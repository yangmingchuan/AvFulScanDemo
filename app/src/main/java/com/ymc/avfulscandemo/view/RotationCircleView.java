package com.ymc.avfulscandemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;

import com.ymc.avfulscandemo.R;
/**
 * Created by ymc on 2020/10/10.
 *
 * @Description 原型 旋转View
 */
public class RotationCircleView extends AppCompatImageView {

    /* renamed from: a */
    private Context f18831a;

    /* renamed from: b */
    private Paint f18832b;

    /* renamed from: c */
    private Paint f18833c;

    /* renamed from: d */
    private int f18834d;

    /* renamed from: e */
    private int f18835e;

    /* renamed from: f */
    private boolean f18836f;

    /* renamed from: g */
    private RectF f18837g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public float f18838h;

    /* renamed from: i */
    private boolean f18839i;

    /* renamed from: j */
    private ValueAnimator.AnimatorUpdateListener f18840j;

    /* renamed from: k */
    private ValueAnimator f18841k;

    /* renamed from: l */
    private float f18842l;

    /* renamed from: m */
    private float f18843m;

    public RotationCircleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RotationCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotationCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18836f = true;
        this.f18831a = context;
        m22510a(attributeSet);
    }

    /* renamed from: a */
    public void start() {
        if (this.f18841k == null) {
            this.f18840j = new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = RotationCircleView.this.f18838h = (float) ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    RotationCircleView.this.invalidate();
                }
            };
            this.f18841k = ValueAnimator.ofInt(new int[]{-90, 270}).setDuration(1500);
            this.f18841k.addUpdateListener(this.f18840j);
            this.f18841k.setRepeatCount(-1);
            this.f18841k.setInterpolator(new LinearInterpolator());
        }
        this.f18839i = true;
        this.f18841k.start();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f18841k;
        if (valueAnimator != null) {
            this.f18839i = false;
            valueAnimator.cancel();
        }
    }

    /* renamed from: a */
    private void m22510a(AttributeSet attributeSet) {
        this.f18842l = 2;
        this.f18843m = 1;
        setBackgroundColor(this.f18831a.getResources().getColor(R.color.color_spread));
        this.f18832b = new Paint(1);
        this.f18832b.setStyle(Paint.Style.STROKE);
        this.f18832b.setStrokeWidth(this.f18842l);
        this.f18832b.setColor(Color.parseColor("#00D1CC"));
        this.f18833c = new Paint(1);
        this.f18833c.setStyle(Paint.Style.STROKE);
        this.f18833c.setStrokeWidth(this.f18843m);
        this.f18833c.setColor(Color.parseColor("#246DEE"));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f18836f) {
            this.f18835e = getWidth();
            this.f18834d = getHeight();
            float f = this.f18842l;
            this.f18837g = new RectF(f, f, ((float) this.f18835e) - f, ((float) this.f18834d) - f);
            this.f18836f = false;
        }
        if (this.f18839i) {
            canvas.rotate(this.f18838h, (float) (this.f18835e / 2), (float) (this.f18834d / 2));
        }
        int i = this.f18835e;
        canvas.drawCircle((float) (i / 2), (float) (this.f18834d / 2), ((float) (i / 2)) - this.f18842l, this.f18833c);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f18837g, 0.0f, 45.0f, false, this.f18832b);
        canvas2.drawArc(this.f18837g, 180.0f, 45.0f, false, this.f18832b);
    }
}
