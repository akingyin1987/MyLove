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


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.akingyin.librarys.adapter.BaseViewHolder;
import com.akingyin.mylove.R;

public class ItemviewHolder extends BaseViewHolder {
  private TextView tvItem;

  public ItemviewHolder(LayoutInflater inflater, ViewGroup parent) {
    this(inflater.inflate(R.layout.itemview, parent, false));
  }

  public ItemviewHolder(View view) {
    super(view);
    tvItem = (TextView) view.findViewById(R.id.tv_item);
  }

  public TextView getTvItem() {
    return tvItem;
  }
}
