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

import com.akingyin.mylove.R;
import com.stephentuso.welcome.WelcomeScreenBuilder;
import com.stephentuso.welcome.ui.WelcomeActivity;
import com.stephentuso.welcome.util.WelcomeScreenConfiguration;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/24 10:33
 * @ Version V1.0
 */
public class MyWelcomeActivity  extends WelcomeActivity {


  @Override
  protected WelcomeScreenConfiguration configuration() {
    return new WelcomeScreenBuilder(this)
        .theme(R.style.CustomWelcomeScreenTheme)
        .defaultTitleTypefacePath("Montserrat-Bold.ttf")
        .defaultHeaderTypefacePath("Montserrat-Bold.ttf")
        .titlePage(R.drawable.photo, "Welcome", R.color.orange_background)
        .basicPage(R.drawable.photo, "Simple to use", "Add a welcome screen to your app with only a few lines of code.", R.color.red_background)
        .parallaxPage(R.layout.parallax_example, "Easy parallax", "Supply a layout and parallax effects will automatically be applied", R.color.purple_background, 0.2f, 2f)
        .basicPage(R.drawable.photo, "Customizable", "All elements of the welcome screen can be customized easily.", R.color.blue_background)

        .swipeToDismiss(true)
        .exitAnimation(android.R.anim.fade_out)
        .build();
  }

  public static String welcomeKey() {
    return "WelcomeScreen";
  }
}
