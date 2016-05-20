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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.akingyin.librarys.adapter.BaseViewHolder;
import com.akingyin.librarys.adapter.OnItemChildClickListener;
import com.akingyin.librarys.adapter.OnItemClickListener;

import com.akingyin.librarys.adapter.OnItemLongClickListener;
import com.akingyin.librarys.adapter.internal.ILayoutManager;
import com.akingyin.librarys.adapter.internal.IViewBindData;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description:
 *  当个适配器不包含helder,即单个itemView
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date ${DATE} ${TIME}
 * @ Version V1.0
 */
public abstract class CommonAdapter<T,V extends BaseViewHolder> extends RecyclerView.Adapter<V>
implements IViewBindData<T,V>,ILayoutManager{



    protected Context mContext;
    protected List<T> mList; // DataSources.

    protected int mLayoutResId;

    private OnItemChildClickListener  onItemChildClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    protected RecyclerView mRecyclerView;
    protected static final int TYPE_HEADER = -0x100;
    protected static final int TYPE_FOOTER = -0x101;
    private View mHeader;
    private View mFooter;

    /**
     * Constructor for single item view type.
     *
     * @param context     Context
     * @param list        Data list.
     * @param layoutResId {@link android.support.annotation.LayoutRes}
     */
    public CommonAdapter(Context context, List<T> list, int layoutResId) {
        this.mContext = context;
        this.mList = list == null ? new ArrayList<T>() : new ArrayList<>(list);
        this.mLayoutResId = layoutResId;

    }

    public CommonAdapter(Context  context){
        this.mContext = context;
        this.mList = new ArrayList<>();
        this.mLayoutResId = 0;

    }




    public Context getContext() {
        return mContext;
    }

    public List<T> getList() {
        return mList;
    }

    public OnItemChildClickListener getOnItemChildClickListener() {
        return onItemChildClickListener;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.onItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * How many items are in the data set represented by this RecyclerView.Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getItemCount() {
        int size = mList == null ? 0 : mList.size();

        return size;
    }



    /**
     * Get the type of View that will be created by {@link #} for the specified item.
     *
     * @param position The position of the item within the adapter's data set whose view type we
     *                 want.
     * @return An integer representing the type of View. Two views should share the same type if one
     * can be converted to the other in {@link #}. Note: Integers must be in the
     * range 0 to {@link #} - 1. {@link #} can
     * also be returned.
     * @see #
     */
    @Override
    public int getItemViewType(int position) {

        return 0;
    }





    @Override
    public V onCreateViewHolder(ViewGroup parent, final int viewType) {
        System.out.println("onCreateViewHolder="+viewType);
        final V holder=onCreate(null, parent, viewType);
        holder.setChildClickListener(onItemChildClickListener);
        if (!(holder.itemView instanceof AdapterView)) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(v, viewType, holder.getAdapterPosition());
                    }
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemLongClickListener != null) {
                        mOnItemLongClickListener.onItemLongClick(v, viewType, holder.getAdapterPosition());
                        return true;
                    }
                    return false;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(V holder, int position) {
        onBind(holder, 0, position, mList.get( position));

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (mRecyclerView != null && mRecyclerView != recyclerView)
            Log.i("BaseSuperAdapter", "Does not support multiple RecyclerViews now.");
        mRecyclerView = recyclerView;
        // Ensure a situation that add header or footer before setAdapter().

    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        mRecyclerView = null;
    }


    @Override
    public boolean hasLayoutManager() {
        return mRecyclerView != null && mRecyclerView.getLayoutManager() != null;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        return hasLayoutManager() ? mRecyclerView.getLayoutManager() : null;
    }

}
