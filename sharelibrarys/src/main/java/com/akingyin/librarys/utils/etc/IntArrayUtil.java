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

import android.support.annotation.NonNull;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 17:53
 * @ Version V1.0
 */
public class IntArrayUtil {

  /**
   * 当前值是否在集合中
   * @param array
   * @param value
   * @return
   */
  public static boolean contains(int[] array, @NonNull int value) {
    if (array == null)
      return false;

    for (int i : array)
      if (i == value)
        return true;
    return false;
  }

  /**
   * 将一个指定数据与一个数组合并,返回一个新的数据
   * @param array
   * @param value
   * @return
   */
  public static int[] add(int[] array, @NonNull  int value) {
    if (array == null)
      return new int[]{value};

    int[] newArray = new int[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);
    newArray[array.length] = value;
    return newArray;
  }

  /**
   * 合并两个数组
   * @param array
   * @param value
   * @return
   */
  public static int[] add(int[] array, @NonNull int[]  value){
    if(null == array){
      return  value;
    }
    int[]  newArray = new int[array.length+value.length];
    System.arraycopy(array,0,newArray,0,array.length);
    System.arraycopy(value,0,newArray,array.length,value.length);

    return  newArray;
  }

}
