/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.akingyin.mylove;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/19 15:45
 * @ Version V1.0
 */

@Module
public class AppModule {

  private Application application;

  public AppModule(Application application){
    this.application=application;
  }

  @Provides
  @Singleton
  public Application provideApplication(){
    return application;
  }
}
