package com.ymc.avfulscandemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

import com.ymc.avfulscandemo.R;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description 扫描view
 */
public class AntivirusFullScanBarView extends View {

    /* renamed from: a */
    private Bitmap f22444a;

    /* renamed from: b */
    private final Paint f22445b = new Paint();

    /* renamed from: c */
    private final Paint f22446c = new Paint();

    /* renamed from: d */
    private final Rect f22447d = new Rect();

    /* renamed from: e */
    private final Rect f22448e = new Rect();

    /* renamed from: f */
    private final Rect f22449f = new Rect();

    /* renamed from: g */
    private float f22450g = 1.0f;

    /* renamed from: h */
    private boolean f22451h;

    /* renamed from: i */
    private int f22452i = 1;

    /* renamed from: j */
    private C5073a f22453j;

    /* renamed from: k */
    private final Interpolator f22454k = new AccelerateDecelerateInterpolator();

    /* renamed from: com.cleanapp.av.ui.view.AntivirusFullScanBarView$a */
    /* compiled from: filemagic */
    public interface C5073a {
        /* renamed from: a */
        boolean mo23911a(AntivirusFullScanBarView antivirusFullScanBarView, int i);
    }

    public AntivirusFullScanBarView(Context context) {
        super(context);
        m27479a(context);
    }

    public AntivirusFullScanBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27479a(context);
    }

    public AntivirusFullScanBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m27479a(context);
    }

    /* renamed from: a */
    private void m27479a(Context context) {
        this.f22446c.setColor(getResources().getColor(R.color.color_av_full_scan_white_bg));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f22444a == null) {
            this.f22444a = BitmapFactory.decodeResource(getResources(), R.drawable.ic_antivirus_full_scan_bar);
        }
        boolean z = false;
        this.f22447d.set(0, 0, this.f22444a.getWidth(), this.f22444a.getHeight());
        int height = (int) (((float) (getHeight() - this.f22444a.getHeight())) * this.f22454k.getInterpolation(this.f22450g));
        this.f22448e.set(0, height, getWidth(), this.f22444a.getHeight() + height);
        canvas.drawBitmap(this.f22444a, this.f22447d, this.f22448e, this.f22445b);
        this.f22449f.set(0, height, getWidth(), getHeight());
        canvas.drawRect(this.f22449f, this.f22446c);
        if (this.f22451h) {
            float f = this.f22450g;
            if (f >= 1.0f) {
                this.f22452i = -1;
                C5073a aVar = this.f22453j;
                if (aVar != null) {
                    z = aVar.mo23911a(this, this.f22452i);
                }
            } else if (f <= 0.0f) {
                this.f22452i = 1;
                C5073a aVar2 = this.f22453j;
                if (aVar2 != null) {
                    z = aVar2.mo23911a(this, this.f22452i);
                }
            }
            this.f22450g += ((float) this.f22452i) * 0.0075f;
            if (!z) {
                invalidate();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m27480c();
    }

    /* renamed from: c */
    private void m27480c() {
        Bitmap bitmap = this.f22444a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f22444a = null;
        }
    }

    public void setCallback(C5073a aVar) {
        this.f22453j = aVar;
    }

    /* renamed from: a */
    public void start() {
        this.f22451h = true;
        invalidate();
    }

    /* renamed from: b */
    public void mo23907b() {
        this.f22451h = false;
        invalidate();
        m27480c();
    }
}
