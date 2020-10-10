package com.ymc.avfulscandemo.utils;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.util.Property;

/**
 * Created by ymc on 2020/10/10.
 *
 * @Description
 */
public class C4030ab {
    /* renamed from: a */
    public static ObjectAnimator m22805a(Object obj, Property property, float... fArr) {
        if (obj != null) {
            return ObjectAnimator.ofFloat(obj, property, fArr);
        }
        RuntimeException runtimeException = new RuntimeException();
        Log.i("LauncherAnimUtils", "[catch]", runtimeException);
        throw runtimeException;
    }

    /* renamed from: a */
    public static ObjectAnimator m22806a(Object obj, String str, float... fArr) {
        if (obj != null) {
            return ObjectAnimator.ofFloat(obj, str, fArr);
        }
        RuntimeException runtimeException = new RuntimeException();
        Log.i("LauncherAnimUtils", "[catch]", runtimeException);
        throw runtimeException;
    }
}
