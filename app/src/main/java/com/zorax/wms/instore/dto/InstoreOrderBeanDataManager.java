package com.zorax.wms.instore.dto;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/26 9:58
 * @描述
 */
public class InstoreOrderBeanDataManager {

    public static ArrayList<InstoreOrderBean> getData() {
        ArrayList<InstoreOrderBean> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            InstoreOrderBean bean = new InstoreOrderBean();
            bean.setSingleMaterialNum("KA442N46300").setSingleProductType("KF-26W/NB02-3(含管) 顶").setQuantity(20);
            arrayList.add(bean);
        }
        return arrayList;
    }
}
