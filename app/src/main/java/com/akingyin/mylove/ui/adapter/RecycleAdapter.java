/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.ui.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akingyin.librarys.adapter.recyclerview.SuperAdapter;
import com.akingyin.mylove.data.model.ItemBean;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/20 15:01
 * @ Version V1.0
 */
public class RecycleAdapter extends SuperAdapter<ItemBean,ItemviewHolder>{

  public RecycleAdapter(Context context) {
    super(context);
  }

  @Override public ItemviewHolder onCreate(View convertView, ViewGroup parent, int viewType) {
      System.out.println("content==="+(null == getContext()));
    return new ItemviewHolder(LayoutInflater.from(getContext()),null);
  }

  @Override
  public void onBind(ItemviewHolder holder, int viewType, int layoutPosition, ItemBean item) {
       holder.getTvItem().setText(item.itemName);
  }
}
