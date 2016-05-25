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

import android.os.Looper;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 18:17
 * @ Version V1.0
 */
public class ThreadUtil {

  /**
   * 判断当前线程是否是主线程（UI线程）
   * @return
   */
  public static boolean isMain() {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}
