/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys;

import android.content.Context;

import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

/**
 * 保存context 上下文
 * Created by Administrator on 2016/5/25.
 */

public class KissTools {
    public static final String TAG = "KissTools";
    private static WeakReference<Context> contextRef;

    public static void setContext(Context context) {
        if (context == null) {
            throw new InvalidParameterException("Invalid context parameter!");
        }

        Context appContext = context.getApplicationContext();
        contextRef = new WeakReference<Context>(appContext);
    }

    public static Context getApplicationContext() {
        Context context = contextRef.get();
        if (context == null) {
            throw new InvalidParameterException("Context parameter not set!");
        } else {
            return context;
        }
    }

}
