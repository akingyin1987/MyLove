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
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * @ Description:
 * 主要是保存上下文,方便其它工具使用
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 18:08
 * @ Version V1.0
 */

public class Base {

  private static Context context;

  public static void initialize(@NonNull Context context) {
    Base.context = context;
  }

  public static Context getContext() {
    synchronized (Base.class) {
      if (Base.context == null)
        throw new NullPointerException("Call Base.initialize(context) within your Application onCreate() method.");

      return Base.context.getApplicationContext();
    }
  }

  public static Resources getResources() {
    return Base.getContext().getResources();
  }

  public static Resources.Theme getTheme() {
    return Base.getContext().getTheme();
  }

  public static AssetManager getAssets() {
    return Base.getContext().getAssets();
  }

  public static Configuration getConfiguration() {
    return Base.getResources().getConfiguration();
  }

  public static DisplayMetrics getDisplayMetrics() {
    return Base.getResources().getDisplayMetrics();
  }
}
