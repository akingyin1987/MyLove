
/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.base;

import java.util.Stack;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

/**
 * @ClassName: AppManager
 * @Description: TODO(应用程序Activity管理类：用于Activity管理和应用程序退出)
 * @author king
 * @since 2013-12-21 下午5:57:07
 * @version V1.0
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
	if (instance == null) {
	    instance = new AppManager();
	}
	return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
	if (activityStack == null) {
	    activityStack = new Stack<Activity>();
	}
	activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
	Activity activity = activityStack.lastElement();
	return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
	Activity activity = activityStack.lastElement();
	finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
	if (activity != null) {
	    activityStack.remove(activity);
	    activity.finish();
	    activity = null;
	}
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
	for (Activity activity : activityStack) {
	    if (activity.getClass().equals(cls)) {
		finishActivity(activity);
	    }
	}
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
	for (int i = 0, size = activityStack.size(); i < size; i++) {
	    if (null != activityStack.get(i)) {
		
		activityStack.get(i).finish();
	    }
	}
	activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    @SuppressWarnings("deprecation")
    public void AppExit(Context context) {
	try {
	    finishAllActivity();
	    ActivityManager activityMgr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	    activityMgr.restartPackage(context.getPackageName());
	    System.exit(0);
	} catch (Exception e) {
	}
    }
}
