/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.presenter.impl;

import com.akingyin.mylove.presenter.ISplashPresenter;
import com.akingyin.mylove.view.SplashView;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 17:41
 * @ Version V1.0
 */
public class SplashPresenterImpl   implements ISplashPresenter {

  private    SplashView   view;

  @Override
  public void attachView(SplashView view) {
    this.view = view;
  }

  @Override
  public void detachView() {

  }

  @Override
  public void initialized() {

  }

  @Override public void onPause() {

  }

  @Override public void onResume() {

  }
}
