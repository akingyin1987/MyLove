/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.utils;

import android.text.TextUtils;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/5/25.
 */

public class NumberUtil {

    public static double multiply(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        double result = bd1.multiply(bd2).doubleValue();
        return result;
    }

    public static int parse(String text, int dv) {
        if (TextUtils.isEmpty(text)) {
            return dv;
        }

        text = text.trim();
        int value = dv;
        try {
            value = Integer.parseInt(text);
        } catch (Exception ignore) {
        }
        return value;
    }

    public static double parse(String text, double dv) {
        if (TextUtils.isEmpty(text)) {
            return dv;
        }

        text = text.trim();
        double value = dv;
        try {
            value = Double.parseDouble(text);
        } catch (Exception ignore) {
        }
        return value;
    }

    public static float parse(String text, float dv) {
        if (TextUtils.isEmpty(text)) {
            return dv;
        }

        text = text.trim();
        float value = dv;
        try {
            value = Float.parseFloat(text);
        } catch (Exception ignore) {
        }
        return value;
    }
}
