package com.akingyin.mylove.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.akingyin.mylove.base.AppManager;
import com.akingyin.mylove.base.SharedPreferenceHelp;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/19 15:32
 * @ Version V1.0
 */
public  abstract class BaseActivity extends AppCompatActivity{

  public SharedPreferenceHelp   sharedPreferenceHelp;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    sharedPreferenceHelp = new SharedPreferenceHelp(this);
    AppManager.getAppManager().addActivity(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    AppManager.getAppManager().finishActivity(this);
  }
}
