package com.zorax.wms.check.dto;

import java.util.ArrayList;

/**
 * @创作者 czp
 * @创作时间 2021/6/23 20:20
 * @描述
 */
public class CheckBeanDataManager {
    public static ArrayList<CheckBean> getData()
    {
        ArrayList<CheckBean> beans = new ArrayList<>();
        CheckBean checkBean = null;
        String a = "AAA_";
        for (int i = 0; i < 5 ; i++) {
            checkBean = new CheckBean();
            String b = a + i;
            checkBean.setLocation(b).setTray(b).setSingleMaterialNum(b).setSingleProductType(b)
                    .setInstoreQty(i).setOutstoreQty(i).setInventoryQty(i).setActualQty(i);
            beans.add(checkBean);
        }
        return beans;
    }
}
