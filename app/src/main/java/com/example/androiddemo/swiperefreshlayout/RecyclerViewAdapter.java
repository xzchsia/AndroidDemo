package com.example.androiddemo.swiperefreshlayout;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // 数据展示
    private List<String> mData;
    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0;  //普通Item View
    private static final int TYPE_FOOTER = 1;  //顶部FootView

    // Item点击事件回调监听
    public interface IOnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private IOnItemClickListener onItemClickListener;

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(IOnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public RecyclerViewAdapter() {
        this.mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            this.mData.add("item:" + i);
        }
    }

    //添加数据
    public void addItem(List<String> newDatas) {
        newDatas.addAll(this.mData);
        this.mData.removeAll(this.mData);
        this.mData.addAll(newDatas);
        notifyDataSetChanged();
    }

    // 上拉加载更多
    public void addMoreItem(List<String> data) {
        this.mData.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
            return (new ItemViewHolder(view));
        } else if (viewType == TYPE_FOOTER) {
            View footView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_load_more_layout, parent, false);
            return (new FootViewHolder(footView));
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        // 绑定数据
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).mTv.setText(mData.get(position));
            holder.itemView.setTag(position);
        } else if (holder instanceof FootViewHolder) {
            FootViewHolder footViewHolder = (FootViewHolder) holder;
            switch (load_more_status) {
                case PULLUP_LOAD_MORE:
                    footViewHolder.foot_view_item_tv.setText("上拉加载更多...");
                    break;
                case LOADING_MORE:
                    footViewHolder.foot_view_item_tv.setText("正在加载更多数据...");
                    break;
            }
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                // true表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    //重写getItemCount()方法,返回的Item数量在数据的基础上面+1，增加一项FootView布局项
    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size() + 1;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTv;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.rv_item_tv);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {
        private TextView foot_view_item_tv;

        public FootViewHolder(View itemView) {
            super(itemView);
            foot_view_item_tv = (TextView) itemView.findViewById(R.id.foot_view_item_tv);
        }
    }

    //重写getItemViewType方法来判断返回加载的布局的类型
    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        // 最后一个item设置为footerView
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }
    }

    /**
     * //上拉加载更多
     * PULLUP_LOAD_MORE=0;
     * //正在加载中
     * LOADING_MORE=1;
     * //加载完成已经没有更多数据了
     * NO_MORE_DATA=2;
     *
     * @param status
     */
    public void changeMoreStatus(int status) {
        load_more_status = status;
        notifyDataSetChanged();
    }
}
