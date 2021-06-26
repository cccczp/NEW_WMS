package com.zorax.wms.check.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.check.dto.CheckBean;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/23 14:55
 * @描述
 */
public class CheckAdapter extends RecyclerView.Adapter {

    private final ArrayList<CheckBean> mData;

    public CheckAdapter(ArrayList<CheckBean> data)
    {
       this.mData = data;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_check, parent, false);
        CheckViewHolder checkViewHolder = new CheckViewHolder(inflate);
        return checkViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CheckBean checkBean = mData.get(position);
        ((CheckViewHolder)holder).location.setText(checkBean.getLocation());
        ((CheckViewHolder)holder).tray.setText(checkBean.getTray());
        ((CheckViewHolder)holder).singleMaterialNum.setText(checkBean.getSingleMaterialNum());
        ((CheckViewHolder)holder).singleProductType.setText(checkBean.getSingleProductType());
        ((CheckViewHolder)holder).instoreQty.setText(String.valueOf(checkBean.getInstoreQty()));
        ((CheckViewHolder)holder).outstoreQty.setText(String.valueOf(checkBean.getOutstoreQty()));
        ((CheckViewHolder)holder).inventoryQty.setText(String.valueOf(checkBean.getInventoryQty()));
        ((CheckViewHolder)holder).actualQty.setText(String.valueOf(checkBean.getActualQty()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class CheckViewHolder extends RecyclerView.ViewHolder
    {
        TextView location;
        TextView tray;
        TextView singleMaterialNum;
        TextView singleProductType;
        TextView instoreQty;
        TextView outstoreQty;
        TextView inventoryQty;
        EditText actualQty;

        public CheckViewHolder(@NonNull View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.item_check_location_demo);
            tray = itemView.findViewById(R.id.item_check_tray_demo);
            singleMaterialNum = itemView.findViewById(R.id.item_check_singlematerialnum_demo);
            singleProductType = itemView.findViewById(R.id.item_check_single_product_type_demo);
            instoreQty = itemView.findViewById(R.id.item_check_instore_qty_demo);
            outstoreQty = itemView.findViewById(R.id.item_check_outstore_qty_demo);
            inventoryQty = itemView.findViewById(R.id.item_check_inventory_qty_demo);
            actualQty = itemView.findViewById(R.id.item_check_actual_qty_demo);
        }
    }
}
