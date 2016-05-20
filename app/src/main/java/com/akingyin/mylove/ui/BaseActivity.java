package com.akingyin.mylove.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.ButterKnife;
import com.akingyin.librarys.base.BaseAppCompatActivity;
import com.akingyin.mylove.R;
import com.akingyin.mylove.base.AppManager;
import com.akingyin.mylove.base.SharedPreferenceHelp;
import com.akingyin.mylove.ui.view.BaseView;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/19 15:32
 * @ Version V1.0
 */
public  abstract class BaseActivity extends BaseAppCompatActivity implements BaseView{

  public SharedPreferenceHelp   sharedPreferenceHelp;

  protected Toolbar mToolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (isApplyKitKatTranslucency()) {
      setSystemBarTintDrawable(getResources().getDrawable(R.drawable.sr_primary));
    }
    sharedPreferenceHelp = new SharedPreferenceHelp(this);
    AppManager.getAppManager().addActivity(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    AppManager.getAppManager().finishActivity(this);
  }
  @Override
  public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    mToolbar = ButterKnife.findById(this, R.id.common_toolbar);
    if (null != mToolbar) {
      setSupportActionBar(mToolbar);
    }
    if(null != getSupportActionBar()){
      getSupportActionBar().setHomeButtonEnabled(true);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }
  protected abstract boolean isApplyKitKatTranslucency();

  @Override
  public void showError(String msg) {
    toggleShowError(true, msg, null);
  }

  @Override
  public void showException(String msg) {
    toggleShowError(true, msg, null);
  }

  @Override
  public void showNetError() {
    toggleNetworkError(true, null);
  }

  @Override
  public void showLoading(String msg) {
    toggleShowLoading(true, null);
  }

  @Override
  public void hideLoading() {
    toggleShowLoading(false, null);
  }
}
