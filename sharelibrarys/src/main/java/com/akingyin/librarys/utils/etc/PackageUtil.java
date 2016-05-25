/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.utils.etc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.akingyin.librarys.Base;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 18:07
 * @ Version V1.0
 */
public class PackageUtil {
  public static final String FACEBOOK = "com.facebook.katana";
  public static final String TWITTER = "com.twitter.android";
  public static final String GOOGLE_PLUS = "com.google.android.apps.plus";
  public static final String GMAIL = "com.google.android.gm";
  public static final String PINTEREST = "com.pinterest";
  public static final String TUMBLR = "com.tumblr";
  public static final String FANCY = "com.thefancy.app";
  public static final String FLIPBOARD = "flipboard.app";
  public static final String KAKAOTALK = "com.kakao.talk";
  public static final String KAKAOSTORY = "com.kakao.story";

  /**
   * 通过包名判断当前APK是否安装
   * @param packageName
   * @return
   */
  public static boolean isInstalled(String packageName) {
    PackageManager packageManager = Base.getContext().getPackageManager();
    try {
      packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
      return true;
    } catch (PackageManager.NameNotFoundException e) {
      return false;
    }
  }

  public static String getPackageName() {
    return Base.getContext().getPackageName();
  }

  public static void openPlayStore() {
    String packageName = Base.getContext().getPackageName();
    openPlayStore(packageName);
  }

  public static void openPlayStore(String packageName) {
    try {
      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      Base.getContext().startActivity(intent);
    } catch (ActivityNotFoundException exception) {
      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + packageName));
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      Base.getContext().startActivity(intent);
    }
  }

}
