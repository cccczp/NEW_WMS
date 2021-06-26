package com.zorax.wms.instore.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.instore.dto.InstoreBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @创作者 czp
 * @创作时间 2021/6/25 16:08
 * @描述
 */
public class InstoreAdapter extends RecyclerView.Adapter {

    private final ArrayList<InstoreBean> mData;
    private List<Boolean> isClicks;
    private OnItemClickListener mListener = null;


    public InstoreAdapter(ArrayList<InstoreBean> data) {
        mData = data;
        isClicks = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            isClicks.add(false);
        }
    }

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickListener) {
        this.mListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_instore_index, parent, false);
        InstoreViewHolder viewHolder = new InstoreViewHolder(inflate);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((InstoreViewHolder) holder).orderNo.setText(mData.get(position).getOrderNo());
        ((InstoreViewHolder) holder).quantity.setText(String.valueOf(mData.get(position).getQuantity()));
        ((InstoreViewHolder) holder).asn.setText(mData.get(position).getAsn());
        ((InstoreViewHolder) holder).orderType.setText(mData.get(position).getOrderType());
        ((InstoreViewHolder) holder).orderDate.setText(mData.get(position).getOrderDate());
        ((InstoreViewHolder) holder).shipper.setText(mData.get(position).getShipper());
        if (isClicks.get(position)) {
            ((InstoreViewHolder) holder).mRelativeLayout.setBackgroundResource(R.drawable.item_instore_index_rl_checked);
            ((InstoreViewHolder) holder).mImageView.setVisibility(View.VISIBLE);
        } else {
            ((InstoreViewHolder) holder).mRelativeLayout.setBackgroundResource(R.drawable.item_instore_index_rl);
            ((InstoreViewHolder) holder).mImageView.setVisibility(View.INVISIBLE);
        }
        // 如果设置了回调，则设置点击事件
        if (mListener != null) {
            ((InstoreViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < isClicks.size(); i++) {
                        isClicks.set(i, false);
                    }
                    isClicks.set(position, true);
                    notifyDataSetChanged();
                    mListener.onItemClick(holder.itemView, mData.get(position).getAsn(), position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class InstoreViewHolder extends RecyclerView.ViewHolder {
        TextView quantity;
        TextView orderNo;
        TextView asn;
        TextView orderType;
        TextView orderDate;
        TextView shipper;
        ImageView mImageView;
        RelativeLayout mRelativeLayout;

        public InstoreViewHolder(@NonNull View itemView) {
            super(itemView);
            mRelativeLayout = itemView.findViewById(R.id.item_instore_index_rl);
            orderNo = itemView.findViewById(R.id.item_instore_index_head_tv_left);
            quantity = itemView.findViewById(R.id.item_instore_index_head_tv_right);
            asn = itemView.findViewById(R.id.item_instore_index_asn_tv_right);
            orderType = itemView.findViewById(R.id.item_instore_index_order_type_tv_right);
            orderDate = itemView.findViewById(R.id.item_instore_index_order_date_tv_right);
            shipper = itemView.findViewById(R.id.item_instore_index_shipper_tv_right);
            mImageView = itemView.findViewById(R.id.item_instore_index_iv);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, String san, int position);
    }
}
