package com.zorax.wms.setting.dto;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/22 15:33
 * @描述
 */
public class WarehouseDataManager {
    public static ArrayList<WarehouseBean> getData()
    {
        ArrayList<WarehouseBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            WarehouseBean warehouseBean = new WarehouseBean();
            warehouseBean.setItemType(WarehouseBean.IWarehouseItemType.VERTICAL);
            warehouseBean.setWarehouseName("大岭山仓库");
            arrayList.add(warehouseBean);
        }
        return arrayList;
    }
}
