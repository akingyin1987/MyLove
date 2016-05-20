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

/**
 * <p>Methods about header and footer.</p>
 * Created by Cheney on 16/1/12.
 */
public interface IHeaderFooter {
    View getHeaderView();

    View getFooterView();

    void addHeaderView(View header);

    void addFooterView(View footer);

    boolean removeHeaderView();

    boolean removeFooterView();

    boolean hasHeaderView();

    boolean hasFooterView();

    boolean isHeaderView(int position);

    boolean isFooterView(int position);
}
