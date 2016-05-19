/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.ui;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.akingyin.mylove.R;
import com.akingyin.mylove.ui.animators.ChatAvatarsAnimator;
import com.akingyin.mylove.ui.animators.InSyncAnimator;
import com.akingyin.mylove.ui.animators.RocketAvatarsAnimator;
import com.akingyin.mylove.ui.animators.RocketFlightAwayAnimator;
import com.redbooth.WelcomeCoordinatorLayout;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/19 15:58
 * @ Version V1.0
 */
public class WelcomeActivity extends BaseActivity {

  @BindView(R.id.coordinator) WelcomeCoordinatorLayout coordinatorLayout;
  @BindView(R.id.skip) Button skip;
  private ValueAnimator backgroundAnimator;
  private boolean animationReady = false;

  private RocketAvatarsAnimator rocketAvatarsAnimator;
  private ChatAvatarsAnimator chatAvatarsAnimator;
  private RocketFlightAwayAnimator rocketFlightAwayAnimator;
  private InSyncAnimator inSyncAnimator;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_welcome);
    ButterKnife.bind(this);
    initializeListeners();
    initializePages();
    initializeBackgroundTransitions();
  }


  private void initializePages() {
    final WelcomeCoordinatorLayout coordinatorLayout
        = (WelcomeCoordinatorLayout)findViewById(R.id.coordinator);
    coordinatorLayout.addPage(R.layout.welcome_page_1,
        R.layout.welcome_page_2,
        R.layout.welcome_page_3,
        R.layout.welcome_page_4);
  }

  private void initializeListeners() {
    coordinatorLayout.setOnPageScrollListener(new WelcomeCoordinatorLayout.OnPageScrollListener() {
      @Override
      public void onScrollPage(View v, float progress, float maximum) {
        if (!animationReady) {
          animationReady = true;
          backgroundAnimator.setDuration((long) maximum);
        }
        backgroundAnimator.setCurrentPlayTime((long) progress);
      }

      @Override
      public void onPageSelected(View v, int pageSelected) {
        switch (pageSelected) {
          case 0:
            if (rocketAvatarsAnimator == null) {
              rocketAvatarsAnimator = new RocketAvatarsAnimator(coordinatorLayout);
              rocketAvatarsAnimator.play();
            }
            break;
          case 1:
            if (chatAvatarsAnimator == null) {
              chatAvatarsAnimator = new ChatAvatarsAnimator(coordinatorLayout);
              chatAvatarsAnimator.play();
            }
            break;
          case 2:
            if (inSyncAnimator == null) {
              inSyncAnimator = new InSyncAnimator(coordinatorLayout);
              inSyncAnimator.play();
            }
            break;
          case 3:
            if (rocketFlightAwayAnimator == null) {
              rocketFlightAwayAnimator = new RocketFlightAwayAnimator(coordinatorLayout);
              rocketFlightAwayAnimator.play();
            }
            break;
        }
      }
    });
  }

  private void initializeBackgroundTransitions() {
    final Resources resources = getResources();
    final int colorPage1 = ResourcesCompat.getColor(resources, R.color.page1, getTheme());
    final int colorPage2 = ResourcesCompat.getColor(resources, R.color.page2, getTheme());
    final int colorPage3 = ResourcesCompat.getColor(resources, R.color.page3, getTheme());
    final int colorPage4 = ResourcesCompat.getColor(resources, R.color.page4, getTheme());
    backgroundAnimator = ValueAnimator
        .ofObject(new ArgbEvaluator(), colorPage1, colorPage2, colorPage3, colorPage4);
    backgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override
      public void onAnimationUpdate(ValueAnimator animation) {
        coordinatorLayout.setBackgroundColor((int) animation.getAnimatedValue());
      }
    });
  }

  @OnClick(R.id.skip)
  void skip() {
    coordinatorLayout.setCurrentPage(coordinatorLayout.getNumOfPages() - 1, true);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }
}
