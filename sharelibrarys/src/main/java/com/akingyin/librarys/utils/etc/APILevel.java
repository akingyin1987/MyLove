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

import android.os.Build;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 17:52
 * @ Version V1.0
 */
public class APILevel {

  /**
   * @param level minimum API level version that has to support the device
   * @return true when the caller API version is at least level
   */
  public static boolean require(int level) {
    return Build.VERSION.SDK_INT >= level;
  }

  /**
   * @return true when the caller API version is at least Cupcake 3
   */
  public static boolean requireCupcake() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE;
  }

  /**
   * @return true when the caller API version is at least Donut 4
   */
  public static boolean requireDonut() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT;
  }

  /**
   * @return true when the caller API version is at least Eclair 5
   */
  public static boolean requireEclair() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR;
  }

  /**
   * @return true when the caller API version is at least Froyo 8
   */
  public static boolean requireFroyo() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
  }

  /**
   * @return true when the caller API version is at least GingerBread 9
   */
  public static boolean requireGingerbread() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
  }

  /**
   * @return true when the caller API version is at least Honeycomb 11
   */
  public static boolean requireHoneycomb() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
  }

  /**
   * @return true when the caller API version is at least Honeycomb 3.2, 13
   */
  public static boolean requireHoneycombMR2() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
  }

  /**
   * @return true when the caller API version is at least ICS 14
   */
  public static boolean requireIceCreamSandwich() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
  }

  /**
   * @return true when the caller API version is at least JellyBean 16
   */
  public static boolean requireJellyBean() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
  }

  /**
   * @return true when the caller API version is at least JellyBean MR1 17
   */
  public static boolean requireJellyBeanMR1() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
  }

  /**
   * @return true when the caller API version is at least JellyBean MR2 18
   */
  public static boolean requireJellyBeanMR2() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
  }

  /**
   * @return true when the caller API version is at least Kitkat 19
   */
  public static boolean requireKitkat() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
  }

  /**
   * @return true when the caller API version is at least Lollipop 21
   */
  public static boolean requireLollipop() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
  }

  /**
   * @return true when the caller API version is at least Lollipop MR1 22
   */
  public static boolean requireLollipopMR1() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1;
  }

  /**
   * @return true when the caller API version is at least Marshmallow 23
   */
  public static boolean requireMarshmallow() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
  }

  /**
   * @param level API level version that specific method or variable has been deprecated
   * @return true when the caller API version is less than level
   */
  public static boolean deprecatedAt(int level) {
    return Build.VERSION.SDK_INT < level;
  }

  /**
   * @return true when the caller API version is less than Cupcake 3
   */
  public static boolean deprecatedAtCupcake() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.CUPCAKE;
  }

  /**
   * @return true when the caller API version is less than Donut 4
   */
  public static boolean deprecatedAtDonut() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.DONUT;
  }

  /**
   * @return true when the caller API version is less than Eclair 5
   */
  public static boolean deprecatedAtEclair() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.ECLAIR;
  }

  /**
   * @return true when the caller API version is less than Froyo 8
   */
  public static boolean deprecatedAtFroyo() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO;
  }

  /**
   * @return true when the caller API version is less than GingerBread 9
   */
  public static boolean deprecatedAtGingerbread() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD;
  }

  /**
   * @return true when the caller API version is less than Honeycomb 11
   */
  public static boolean deprecatedAtHoneycomb() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB;
  }

  /**
   * @return true when the caller API version is less than Honeycomb 3.2, 13
   */
  public static boolean deprecatedAtHoneycombMR2() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB_MR2;
  }

  /**
   * @return true when the caller API version is less than ICS 14
   */
  public static boolean deprecatedAtIceCreamSandwich() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH;
  }

  /**
   * @return true when the caller API version is less than JellyBean 16
   */
  public static boolean deprecatedAtJellyBean() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN;
  }

  /**
   * @return true when the caller API version is less than JellyBean MR1 17
   */
  public static boolean deprecatedAtJellyBeanMR1() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1;
  }

  /**
   * @return true when the caller API version is less than JellyBean MR2 18
   */
  public static boolean deprecatedAtJellyBeanMR2() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2;
  }

  /**
   * @return true when the caller API version is less than Kitkat 19
   */
  public static boolean deprecatedAtKitkat() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT;
  }

  /**
   * @return true when the caller API version is less than Lollipop 21
   */
  public static boolean deprecatedAtLollipop() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP;
  }

  /**
   * @return true when the caller API version is less than Lollipop MR1 22
   */
  public static boolean deprecatedAtLollipopMR1() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP_MR1;
  }

  /**
   * @return true when the caller API version is less than Marshmallow 23
   */
  public static boolean deprecatedAtMarshmallow() {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
  }
}
