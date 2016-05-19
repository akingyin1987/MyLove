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



import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * 通过SharedPreferences 对一些简单配置数据增、删、改、查
 * 
 * @author king
 * 
 */
public class SharedPreferenceHelp {

	public static String DEFAULT_STTING_INFO = "SETTING_INFO";// 设置XML的名称

	public static final String DEFAULT_STRING_VALUE = "";

	public static final int DEFAULT_INT_VALUE = 0;

	public static final float DEFAULT_FLOAD_VALUE = 0f;

	public static final long DEFAULT_LONG_VALUE = 0l;

	public static final boolean DEFAULT_BOOLEAN_VALUE = false;

	public static final int DEFAULT_MODEL = 0;

	private SharedPreferences setting;

	@SuppressWarnings("unused")
	private Context content;

	public SharedPreferences getSetting() {
		return setting;
	}

	public SharedPreferenceHelp(Context context) {
		init(context);
	}

	public SharedPreferenceHelp(Context context, String xmlName) {
		init(context, xmlName);
	}

	private void init(Context context, String xmlName) {
		this.content = context;
		
		if (!TextUtils.isEmpty(xmlName)) {
			setting = context.getSharedPreferences(xmlName, Context.MODE_PRIVATE);
		} else {
			setting = context.getSharedPreferences(DEFAULT_STTING_INFO, Context.MODE_PRIVATE);
		}

	}

	private void init(Context context) {
		init(context, DEFAULT_STTING_INFO);
	}

	/**
	 * 查询数据 String数据
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
              
		return setting.getString(key, DEFAULT_STRING_VALUE);
	}

	/**
	 * 查询boolean 类型数据
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		return setting.getBoolean(key, DEFAULT_BOOLEAN_VALUE);
	}

	/**
	 * 获取int 类型数据
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key) {
		return setting.getInt(key, DEFAULT_INT_VALUE);
	}

	/**
	 * 添加数据String类型数据
	 * 
	 * @param key
	 * @param value
	 *            String
	 * @return
	 */
	public boolean insertValue(String key, String value) {

		return setting.edit().putString(key, value).commit();

	}

	/**
	 * 添加Boolean 类型数据
	 * 
	 * @param key
	 * @param b
	 * @return
	 */
	public boolean insertValue(String key, boolean b) {

		return setting.edit().putBoolean(key, b).commit();
	}

	/**
	 * 添加int 类型数据
	 * 
	 * @param key
	 * @param k
	 * @return
	 */
	public boolean insertValue(String key, int k) {

		return setting.edit().putInt(key, k).commit();
	}

	public boolean insertValue(String key, long value) {
		return setting.edit().putLong(key, value).commit();
	}

	public long getLong(String key) {
		return setting.getLong(key, DEFAULT_LONG_VALUE);
	}
	
	public  void   DelectValue(String  key){
		setting.edit().remove(key).commit();
	}


}
