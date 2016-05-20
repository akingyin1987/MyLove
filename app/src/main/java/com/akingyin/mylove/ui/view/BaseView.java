/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.ui.view;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/20 17:27
 * @ Version V1.0
 */
public interface BaseView {

  /**
   * show loading message
   *
   * @param msg
   */
  void showLoading(String msg);

  /**
   * hide loading
   */
  void hideLoading();

  /**
   * show error message
   */
  void showError(String msg);

  /**
   * show exception message
   */
  void showException(String msg);

  /**
   * show net error
   */
  void showNetError();

}
