/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.ui.activitys;

import android.os.Bundle;
import android.view.View;

import com.akingyin.librarys.netstatus.NetUtils;
import com.akingyin.mylove.R;
import com.akingyin.mylove.ui.BaseActivity;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/25 12:03
 * @ Version V1.0
 */
public class HomeActivity   extends BaseActivity {

  @Override
  protected boolean isApplyKitKatTranslucency() {
    return true;
  }

  @Override protected void getBundleExtras(Bundle extras) {

  }

  @Override
  protected int getContentViewLayoutID() {
    return R.layout.activity_home;
  }

  @Override
  protected View getLoadingTargetView() {
    return null;
  }

  @Override
  protected void initViewsAndEvents() {

  }

  @Override protected void onNetworkConnected(NetUtils.NetType type) {

  }

  @Override protected void onNetworkDisConnected() {

  }

  @Override protected boolean isApplyStatusBarTranslucency() {
    return true;
  }

  @Override protected boolean toggleOverridePendingTransition() {
    return true;
  }

  @Override protected TransitionMode getOverridePendingTransitionMode() {
    return TransitionMode.LEFT;
  }
}
