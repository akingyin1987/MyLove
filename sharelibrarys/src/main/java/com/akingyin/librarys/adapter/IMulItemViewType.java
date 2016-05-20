/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.adapter;


/**
 * <p>Interface for multiple view types.</p>
 * Created by Cheney on 15/11/28.
 */
public interface IMulItemViewType<T> {

    /**
     * @return Will not be called if using a RecyclerView.
     */
    int getViewTypeCount();

    /**
     * Item view type, a non-negative integer is better.
     *
     * @param position current position of ViewHolder
     * @param t        model item
     * @return viewType
     */
    int getItemViewType(int position, T t);

    /**
     * Layout res.
     *
     * @param viewType {@link #getItemViewType(int, T)}
     * @return {@link android.support.annotation.LayoutRes}
     */
    int getLayoutId(int viewType);
}