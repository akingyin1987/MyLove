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

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @ Description:
 * Recyclerview设置间隔
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/20 14:38
 * @ Version V1.0
 */
public class SpacesItemDecoration  extends  RecyclerView.ItemDecoration {

  private int space;

  public SpacesItemDecoration(int space) {
    this.space=space;
  }

  @Override
  public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
    outRect.left=space;
    outRect.right=space;
    outRect.bottom=space;
    if(parent.getChildAdapterPosition(view)==0){
      outRect.top=space;
    }
  }
}
