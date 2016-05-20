/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.akingyin.librarys.adapter.BaseViewHolder;
import com.akingyin.librarys.adapter.internal.CRUD;
import com.akingyin.librarys.adapter.internal.SuperViewHolder;
import java.util.List;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/20 14:23
 * @ Version V1.0
 */
public  abstract class SuperAdapter<T,VH extends BaseViewHolder> extends CommonAdapter<T,VH> implements CRUD<T>{

  private final String TAG = "SuperAdapter";
  private LayoutInflater mLayoutInflater;

  /**
   * Constructor for single itemView type.
   */
  public SuperAdapter(Context context, List<T> items, int layoutResId) {
    super(context, items, layoutResId);
    this.mLayoutInflater = LayoutInflater.from(context);
  }

  public SuperAdapter(Context context) {
    super(context);
  }



  /**
   * ------------------------------------ CRUD ------------------------------------
   */

  @Override
  public final void add(T item) {
    mList.add(item);
    int location = mList.size() - 1;

      location++;
    notifyItemInserted(location);

  }

  @Override
  public void add(int location, T item) {
    mList.add(location, item);

    notifyItemInserted(location);

  }

  @Override
  public final void insert(int location, T item) {
    add(location, item);
  }

  @Override
  public final void addAll(List<T> items) {
    if (items == null || items.size() == 0) {
      Log.i(TAG, "The list you added is null or empty.");
      return;
    }
    int start = mList.size();
    mList.addAll(items);

    notifyItemRangeInserted(start, items.size());

  }

  @Override
  public void addAll(int location, List<T> items) {
    if (items == null || items.size() == 0) {
      Log.i(TAG, "The list you added is null or empty.");
      return;
    }
    mList.addAll(items);

    notifyItemRangeInserted(location, items.size());

  }

  @Override
  public final void remove(T item) {
    if (contains(item)) {
      remove(mList.indexOf(item));
    }
  }

  @Override
  public final void remove(int location) {
    mList.remove(location);

    notifyItemRemoved(location);

  }

  @Override
  public void removeAll(List<T> items) {
    mList.removeAll(items);
    notifyDataSetChanged(); // RecyclerView

  }

  @Override
  public void retainAll(List<T> items) {
    mList.retainAll(items);
    notifyDataSetChanged(); // RecyclerView

  }

  @Override
  public final void set(T oldItem, T newItem) {
    set(mList.indexOf(oldItem), newItem);
  }

  @Override
  public final void set(int location, T item) {
    mList.set(location, item);

    notifyItemChanged(location);

  }

  @Override
  public final void replaceAll(List<T> items) {
    clear();
    addAll(items);
  }

  @Override
  public final boolean contains(T item) {
    return mList.contains(item);
  }

  @Override
  public boolean containsAll(List<T> items) {
    return mList.containsAll(items);
  }

  @Override
  public final void clear() {
    mList.clear();
    notifyDataSetChanged();

  }


}
