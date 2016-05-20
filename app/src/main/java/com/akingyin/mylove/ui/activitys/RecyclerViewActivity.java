/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.mylove.ui.activitys;

import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.akingyin.librarys.netstatus.NetUtils;
import com.akingyin.mylove.R;
import com.akingyin.mylove.data.model.ItemBean;
import com.akingyin.mylove.ui.BaseActivity;
import com.akingyin.mylove.ui.adapter.RecycleAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/5/20 14:43
 * @ Version V1.0
 */
public class RecyclerViewActivity extends BaseActivity {

  @BindView(R.id.recyclerview)
  RecyclerView recyclerview;

  RecycleAdapter   adapter;



  @Override protected void onDestroy() {
    super.onDestroy();

  }

  @Override protected boolean isApplyKitKatTranslucency() {
    return true;
  }

  @Override protected void getBundleExtras(Bundle extras) {

  }

  @Override protected int getContentViewLayoutID() {
    return R.layout.welcome_page_4;
  }

  @Override protected View getLoadingTargetView() {
    return ButterKnife.findById(this,R.id.rocket_page4);
  }

  @Override
  protected void initViewsAndEvents() {
    ButterKnife.bind(this);
    adapter = new RecycleAdapter(this);
    List<ItemBean>  datas = new ArrayList<>();
    for(int i=0;i<20;i++){
      datas.add(new ItemBean("test="+i));
    }
    adapter.addAll(datas);
    recyclerview.setLayoutManager(new LinearLayoutManager(this));
    recyclerview.setItemAnimator(new DefaultItemAnimator());
    recyclerview.setAdapter(adapter);
  }

  @Override
  protected void onNetworkConnected(NetUtils.NetType type) {

  }

  @Override protected void onNetworkDisConnected() {

  }

  @Override protected boolean isApplyStatusBarTranslucency() {
    return true;
  }



  @Override protected boolean toggleOverridePendingTransition() {
     return true;
  }

  @Override protected TransitionMode getOverridePendingTransitionMode() {
    return TransitionMode.LEFT;
  }
}
