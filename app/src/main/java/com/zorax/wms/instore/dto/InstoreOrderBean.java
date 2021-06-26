package com.zorax.wms.instore.dto;

/**
 * @创作者 czp
 * @创作时间 2021/6/26 9:43
 * @描述
 */
public class InstoreOrderBean {
    private String singleMaterialNum;

    private String singleProductType;

    private int quantity;

    public String getSingleMaterialNum() {
        return singleMaterialNum;
    }

    public InstoreOrderBean setSingleMaterialNum(String singleMaterialNum) {
        this.singleMaterialNum = singleMaterialNum;
        return this;
    }

    public String getSingleProductType() {
        return singleProductType;
    }

    public InstoreOrderBean setSingleProductType(String singleProductType) {
        this.singleProductType = singleProductType;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public InstoreOrderBean setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
