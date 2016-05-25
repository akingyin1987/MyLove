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

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 *  在以后的项目中要将HashMap 换成 SparseArray
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 18:11
 * @ Version V1.0
 */
public class SparseArrayUtil {

  /**
   * 将SparseArray转成ArrayList
   * @param sparseArray
   * @param <C>
   * @return
   */
  public static <C> List<C> asArrayList(SparseArray<C> sparseArray) {
    if (sparseArray == null)
      return new ArrayList<C>();

    ArrayList<C> arrayList = new ArrayList<C>(sparseArray.size());
    for (int i = 0; i < sparseArray.size(); i++)
      arrayList.add(sparseArray.valueAt(i));
    return arrayList;
  }
}
