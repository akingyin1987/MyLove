package com.akingyin.mylove;

import android.app.Application;

import com.akingyin.librarys.KissTools;
import com.akingyin.librarys.utils.preferences.PreferencesUtil;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/19 15:12
 * @ Version V1.0
 */
public class MyLoveApp  extends Application {

  @Override public void onCreate() {
    super.onCreate();
    LeakCanary.install(this);
    KissTools.setContext(this);
    PreferencesUtil.setDefaultName("love_info");
    CrashReport.initCrashReport(this);
    CrashReport.setUserId(System.currentTimeMillis()+"test");

  }

  @Override public void onTerminate() {
    super.onTerminate();
  }
}
