/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.adapter.internal;

import android.view.View;
import android.view.ViewGroup;
import com.akingyin.librarys.adapter.BaseViewHolder;

/**
 * <p>Create and bind data to item view.</p>
 * Created by Cheney on 16/3/31.
 */
public interface IViewBindData<T, VH extends BaseViewHolder> {

    /**
     * @param convertView Support by
     * @param parent      Target container(ListView, GridView, RecyclerView,Spinner, etc.).
     * @param viewType    Choose the layout resource according to view type.
     * @return Created view holder.
     */
    VH onCreate(View convertView, ViewGroup parent, int viewType);

    /**
     * Method for binding data to view.
     *
     * @param holder         ViewHolder
     * @param viewType
     * @param layoutPosition position
     * @param item           data
     */
    void onBind(VH holder, int viewType, int layoutPosition, T item);
}
