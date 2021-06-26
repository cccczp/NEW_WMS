package com.zorax.wms.instore.dto;

import com.zorax.wms.instore.dto.InstoreBean;
import com.zorax.wms.tool.DateUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * @创作者 czp
 * @创作时间 2021/6/25 16:45
 * @描述
 */
public class InstoreBeanDataManager {


    public static ArrayList<InstoreBean> getData()
    {
        ArrayList<InstoreBean> mList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            InstoreBean instoreBean = new InstoreBean();
            instoreBean.setOrderNo("CIT20210609001---" + i).setAsn("SLS1234456").setQuantity(200)
                    .setOrderType("采购入库").setOrderDate(DateUtil.format(new Date(),DateUtil.DEFAULT_FORMAT))
                    .setShipper("GREE-DG");
            mList.add(instoreBean);
        }
        return mList;
    }
}
