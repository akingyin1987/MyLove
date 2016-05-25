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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.akingyin.librarys.utils.preferences.PreferencesUtil;
import com.akingyin.mylove.R;
import com.akingyin.mylove.presenter.ISplashPresenter;
import com.akingyin.mylove.presenter.impl.SplashPresenterImpl;
import com.akingyin.mylove.view.SplashView;
import com.stephentuso.welcome.WelcomeScreenHelper;
import com.stephentuso.welcome.ui.WelcomeActivity;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/24 10:32
 * @ Version V1.0
 */
public class LauncherUI extends AppCompatActivity implements SplashView{



  WelcomeScreenHelper welcomeScreen;

  private ISplashPresenter   presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    presenter = new SplashPresenterImpl();
    presenter.attachView(this);
    welcomeScreen = new WelcomeScreenHelper(this, MyWelcomeActivity.class);
    welcomeScreen.show(savedInstanceState);

    findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        welcomeScreen.forceShow();
      }
    });
  }


  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == WelcomeScreenHelper.DEFAULT_WELCOME_SCREEN_REQUEST) {
      String welcomeKey = data.getStringExtra(WelcomeActivity.WELCOME_SCREEN_KEY);

      if (resultCode == RESULT_OK) {
        Toast.makeText(getApplicationContext(), welcomeKey + " completed", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(getApplicationContext(), welcomeKey + " canceled", Toast.LENGTH_SHORT).show();
      }

    }

  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    welcomeScreen.onSaveInstanceState(outState);
  }

  @Override protected void onPause() {
    super.onPause();
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override
  public void animateBackgroundImage(Animation animation) {

  }

  @Override
  public void initializeViews(String versionName, String copyright, int backgroundResId) {

  }

  @Override
  public void navigateToHomePage() {

  }

  @Override
  public Context getContext() {
    return null;
  }
}
