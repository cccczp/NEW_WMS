package com.zorax.wms.setting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zorax.wms.R;
import com.zorax.wms.setting.dto.WarehouseBean;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/22 14:57
 * @描述
 */
public class SettingAdapter extends RecyclerView.Adapter {

    private final ArrayList<WarehouseBean> mBeans;

    public SettingAdapter(ArrayList<WarehouseBean> beans) {
        mBeans = beans;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == WarehouseBean.IWarehouseItemType.VERTICAL)
        {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting_fragment, parent, false);
            SettingViewHolder viewHolder = new SettingViewHolder(inflate);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SettingViewHolder)
        {
            WarehouseBean warehouseBean = mBeans.get(position);
            ((SettingViewHolder)holder).mRadioButton.setText(warehouseBean.getWarehouseName());
            ((SettingViewHolder)holder).mRadioButton.setTag(position);
        }
    }

    @Override
    public int getItemCount() {
        return this.mBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mBeans.get(position).getItemType();
    }

    public class SettingViewHolder extends RecyclerView.ViewHolder {
        private RadioButton mRadioButton;

        public SettingViewHolder(@NonNull View itemView) {
            super(itemView);
            mRadioButton = itemView.findViewById(R.id.item_settiong_rb);
        }
    }

}
