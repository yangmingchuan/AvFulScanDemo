package com.ymc.avfulscandemo.view;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.ymc.avfulscandemo.R;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cleanapp.av.ui.view.SpreadView */
/* compiled from: filemagic */
public class SpreadView extends View {

    /* renamed from: a */
    private Paint f22466a;

    /* renamed from: b */
    private int f22467b;

    /* renamed from: c */
    private Paint f22468c;

    /* renamed from: d */
    private float f22469d;

    /* renamed from: e */
    private float f22470e;

    /* renamed from: f */
    private int f22471f;

    /* renamed from: g */
    private int f22472g;

    /* renamed from: h */
    private int f22473h;

    /* renamed from: i */
    private List<Integer> f22474i;

    /* renamed from: j */
    private List<Integer> f22475j;

    /* renamed from: k */
    private List<Integer> f22476k;

    /* renamed from: l */
    private int f22477l;

    /* renamed from: m */
    private int f22478m;

    public SpreadView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22467b = 100;
        this.f22471f = 5;
        this.f22472g = 80;
        this.f22473h = 33;
        this.f22474i = new ArrayList();
        this.f22475j = new ArrayList();
        this.f22476k = new ArrayList();
        this.f22477l = 40;
        int color = context.getResources().getColor(R.color.color_spread1);
        int color2 = context.getResources().getColor(R.color.color_spread1);
        this.f22466a = new Paint();
        this.f22466a.setColor(color);
        this.f22466a.setAntiAlias(true);
        this.f22466a.setStyle(Paint.Style.STROKE);
        this.f22466a.setStrokeWidth((float) this.f22477l);
        this.f22475j.add(255);
        this.f22474i.add(0);
        this.f22476k.add(Integer.valueOf(this.f22477l));
        this.f22468c = new Paint();
        this.f22468c.setAntiAlias(true);
        this.f22468c.setAlpha(255);
        this.f22468c.setColor(color2);
        this.f22468c.setStyle(Paint.Style.STROKE);
        this.f22468c.setStrokeWidth((float) this.f22477l);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f22469d = (float) (i / 2);
        this.f22470e = (float) (i2 / 2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= this.f22474i.size()) {
                break;
            }
            int intValue = this.f22475j.get(i).intValue();
            this.f22468c.setAlpha(intValue);
            int intValue2 = this.f22474i.get(i).intValue();
            int intValue3 = this.f22476k.get(i).intValue();
            this.f22468c.setStrokeWidth((float) intValue3);
            this.f22478m = this.f22467b + intValue2;
            canvas.drawCircle(this.f22469d, this.f22470e, (float) this.f22478m, this.f22468c);
            if (intValue > 0 && intValue2 < 300) {
                int i3 = this.f22471f;
                int i4 = intValue - i3 > 0 ? intValue - i3 : 0;
                int i5 = intValue3 - 1;
                if (i5 > 0) {
                    i2 = i5;
                }
                this.f22476k.set(i, Integer.valueOf(i2));
                this.f22475j.set(i, Integer.valueOf(i4));
                this.f22474i.set(i, Integer.valueOf(intValue2 + this.f22471f));
            }
            i++;
        }
        List<Integer> list = this.f22474i;
        if (list.get(list.size() - 1).intValue() > this.f22472g) {
            this.f22474i.add(0);
            this.f22475j.add(255);
            this.f22476k.add(Integer.valueOf(this.f22477l));
        }
        if (this.f22474i.size() >= 8) {
            this.f22475j.remove(0);
            this.f22474i.remove(0);
            this.f22476k.remove(0);
        }
        canvas.drawCircle(this.f22469d, this.f22470e, (float) this.f22467b, this.f22466a);
        postInvalidateDelayed((long) this.f22473h);
    }
}
