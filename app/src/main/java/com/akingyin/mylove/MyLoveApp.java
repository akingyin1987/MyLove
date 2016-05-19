package com.akingyin.mylove;

import android.app.Application;
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
    CrashReport.UserStrategy  userStrategy = new CrashReport.UserStrategy(this);
    userStrategy.setAppChannel("900030944");
    CrashReport.initCrashReport(this, userStrategy);

  }

  @Override public void onTerminate() {
    super.onTerminate();
  }
}
