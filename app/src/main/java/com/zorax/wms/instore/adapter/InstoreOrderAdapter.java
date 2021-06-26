package com.zorax.wms.instore.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.instore.dto.InstoreOrderBean;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/26 9:42
 * @描述
 */
public class InstoreOrderAdapter extends RecyclerView.Adapter<InstoreOrderAdapter.InstoreOrderViewHolder> {

    private final ArrayList<InstoreOrderBean> mData;
    private final Activity mContext;

    public InstoreOrderAdapter(Activity context,ArrayList<InstoreOrderBean> data) {
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public InstoreOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_instore_order_fragment, parent, false);
        InstoreOrderViewHolder holder = new InstoreOrderViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull InstoreOrderViewHolder holder, int position) {
        holder.singleMaterialNumTv.setText(mData.get(position).getSingleMaterialNum());
        holder.singleProductTypeTv.setText(mData.get(position).getSingleProductType());
        holder.quantityTv.setText(String.valueOf(mData.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class InstoreOrderViewHolder extends RecyclerView.ViewHolder {
        TextView singleMaterialNumTv;
        TextView singleProductTypeTv;
        TextView quantityTv;

        public InstoreOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            singleMaterialNumTv = itemView.findViewById(R.id.item_instore_order_fragment_singlematerialnum_tv_demo);
            singleProductTypeTv = itemView.findViewById(R.id.item_instore_order_fragment_singleproducttype_tv_demo);
            quantityTv = itemView.findViewById(R.id.item_instore_order_fragment_quantity_tv_demo);
        }
    }
}
